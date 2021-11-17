package com.example.myflight;

import android.util.Log;

import com.orm.SugarRecord;

public class BenutzerDAO extends SugarRecord {

    public void insertBenutzer(Benutzer benutzer) {
        benutzer.save();
        Log.d( "DB_ACCESS", "Benutzer saved" );
    }

    public Benutzer readBenutzer() {
        Benutzer benutzer= Benutzer.findById(Benutzer.class, 1);
        Log.d( "DB_ACCESS", "Benutzername: "+ benutzer.getName() );
        return benutzer;
    }

    public void deleteBenutzer() {
        Benutzer benutzer = Benutzer.findById(Benutzer.class, 1);
        benutzer.delete();
        Log.d( "DB_ACCESS", "Benutzer deleted" );
    }

}
