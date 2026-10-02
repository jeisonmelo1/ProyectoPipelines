package com.advantageonlineshopping.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUI {


    public static final Target BTN_INICIO= Target.the("boton continuar en el home")
            .locatedBy("//a[@id='menuUserLink']");

    public static final Target  TXT_USUARIO = Target.the("barra para ingresar usuario")
            .locatedBy("//input[@name='username']");

    public static final Target  TXT_ClAVE = Target.the("barra para ingresar clave")
            .locatedBy("//input[@name='password']");

    public static final Target BTN_INICIAR= Target.the("boton de iniciar sesion")
            .locatedBy("//button[@id='sign_in_btn']");

    public static final Target  BTN_BUSCAR = Target.the("boton barra para busqueda")
            .locatedBy("//div[@id='input']");

    public static final Target  TXT_BUSCAR = Target.the("barra para busqueda")
            .locatedBy("//input[@id='autoComplete']");

    public static final Target  LBL_NOMBRE = Target.the("barra de validacion nombre")
            .locatedBy("//a[@id='menuUserLink']/span");

    public static final Target  LBL_NOMBRE_PRODUCTO = Target.the("barra de validacion producto")
            .locatedBy("//a[contains(@class, 'product') and .//img[contains(@data-ng-src, '/catalog/fetchImage?image_id=')]]/p");

    public static final Target  LBL_NOMBRE_PRECIO= Target.the("barra para busqueda")
            .locatedBy("//a[contains(@class, 'product') and .//img[contains(@data-ng-src, '/catalog/fetchImage?image_id=')]]/span");


    private LoginUI() {
        throw new UnsupportedOperationException("Utility class");
    }

}
