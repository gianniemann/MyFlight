package com.example.myflight;

import com.orm.SugarRecord;

public class Benutzer extends SugarRecord {
    /**
     *
     * @param name
     */
    public Benutzer(String name){
        this.name = name;
    }

    public Benutzer(){

    }

    private String name;

    /**
     *
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @param n
     */
    public void setName(String n){
        name = n;
    }
}
