package com.qastaging.siigo.test.stepdefinitions;

import com.qastaging.siigo.interactions.ClickCreateClientInteractions;
import com.qastaging.siigo.interactions.OpenTheBrowserWeb;
import com.qastaging.siigo.tasks.CreateClientValidations;
import com.qastaging.siigo.tasks.CreateClienteTask;
import com.qastaging.siigo.tasks.SetLoginTask;
import com.qastaging.siigo.tasks.ValidateTextShadowTask;
import com.qastaging.siigo.ui.CreateClienteUserInterface;
import com.qastaging.siigo.ui.LoginPageUserInterface;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginStepDefinitions {


    @Managed
    private WebDriver driver;

    @Before
    public void actorSetUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("name").can(BrowseTheWeb.with(driver));
    }

    @Given("^el usuario accede a la página de login$")
    public void elUsuarioAccedeALaPáginaDeLogin() {
        theActorInTheSpotlight().attemptsTo(OpenTheBrowserWeb.on(LoginPageUserInterface.URL));
    }

    @When("^hago login con credenciales validas")
    public void hagoLoginCredencialesValida() {
        theActorInTheSpotlight().attemptsTo(SetLoginTask.loginSuccessfull());
    }


    @And("^crear cliente$")
    public void crearCliente() {
        theActorInTheSpotlight().attemptsTo(
                ClickCreateClientInteractions.clientInteractions("Es Persona"),
                CreateClienteTask.createClient());
    }

    @Then("^valido cliente creado con exito$")
    public void validoClienteCreadoConExito() {
       theActorInTheSpotlight().attemptsTo(CreateClientValidations.validations());
    }

    @When("^selecciona el tipo (.*)")
    public void seleccionaElTipoPersona(String type) {
        theActorInTheSpotlight().attemptsTo(
                ClickCreateClientInteractions.clientInteractions(type));

    }

    @Then("^el sistema acepta la selección sin errores$")
    public void elSistemaAceptaLaSelecciónSinErrores() {
        theActorInTheSpotlight().attemptsTo(
                ValidateTextShadowTask.validateTextShadowTask("Es Persona"));
    }
}
