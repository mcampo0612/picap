package com.picap.tasks.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class NavigateTo {

    public static Performable loginPage() {
        return Task.where("{0} opens the Login  page",
                Open.url(theActorInTheSpotlight().recall("baseUrl")));
    }

}
