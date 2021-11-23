package com.example.myflight;

import com.orm.SugarRecord;

public class Benutzer extends SugarRecord {

    private String name;
    /**
     *
     * @param name
     */
    public Benutzer(String name){
        this.name = name;
    }

    public Benutzer(){

    }

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
