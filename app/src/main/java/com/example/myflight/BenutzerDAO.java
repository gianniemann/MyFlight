package com.example.myflight;

import android.util.Log;

import com.orm.SugarRecord;

public class BenutzerDAO extends SugarRecord {

    /**
     * @param benutzer
     */
    public void insertBenutzer(Benutzer benutzer) {
        benutzer.save();
        Log.d( "DB_ACCESS", "Benutzer saved" );
    }

    /**
     *
     * @return first Benutzer of Database
     */
    public Benutzer readBenutzer() {
        Benutzer benutzer = Benutzer.first(Benutzer.class);
        Log.d( "DB_ACCESS", "Benutzername: "+ benutzer.getName() );
        return benutzer;
    }

    /**
     * deletes all Benutzer
     */
    public void deleteBenutzer() {
        Benutzer.deleteAll(Benutzer.class);
        Log.d("DB_ACCESS", "Benutzer deleted");
    }

}
