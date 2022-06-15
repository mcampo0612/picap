package com.picap.features.register;

import com.picap.conf.BaseConf;
import com.picap.data.factories.RegisterStudentFactory;
import com.picap.models.actor.Picap;
import com.picap.models.registerclient.RegisterStudent;
import com.picap.tasks.navigate.NavigateToCreate;
import com.picap.tasks.registerclient.AddDocument;
import com.picap.tasks.registerclient.AddRegisterStudent;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.picap.data.factories.ActorFactory.getActorById;
import static com.picap.enums.ActorName.MIGUEL;

@RunWith(SerenityRunner.class)
@Narrative(text = {"Se realiza el test de picap"})
@WithTagValuesOf({"register-student"})
public class RegisterStudents extends BaseConf {

    Picap miguel;

    @Before
    public void navigate(){
        miguel = getActorById(MIGUEL.id());
        picapActor.attemptsTo(
                NavigateToCreate.registerStudent()
        );
    }

    @Test
    public void should_RegisterStudentBeCreated_When_SubmitTheCompleteRegistrationData(){

        RegisterStudent registerStudent = RegisterStudentFactory.getRegisterStudentByKey("register-student-data-complete");

        picapActor.attemptsTo(
                AddRegisterStudent.with()
                        .firstName(registerStudent.getFirstName())
                        .andLastName(registerStudent.getLastName())
                        .andEmail(registerStudent.getEmail())
                        .andGender()
                        .andMobile(registerStudent.getMobile())
                        //.andBirthDay(registerStudent.getMouth(),registerStudent.getYears()) por falta de tiempo no logre terminar
                        .andSubject(registerStudent.getSubject())
                        .andHobbies(),
                AddDocument.loadingPdfFile(),
                AddRegisterStudent.with()
                        .andCurrentAddress(registerStudent.getCurrentAddress())

        );
    }
}
