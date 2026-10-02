package com.advantageonlineshopping.questions;


import com.advantageonlineshopping.exeptions.SerenityCustomException;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.advantageonlineshopping.userinterface.LoginUI.LBL_NOMBRE;

public class CustomQuestion implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(CustomQuestion.class);

    private final String expectedUsuario;


    public CustomQuestion(String expectedUsuario) {
        this.expectedUsuario = expectedUsuario;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            boolean someCondition = expectedUsuario.equals(LBL_NOMBRE.resolveFor(actor).getText());


            if (!someCondition) {
                throw new SerenityCustomException("El usuario se encuentra en la pagina");
            }
            return true;
        } catch (SerenityCustomException e) {
            logger.error("Caught custom exception: {}", e.getMessage());
            return false;
        }
    }

    public static CustomQuestion isConditionMet(String expectedUsuario) {
        return new CustomQuestion(expectedUsuario);
    }
}