package com.picap.tasks.login;

import com.picap.ui.login.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.StringUtils;

public class LoginWith implements Task {

    private final String username;
    private String password = StringUtils.EMPTY;


    public LoginWith(String username) {
        this.username = username;
    }

    public static LoginWith username(String username) {
        return new LoginWith(username);
    }

    public LoginWith andPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LoginPage.SING_IN),
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.BTN_SING_IN)
        );
    }
}
