package com.qastaging.siigo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ClickOnShadowElement implements Task {
    private final String hostSelector;
    private final String innerElementSelector;

    public ClickOnShadowElement(String hostSelector, String innerElementSelector) {
        this.hostSelector = hostSelector;
        this.innerElementSelector = innerElementSelector;
    }

    public static ClickOnShadowElementBuilder onHost(String hostSelector) {
        return new ClickOnShadowElementBuilder(hostSelector);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement host = BrowseTheWeb.as(actor).find(By.cssSelector(hostSelector));

        String script = String.format(
                "const el = arguments[0].shadowRoot.querySelector('%s');" +
                        "if (el) el.click();" +
                        "return el;",
                escapeJavaScript(innerElementSelector)
        );

        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript(script, host);
    }

    private String escapeJavaScript(String selector) {
        return selector.replace("'", "\\'")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    public static final class ClickOnShadowElementBuilder {
        private final String hostSelector;
        private String innerElementSelector;

        public ClickOnShadowElementBuilder(String hostSelector) {
            this.hostSelector = hostSelector;
        }

        public ClickOnShadowElementBuilder andClickOn(String innerElementSelector) {
            this.innerElementSelector = innerElementSelector;
            return this;
        }

        public ClickOnShadowElement build() {
            return new ClickOnShadowElement(hostSelector, innerElementSelector);
        }

        public Task buildTask() {
            return build();
        }
    }
}
