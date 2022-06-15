package com.picap.tasks.registerclient;

import com.picap.interactions.registerclient.AddToRegisterStudent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

public class AddRegisterStudent implements Task {

    List<Performable> itemsRegisterStudent;

    public AddRegisterStudent() {
        itemsRegisterStudent = new ArrayList<>();
    }

    public static AddRegisterStudent with() {
        return new AddRegisterStudent();
    }

    public AddRegisterStudent firstName(String firstName) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.firstName(firstName));
        return this;
    }

    public AddRegisterStudent andLastName(String lastName) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.lastName(lastName));
        return this;
    }

    public AddRegisterStudent andEmail(String email) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.email(email));
        return this;
    }

    public AddRegisterStudent andGender() {
        this.itemsRegisterStudent.add(AddToRegisterStudent.gender());
        return this;
    }

    public AddRegisterStudent andMobile(String mobile) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.mobile(mobile));
        return this;
    }

    public AddRegisterStudent andBirthDay(String mouth, String year){
        this.itemsRegisterStudent.add(AddToRegisterStudent.birthDay(mouth,year));
        return this;
    }

    public AddRegisterStudent andSubject(String subject) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.subject(subject));
        return this;
    }

    public AddRegisterStudent andHobbies() {
        this.itemsRegisterStudent.add(AddToRegisterStudent.hobbies());
        return this;
    }

    public AddRegisterStudent andCurrentAddress(String currentAddress) {
        this.itemsRegisterStudent.add(AddToRegisterStudent.currentAddress(currentAddress));
        return this;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                registerClientActions()
        );
    }

    private Performable[] registerClientActions() {
        return this.itemsRegisterStudent.toArray(new Performable[this.itemsRegisterStudent.size()]);
    }

}
