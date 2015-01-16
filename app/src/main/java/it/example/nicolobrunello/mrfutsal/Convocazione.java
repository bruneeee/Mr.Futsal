package it.example.nicolobrunello.mrfutsal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 15/01/15.
 */
public class Convocazione {

    private int id;
    private int id_giocatore;
    private int id_partita;

    public Convocazione(){
    }

    public Convocazione (int id,int id_g,int id_p){
        this.id = id;
        this.id_giocatore = id_g;
        this.id_partita = id_p;
    }

    public static ArrayList<Giocatore> getConvocati(Context context,int id_p){
        ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql =String.format("SELECT giocatore.id,giocatore.cognome,giocatore.datanascita,giocatore.is_portiere FROM giocatore, convocati , partita WHERE giocatore.id = convocati.giocatore_id AND partita.id = convocati.partita_id AND convocati.partita_id=%d ",id_p );

        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            giocatori.add(new Giocatore(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
        }

        return giocatori;
    }
    public static void addConvocazione(Context context,int id_g,int id_p){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("giocatore_id", id_g);
        contentValues.put("partita_id", id_p);
        db.insert("convocati", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("convocati",null,null);
    }

    public static void replaceGiocatore(Context context ,int id ,String c ,String n ,String d ,int r ){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql="";//TODO stringa per aggiornamento
        db.execSQL(sql);
    }

    public int getId_giocatore() {
        return id_giocatore;
    }

    public int getId_partita() {
        return id_partita;
    }
}
