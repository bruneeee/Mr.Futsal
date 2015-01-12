package it.example.nicolobrunello.mrfutsal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 10/01/15.
 */


public class Stagione {

    private int id;
    private String anno;

    public Stagione(){}

    public Stagione(int id,String anno){
        this.id=id;
        this.anno = anno;
    }

    public static ArrayList <Stagione> getStagioni(Context context){
        ArrayList<Stagione> stagioni = new ArrayList<Stagione>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("select * from STAGIONE",null);

        while(c.moveToNext()) {
            stagioni.add(new Stagione(c.getInt(0), c.getString(1)));
        }

        return stagioni;
    }

    public static void addStagione(Context context,String descr){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("anno", descr);
        db.insert("STAGIONE", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("STAGIONE",null,null);
    }

    public int getId() {
        return id;
    }

    public String getDescrizione(){
        return this.anno;
    }
}
