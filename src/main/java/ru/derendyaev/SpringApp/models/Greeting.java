package ru.derendyaev.SpringApp.models;

import javax.validation.constraints.NotNull;

public class Greeting {
    @NotNull
    private String name;
    @NotNull
    private String greetingText;
    @NotNull
    private String color;

    public Greeting() {
    }

    public Greeting(String name, String greetingText, String color) {
        this.name = name;
        this.greetingText = greetingText;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreetingText() {
        return greetingText;
    }

    public void setGreetingText(String greetingText) {
        this.greetingText = greetingText;
    }
}
