package com.qastaging.siigo.quiestions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class CreateClienteValidationQuestions implements Question<Boolean> {
    private Target target;

    public CreateClienteValidationQuestions(Target target){
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }

    public static CreateClienteValidationQuestions in(Target target){
        return new CreateClienteValidationQuestions(target);
    }


}
