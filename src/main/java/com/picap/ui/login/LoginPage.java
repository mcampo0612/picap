package com.picap.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target SING_IN = Target
            .the("btn sing in")
            .located(By.xpath("//div[@class='header_user_info']"));

    public static final Target USERNAME = Target
            .the("username txt")
            .located(By.id("email"));

    public static final Target PASSWORD = Target
            .the("password txt")
            .located(By.id("passwd"));

    public static final Target BTN_SING_IN = Target
            .the("Click btn")
            .located(By.id("SubmitLogin"));
}
