package com.qastaging.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class ShadowTextQuestion implements Question<String> {

    private final String host;
    private final String shadowSelector;

    public ShadowTextQuestion(String host, String shadowSelector) {
        this.host = host;
        this.shadowSelector = shadowSelector;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebElement shadowHost = driver.findElement(By.cssSelector(host));
        WebElement shadowRoot = (WebElement) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", shadowHost);

        WebElement shadowElement = shadowRoot.findElement(By.cssSelector(shadowSelector));
        return shadowElement.getText();
    }

    public static com.qastaging.siigo.questions.ShadowTextQuestion of(String host, String shadowSelector) {
        return new com.qastaging.siigo.questions.ShadowTextQuestion(host, shadowSelector);
    }
}
