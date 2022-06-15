package com.picap.interactions.registerclient;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Path;

import static com.picap.ui.registerclient.RegisterStudentPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToRegisterStudent {

    public static Performable firstName(String firstName) {
        return Task.where("{0} add a first name #firstName",
                Click.on(FIRST_NAME)
                        .then(Enter.theValue(firstName).into(FIRST_NAME))
        ).with("firstName").of(firstName);
    }

    public static Performable lastName(String lastName) {
        return Task.where("{0} add a last name #lastName",
                Click.on(LAST_NAME)
                        .then(Enter.theValue(lastName).into(LAST_NAME))
        ).with("lastName").of(lastName);
    }

    public static Performable email(String email) {
        return Task.where("{0} add a email #email",
                Click.on(EMAIL)
                        .then(Enter.theValue(email).into(EMAIL))
        ).with("email").of(email);
    }

    public static Performable gender() {
        return Task.where("{0} add a gender #gender",
                Click.on(GENDER)
        );
    }

    public static Performable mobile(String mobile) {
        return Task.where("{0} add a mobile #mobile",
                Scroll.to(EMAIL),
                Click.on(MOBILE)
                        .then(Enter.theValue(mobile).into(MOBILE))
        ).with("mobile").of(mobile);
    }

    public static Performable subject(String subject) {
        return Task.where("{0} add a subject #subject",
                        Scroll.to(MOBILE),
                        Click.on(SELECT_SUBJECT)
                                .then(Enter.theValue(subject).into(SELECT_SUBJECT))
                                .then(Click.on(ITEM_SUBJECT)))
                .with("subject").of(subject);
    }


    public static Performable hobbies() {
        return Task.where("{0} add a hobbies #hobbies",
                Click.on(HOBBIES)
        );
    }

    public static Performable currentAddress(String currentAddress) {
        return Task.where("{0} add a current address #currentAddress",
                Scroll.to(HOBBIES),
                Click.on(CURRENT_ADDRESS)
                        .then(Enter.theValue(currentAddress).into(CURRENT_ADDRESS))
        ).with("currentAddress").of(currentAddress);
    }

    public static Performable upLoadXls(Path TEST_FILE_PATH) {
        return Task.where("file upload xls",
                WaitUntil.the(FILE_UPLOAD, WebElementStateMatchers.isPresent()),
                Upload.theFile(TEST_FILE_PATH).to(FILE_UPLOAD));
    }

    public static Performable birthDay(String mouth, String year) {
        return Task.where("{0} add a mouth #mouth",
                Click.on(BIRTHDAY)
                        .then(Click.on(LIST_MONTH))
                        .then(Enter.theValue(mouth).into(ITEM_MONTH))
                        .then(Click.on(LIST_YEARS)).then(Enter.theValue(year).into(ITEM_YEARS))
                        .then(Click.on(ITEM_DAY))
        ).with("mouth").of(mouth);
    }
}
