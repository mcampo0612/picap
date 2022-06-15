package com.picap.tasks.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static com.picap.tasks.navigate.NavigateTo.loginPage;

public class NavigateToCreate {

    public static Performable registerStudent() {
        return Task.where("{0} navigates to register students",
                loginPage()
        );
    }
}
