package com.picap.util;

import java.util.Optional;

public class GetEnvironment {

    public static String actual() {
        return Optional.ofNullable(System.getProperty("environment"))
                .orElseThrow(() ->
                        new IllegalArgumentException("You need to specify the variable: [environment]"));
    }
}
