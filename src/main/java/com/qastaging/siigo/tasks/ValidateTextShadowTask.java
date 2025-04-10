package com.qastaging.siigo.tasks;

import com.qastaging.siigo.ui.CreateClienteUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.is;

public class ValidateTextShadowTask implements Task {

    private String type;

    public ValidateTextShadowTask(String type) {
        this.type = type;
    }

    public static ValidateTextShadowTask validateTextShadowTask(String type){
        return instrumented(ValidateTextShadowTask.class,type);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.should(
                seeThat("Validar texto dentro del Shadow DOM",
                        com.qastaging.siigo.questions.ShadowTextQuestion.of(CreateClienteUserInterface.SHADOW_TYPE_IDENTIFY
                                ,
                                CreateClienteUserInterface.SELECT_PERSON_TYPE.of(type).toString()
                        ),
                        is(type)
                )
        );



    }
}
