package com.qastaging.siigo.tasks;


import com.qastaging.siigo.interactions.EnterTextIntoShadowInput;
import com.qastaging.siigo.ui.LoginPageUserInterface;
import com.qastaging.siigo.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetLoginTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            SpecialMethods.configProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LoginPageUserInterface.HOST_SHADOW_USER)));

        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("username"))
                        .withHostSelector(LoginPageUserInterface.HOST_SHADOW_USER)
                        .withInnerInputSelector(LoginPageUserInterface.USERNAME_IMPUT).and()
        );
        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("pass"))
                        .withHostSelector(LoginPageUserInterface.HOST_SHADOW_PASS)
                        .withInnerInputSelector(LoginPageUserInterface.PASSWORD_IMPUT).and()
        );

        actor.attemptsTo(
                JavaScriptClick.on(LoginPageUserInterface.LOGIN_BUTTON)
        );


    }

    public static SetLoginTask loginSuccessfull() {
        return instrumented(SetLoginTask.class);
    }


}
