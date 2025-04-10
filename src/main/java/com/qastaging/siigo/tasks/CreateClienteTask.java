package com.qastaging.siigo.tasks;

import com.qastaging.siigo.interactions.ClickOnShadowElement;
import com.qastaging.siigo.interactions.EnterTextIntoShadowInput;
import com.qastaging.siigo.ui.CreateClienteUserInterface;
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

public class CreateClienteTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            SpecialMethods.configProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();


        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(CreateClienteUserInterface.SELECT_TYPE)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(String.valueOf(CreateClienteUserInterface.SELECT_LIST_TYPE.of("Cédula de ciudadanía")))
                        .build()

        );
        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("identify"))
                        .withHostSelector(CreateClienteUserInterface.SHADOW_INPUT_IDENTIFICATION)
                        .withInnerInputSelector(CreateClienteUserInterface.INPUT_IDENTIFICATION).and()
        );


        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CreateClienteUserInterface.SHADOW_NAME)));

        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("name"))
                        .withHostSelector(CreateClienteUserInterface.SHADOW_NAME)
                        .withInnerInputSelector(String.valueOf(CreateClienteUserInterface.INPUT_NAME)).and()
        );
        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("lastname"))
                        .withHostSelector(CreateClienteUserInterface.SHADOW_LAST_NAME)
                        .withInnerInputSelector(CreateClienteUserInterface.INPUT_NAME).and()
        );

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CreateClienteUserInterface.SHADOW_CITY)));

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CITY)
                        .andClickOn(CreateClienteUserInterface.LABEL_CITY)
                        .build()
        );

        actor.attemptsTo(
                EnterTextIntoShadowInput.withText(SpecialMethods.properties.getProperty("city"))
                        .withHostSelector(CreateClienteUserInterface.SHADOW_CITY)
                        .withInnerInputSelector(CreateClienteUserInterface.INPUT_CITY).and()
        );
        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CITY)
                        .andClickOn(CreateClienteUserInterface.SELECT_AUTO_COMPLETE)
                        .build()
        );

        actor.attemptsTo(
                JavaScriptClick.on(
                        CreateClienteUserInterface.SAVE_BUTTON
                )
        );
    }

    public static CreateClienteTask createClient() {
        return instrumented(CreateClienteTask.class);
    }
}
