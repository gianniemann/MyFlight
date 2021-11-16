package com.example.myflight;

public class Benutzer {
    public Benutzer(String name){
        this.name = name;
    }

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
}
