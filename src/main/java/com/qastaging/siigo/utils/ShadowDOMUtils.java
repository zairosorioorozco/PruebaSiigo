package com.qastaging.siigo.utils;

import org.openqa.selenium.*;

public class ShadowDOMUtils {

    public static WebElement expandRootElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
    }

    public static WebElement findNestedShadowElement(WebDriver driver, By... selectors) {
        WebElement shadowHost = driver.findElement(selectors[0]);
        WebElement shadowRoot = expandRootElement(shadowHost, driver);

        for (int i = 1; i < selectors.length - 1; i++) {
            shadowHost = shadowRoot.findElement(selectors[i]);
            shadowRoot = expandRootElement(shadowHost, driver);
        }

        return shadowRoot.findElement(selectors[selectors.length - 1]);
    }
}
