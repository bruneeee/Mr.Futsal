package it.example.nicolobrunello.mrfutsal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 22/12/14.
 */

public class Giocatore {
    private int id;
    private String nome;
    private String cognome;
    private String data_n;
    private int isPortiere; // 1 = TRUE
    private int id_Squadra;
    // private int id_Imm; TODO bisogna decidere se metterlo

    public Giocatore(){}

    public Giocatore(int id,String c ,String n ,String d ,int r){//,int imm )
        this.id = id;
        this.nome=n;
        this.cognome=c;
        this.data_n=d;
        this.isPortiere=r;
    }

    public static ArrayList<Giocatore> getGiocatori(Context context){
        ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("select * from GIOCATORE WHERE is_portiere = 0",null);

        while(c.moveToNext()) {
            giocatori.add(new Giocatore(c.getInt(0), c.getString(2), c.getString(1), c.getString(3), c.getInt(4)));
        }

        return giocatori;
    }

    public static ArrayList<Giocatore> getPortieri(Context context){
        ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("select * from GIOCATORE WHERE is_portiere = 1",null);

        while(c.moveToNext()) {
            giocatori.add(new Giocatore(c.getInt(0), c.getString(2), c.getString(1), c.getString(3), c.getInt(4)));
        }

        return giocatori;
    }

    public static void addGiocatore(Context context,String c ,String n ,String d ,int r) {//,int imm )
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("cognome", c);
        contentValues.put("nome", n);
        contentValues.put("dataNascita", d);
        contentValues.put("is_portiere", r);
        db.insert("giocatore", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("giocatore",null,null);
    }
    
    public static void replaceGiocatore(Context context ,int id ,String c ,String n ,String d ,int r ){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql="";//TODO stringa per aggiornamento
        db.execSQL(sql);
    }

    public int getId(){return this.id;}

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getData_n() {
        return data_n;
    }

    public int getIsPortiere() {
        return isPortiere;
    }

}
