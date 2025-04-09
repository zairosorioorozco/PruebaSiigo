package com.qastaging.siigo.interactions;

import com.qastaging.siigo.ui.CreateClienteUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ClickCrearButton implements Task {

    public static ClickCrearButton click() {
        return Tasks.instrumented(ClickCrearButton.class);
    }

    @Override
    @Step("Click en el botón Crear dentro de shadow DOM")
    public <T extends Actor> void performAs(T actor) {



    }

}
