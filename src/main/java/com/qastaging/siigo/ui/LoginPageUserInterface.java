package com.qastaging.siigo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginPageUserInterface {

    public static  String URL = "https://qastaging.siigo.com/#/login";

    public static final String HOST_SHADOW_USER = "input-atom[id='username']";
    public static final String HOST_SHADOW_PASS = "input-atom[id='current-password']";
    public static final String USERNAME_IMPUT = "input[name='username-input']";
    public static final String PASSWORD_IMPUT = "#password-input";
    public static final Target LOGIN_BUTTON = Target.the("Login Button").located(By.cssSelector("#login-submit"));


}
