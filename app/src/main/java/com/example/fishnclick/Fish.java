package com.example.fishnclick;

public class Fish {
    private String name;
    private int value;
    private int clicks;
    private int logoID;
    private int level;
    private boolean enabled;
    public Fish(String name, int value,int logo) {
        this.name=name;
        this.value=value;
        this.logoID=logo;
        clicks=0;
    }
    public void addClick() {
        clicks++;
    }
    public void setEnabled() {
        this.enabled=true;
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
    public void levelUp(){level+=1;}
    public int getLevel(){return level;}
}
