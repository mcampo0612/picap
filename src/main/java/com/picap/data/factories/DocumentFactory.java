package com.picap.data.factories;


import com.picap.util.GetEnvironment;

public class DocumentFactory {

    public static String getFile(String directory) {

        return "src/main/resources/" + GetEnvironment.actual() + directory;
    }
}
