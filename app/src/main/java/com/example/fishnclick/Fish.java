package com.example.fishnclick;

public class Fish {
    private String name;
    private int value;
    private int clicks;

    public Fish(String name, int value) {
        this.name=name;
        this.value=value;
        clicks=0;
    }
    public void addClick() {
        clicks++;
    }

    public int getClicks() {
        return clicks;
    }
}
