package com.qastaging.siigo.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/loginSiigo.feature",
        glue = "com.qastaging.siigo.test.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@login"
)
public class LoginSiigoRunner {
}
