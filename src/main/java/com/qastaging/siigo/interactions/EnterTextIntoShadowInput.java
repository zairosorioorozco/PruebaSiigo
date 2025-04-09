package com.qastaging.siigo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class EnterTextIntoShadowInput implements Task {
    private final String text;
    private final String hostSelector;
    private final String innerInputSelector;

    public EnterTextIntoShadowInput(String text, String hostSelector, String innerInputSelector) {
        this.text = text;
        this.hostSelector = hostSelector;
        this.innerInputSelector = innerInputSelector;
    }

    public static EnterTextIntoShadowInputBuilder withText(String text) {
        return new EnterTextIntoShadowInputBuilder(text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement host = BrowseTheWeb.as(actor).find(By.cssSelector(hostSelector));

        String script = String.format(
                "const input = arguments[0].shadowRoot.querySelector('%s');" +
                        "input.value = arguments[1];" +
                        "input.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "return input;",
                escapeJavaScript(innerInputSelector)
        );

        WebElement input = (WebElement) ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript(script, host, text);
    }

    private String escapeJavaScript(String selector) {
        return selector.replace("'", "\\'")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    public static final class EnterTextIntoShadowInputBuilder {
        private final String text;
        private String hostSelector;
        private String innerInputSelector;

        public EnterTextIntoShadowInputBuilder(String text) {
            this.text = text;
        }

        public EnterTextIntoShadowInputBuilder withHostSelector(String hostSelector) {
            this.hostSelector = hostSelector;
            return this;
        }

        public EnterTextIntoShadowInputBuilder withInnerInputSelector(String innerInputSelector) {
            this.innerInputSelector = innerInputSelector;
            return this;
        }

        public EnterTextIntoShadowInput build() {
            return new EnterTextIntoShadowInput(text, hostSelector, innerInputSelector);
        }

        public Task and() {
            return build();
        }
    }
}