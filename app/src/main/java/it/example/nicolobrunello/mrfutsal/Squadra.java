package it.example.nicolobrunello.mrfutsal;

/**
 * Created by nicolobrunello on 26/12/14.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Squadra {

    private int id;
    private int stagione;
    private String nome;

    public Squadra(){
    }

    public Squadra(int id,String nome,int s){
        this.id=id;
        this.nome=nome;
        this.stagione=s;
        Log.e("ID_SQUADRA",String.valueOf(id));
    }

    public static ArrayList<Squadra> getSquadre(Context context,int stagione){
        ArrayList<Squadra> squadre = new ArrayList<Squadra>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql =String.format("select * from SQUADRA where id_stagione = '%d'",stagione);

        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            squadre.add(new Squadra(c.getInt(0), c.getString(1),c.getInt(2)));
        }

        return squadre;
    }

    public static void addSquadra(Context context,String n,int s){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", n);
        contentValues.put("id_stagione",s);
        db.insert("SQUADRA", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("SQUADRA",null,null);
    }

    public static ArrayList<Giocatore> getGiocatori(Context context,int id){
        ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql =String.format("SELECT giocatore.id,giocatore.cognome,giocatore.datanascita,giocatore.is_portiere FROM giocatore, giocatore_has_squadra , squadra WHERE giocatore.id = giocatore_has_squadra.giocatore_id AND squadra.id= giocatore_has_squadra.squadra_id AND squadra.id=%d ",id );

        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            giocatori.add(new Giocatore(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
        }

        return giocatori;
    }

    public int getId() {
        return id;
    }

    public int getStagione() {
        return stagione;
    }

    public String getNome() {
        return nome;
    }

    public static Squadra getSquadra(Context context,int id){
        Squadra s = new Squadra(0,"ERRORE",0);
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql =String.format("select * from SQUADRA where id = '%d'",id);

        Cursor c = db.rawQuery(sql,null);
        while(c.moveToNext()) {
            s = (new Squadra(c.getInt(0), c.getString(1), c.getInt(2)));
        }
        return s;
    }
}
