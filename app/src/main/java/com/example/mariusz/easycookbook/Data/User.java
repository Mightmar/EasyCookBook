package com.example.mariusz.easycookbook.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Mariusz on 2015-01-18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    public Integer id;

    @JsonProperty("session_id")
    public String sessionId;

}