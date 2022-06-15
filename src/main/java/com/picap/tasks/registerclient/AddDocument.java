package com.picap.tasks.registerclient;

import com.picap.data.factories.DocumentFactory;
import com.picap.interactions.registerclient.AddToRegisterStudent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddDocument implements Task {

    public static AddDocument loadingPdfFile() {
        return instrumented(AddDocument.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Path TEST_FILE_PATH = Paths.get(DocumentFactory.getFile("/document/testautomationpicap.pdf"));
        actor.attemptsTo(
                AddToRegisterStudent.upLoadXls(TEST_FILE_PATH)
        );
    }
}
