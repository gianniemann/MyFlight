package com.example.myflight;

import com.orm.SugarRecord;

public class Benutzer extends SugarRecord {
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
