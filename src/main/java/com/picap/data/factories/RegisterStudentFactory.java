package com.picap.data.factories;

import com.picap.exceptions.InvoiceNotFoundException;
import com.picap.models.registerclient.RegisterStudent;
import com.picap.util.GetEnvironment;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class RegisterStudentFactory {

    private static final String REGISTER_STUDENT_PATH = "/registerclient/register-student-data.json";

    public static List<RegisterStudent> getRegisterStudent() {
        return Arrays.asList(from(getRegisterStudentFile()).getObject("registerStudent", RegisterStudent[].class));
    }

    public static RegisterStudent getRegisterStudentByKey(String key) {
        return getRegisterStudent().stream()
                .filter(a -> a.getKey()
                        .equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new InvoiceNotFoundException(String.format("register client with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getRegisterStudentFile() {
        String path = GetEnvironment.actual() + REGISTER_STUDENT_PATH;
        URL filePath = RegisterStudentFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for register client: " + path);
        }
        return filePath;
    }
}
