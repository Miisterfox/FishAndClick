package com.example.fishnclick;

import android.os.Handler;

public class Fish {
    private String name;
    private int value;
    private int clicks;
    private int logoID;
    private int level;
    private int price;

    public Fish(String name, int value,int logo) {
        this.name=name;
        this.value=value;
        this.logoID=logo;
        this.level=0;
        this.price=10;
        this.clicks=0;
    }
    public void addClick() {
        clicks++;
    }

    public int getClicks() {
        return clicks;
    }
    public int getLogo() {
        return logoID;
    }
    @Override
    public String toString() {
        return name;
    }
    public int getValue() {
        return value;
    }
    private int getLevel(){return level;}
}
