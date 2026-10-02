package com.advantageonlineshopping.taks;

import com.advantageonlineshopping.exeptions.SerenityCustomException;
import com.advantageonlineshopping.interactions.Interactions;
import com.advantageonlineshopping.models.AdvantageLoombokData;
import com.advantageonlineshopping.questions.CustomQuestion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.advantageonlineshopping.userinterface.LoginUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private static final String USUARIO = System.getenv("ADVANTAGE_USERNAME");
    private static final String CLAVE = System.getenv("ADVANTAGE_PASSWORD");

    private final AdvantageLoombokData datos;

    public LoginTask(AdvantageLoombokData datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (USUARIO == null || CLAVE == null) {
            throw new IllegalStateException("Defina ADVANTAGE_USERNAME y ADVANTAGE_PASSWORD antes de ejecutar la prueba");
        }

        actor.attemptsTo(

                Click.on(BTN_INICIO),
                Enter.keyValues(USUARIO).into(TXT_USUARIO),
                Enter.keyValues(CLAVE).into(TXT_ClAVE),
                Click.on(BTN_INICIAR),
                WaitUntil.the(LBL_NOMBRE, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_BUSCAR),
                WaitUntil.the(TXT_BUSCAR, isVisible()).forNoMoreThan(15).seconds(),
                Enter.keyValues(datos.getBusqueda()).into(TXT_BUSCAR).thenHit(Keys.ENTER),
                WaitUntil.the(LBL_NOMBRE_PRODUCTO, isVisible()).forNoMoreThan(15).seconds(),
                Interactions.on()


        );


        Assert.assertEquals(USUARIO, LBL_NOMBRE.resolveFor(actor).getText());

        boolean isUsuarioCorrecto = USUARIO.equals(LBL_NOMBRE.resolveFor(actor).getText());

        if (!isUsuarioCorrecto) {
            throw new SerenityCustomException("El usuario no coincide: esperado " + USUARIO + " pero se obtuvo " + LBL_NOMBRE.resolveFor(actor).getText());
        }


        actor.should(
            GivenWhenThen.seeThat(CustomQuestion.isConditionMet(USUARIO))
        );


    }

    public static LoginTask on(AdvantageLoombokData datos) {
        return Instrumented.instanceOf(LoginTask.class).withProperties(datos);
    }


}
