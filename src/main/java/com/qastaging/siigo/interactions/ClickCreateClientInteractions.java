package com.qastaging.siigo.interactions;

import com.qastaging.siigo.ui.CreateClienteUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickCreateClientInteractions implements Interaction {

    private String type;

    public ClickCreateClientInteractions(String type) {
        this.type = type;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)));

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)
                        .andClickOn(CreateClienteUserInterface.CREATE_BUTTON)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)
                        .andClickOn(CreateClienteUserInterface.CLIENTE_BUTTON)
                        .build()
        );

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(CreateClienteUserInterface.SHADOW_TYPE_SELECT)));

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_SELECT)
                        .andClickOn(CreateClienteUserInterface.TYPE_SELECT)
                        .build(),
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY)
                        .andClickOn(String.valueOf(CreateClienteUserInterface.SELECT_PERSON_TYPE.of(type)))
                        .build()
        );
    }

    public static ClickCreateClientInteractions clientInteractions(String type){
        return instrumented(ClickCreateClientInteractions.class,type);
    }


}
