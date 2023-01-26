package com.example.antoangiaothong;

import java.io.Serializable;

public class Question implements Serializable {
    private String name;

    public Question(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
