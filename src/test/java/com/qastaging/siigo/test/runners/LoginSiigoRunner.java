package com.qastaging.siigo.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_cliente_siigo.feature",
        glue = "com.qastaging.siigo.test.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = ""
)
public class LoginSiigoRunner {
}
