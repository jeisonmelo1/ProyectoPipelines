package com.advantageonlineshopping.interactions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.advantageonlineshopping.userinterface.LoginUI.*;

public class Interactions implements Interaction {

    private static final Logger logger = LoggerFactory.getLogger(Interactions.class);



    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ListOfWebElementFacades productNames = LBL_NOMBRE_PRODUCTO.resolveAllFor(actor);
        ListOfWebElementFacades productPrices = LBL_NOMBRE_PRECIO.resolveAllFor(actor);

        List<String> names = productNames.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> prices = productPrices.stream().map(WebElement::getText).collect(Collectors.toList());

        if (names.size() != prices.size()) {
            logger.error("Mismatch between product names and prices count: {} names, {} prices", names.size(), prices.size());
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            if (logger.isInfoEnabled()) {
                logger.info("Nombre Producto: {}, Precio: {}", names.get(i), prices.get(i));
            }
        }
    }
    public static Interactions on() {
        return Instrumented.instanceOf(Interactions.class).withProperties();
    }
}
