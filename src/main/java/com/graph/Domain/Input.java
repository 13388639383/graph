package com.graph.Domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Input implements Serializable {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
