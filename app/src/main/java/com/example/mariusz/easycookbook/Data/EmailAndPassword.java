package com.example.mariusz.easycookbook.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailAndPassword {

    public String name;
    public String email;
    public String password;
    public String last_name;
}
