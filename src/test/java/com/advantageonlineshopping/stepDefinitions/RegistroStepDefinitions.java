package com.advantageonlineshopping.stepDefinitions;

import com.advantageonlineshopping.models.AdvantageLoombokData;
import com.advantageonlineshopping.taks.LoginTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;


import static com.advantageonlineshopping.userinterface.LoginUI.LBL_NOMBRE;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class RegistroStepDefinitions {


    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }


    @Dado("Que me encuentro en la pagina de registro de advantage {string}")
    public void queMeEncuentroEnLaPaginaDeRegistroDeAdvantage(String url) {
        WebDriverManager.chromedriver().setup();
        theActorCalled("Test").wasAbleTo(Open.url(url));

    }
    @Cuando("Realizo el ingreso de mi informacion")
    public void realizoElIngresoDeMiInformacion(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.on(AdvantageLoombokData.setData(table).get(0))

        );


    }
    @Entonces("Se visualizaria el menu principal {string}")
    public void seVisualizariaElMenuPrincipal(String validacion) {


   //     Ensure.that(LBL_NOMBRE).text().isEqualTo(validacion);


    }
}
