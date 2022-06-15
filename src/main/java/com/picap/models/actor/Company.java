package com.picap.models.actor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    public String key;
    public String name;
    public String lastName;

}