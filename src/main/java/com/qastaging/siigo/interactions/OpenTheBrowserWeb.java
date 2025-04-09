package com.qastaging.siigo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheBrowserWeb implements Interaction {
    private String url;

    public OpenTheBrowserWeb(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static Performable on(String url) {
        return new OpenTheBrowserWeb(url);
    }


}
