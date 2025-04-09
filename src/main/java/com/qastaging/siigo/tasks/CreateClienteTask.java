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

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateClienteTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)));

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)
                        .andClickOn(CreateClienteUserInterface.CREATE_BUTTON)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)
                        .andClickOn(CreateClienteUserInterface.CLIENTE_BUTTON)
                        .build()
        );

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CreateClienteUserInterface.SHADOW_TYPE_SELECT)));

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_SELECT)
                        .andClickOn(CreateClienteUserInterface.TYPE_SELECT)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(String.valueOf(CreateClienteUserInterface.SELECT_PERSON_TYPE.of("Es persona")))
                        .build()
        );

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(CreateClienteUserInterface.SELECT_TYPE)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(String.valueOf(CreateClienteUserInterface.SELECT_LIST_TYPE.of("Cédula de ciudadanía")))
                        .build()

        );
        actor.attemptsTo(
                EnterTextIntoShadowInput.withText("1062684855")
                        .withHostSelector(CreateClienteUserInterface.SHADOW_INPUT_IDENTIFICATION)
                        .withInnerInputSelector(CreateClienteUserInterface.INPUT_IDENTIFICATION).and()
        );


        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CreateClienteUserInterface.SHADOW_NAME)));

        actor.attemptsTo(
                EnterTextIntoShadowInput.withText("Zair")
                        .withHostSelector(CreateClienteUserInterface.SHADOW_NAME)
                        .withInnerInputSelector(String.valueOf(CreateClienteUserInterface.INPUT_NAME)).and()
        );
        actor.attemptsTo(
                EnterTextIntoShadowInput.withText("Osorio")
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
                EnterTextIntoShadowInput.withText("monteria")
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
