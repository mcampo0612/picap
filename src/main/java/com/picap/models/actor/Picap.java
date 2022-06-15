package com.picap.models.actor;

import lombok.Data;

import java.util.List;

@Data
public class Picap {

    private String name;
    private String lastName;
    private String type;
    private String description;
    private Credentials credentials;
    private List<Company> companies;
    private int id;

}