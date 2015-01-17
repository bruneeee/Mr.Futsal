package it.example.nicolobrunello.mrfutsal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 16/01/15.
 */
public class Convocato_Evento {

    private int id;
    private int id_giocatore;
    private int id_partita;
    private int id_evento;

    public Convocato_Evento() {
    }

    public Convocato_Evento(int id,int id_giocatore, int id_partita, int id_evento) {
        this.id = id;
        this.id_giocatore = id_giocatore;
        this.id_partita = id_partita;
        this.id_evento = id_evento;
    }

    public static ArrayList<Evento> getEventifromPartita(Context context,int id_p){
        ArrayList<Evento> eventi = new ArrayList<Evento>();

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql = String.format("select evento_id from evento_has_convocati WHERE id_partita = %d",id_p);
        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            eventi.add(Evento.getEvento(context,c.getInt(0)));
        }
        return eventi;
    }

    public static ArrayList<Evento> getEventifromGiocatore(Context context, int id_g){
        ArrayList<Evento> eventi = new ArrayList<Evento>();

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql = String.format("select evento_id from evento_has_convocati WHERE id_giocatore = %d",id_g);
        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            eventi.add(Evento.getEvento(context,c.getInt(0)));
        }
        return eventi;
    }
}
