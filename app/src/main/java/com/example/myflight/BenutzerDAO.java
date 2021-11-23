package com.example.myflight;

import android.util.Log;

import com.orm.SugarRecord;

public class BenutzerDAO extends SugarRecord {

    public void insertBenutzer(Benutzer benutzer) {
        benutzer.save();
        Log.d( "DB_ACCESS", "Benutzer saved" );
    }

    public Benutzer readBenutzer() {
        Benutzer benutzer = Benutzer.first(Benutzer.class);
        Log.d( "DB_ACCESS", "Benutzername: "+ benutzer.getName() );
        return benutzer;
    }

    public void deleteBenutzer() {
        /*Benutzer benutzer = null;
        int zaehler = 1;
        do {
            try {
                benutzer = Benutzer.findById(Benutzer.class, zaehler);
                benutzer.delete();
                Log.d("DB_ACCESS", "Benutzer "+zaehler+" deleted");
            }catch (Exception e){
                e.printStackTrace();
            }
            zaehler = zaehler + 1;
        }while (benutzer != null);*/
        Benutzer.deleteAll(Benutzer.class);
        Log.d("DB_ACCESS", "Benutzer deleted");
    }

}
