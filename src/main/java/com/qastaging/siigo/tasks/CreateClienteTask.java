package com.qastaging.siigo.tasks;

import com.qastaging.siigo.interactions.ClickOnShadowElement;
import com.qastaging.siigo.ui.CreateClienteUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
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
                        .build()
        );

        actor.attemptsTo(
                ClickOnShadowElement.onHost(CreateClienteUserInterface.SHADOW_CREATE_BUTTON)
                        .andClickOn(CreateClienteUserInterface.CLIENTE_BUTTON)
                        .build()
        );
    }

    public static CreateClienteTask createClient() {
        return instrumented(CreateClienteTask.class);
    }
}
