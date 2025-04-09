package com.qastaging.siigo.tasks;

import com.qastaging.siigo.quiestions.CreateClienteValidationQuestions;
import com.qastaging.siigo.ui.CreateClienteUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.is;


public class CreateClientValidations implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat("The type selection is valid",
                        CreateClienteValidationQuestions.in(CreateClienteUserInterface.SELECT_LIST_TYPE),
                        is(true)
                )
        );

    }

    public static CreateClientValidations validations(){
        return instrumented(CreateClientValidations.class);
    }

}
