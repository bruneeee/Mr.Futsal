package it.example.nicolobrunello.mrfutsal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 14/01/15.
 */
public class Evento {

    private int id;
    private String descr;

    public Evento(){}

    public Evento (int id,String descr){
        this.id = id;
        this.descr = descr;
    }

    public static ArrayList<Evento> getEventi(Context context) {
        ArrayList<Evento> eventi = new ArrayList<Evento>();

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("select * from EVENTO", null);

        while (c.moveToNext()) {
            eventi.add(new Evento(c.getInt(0), c.getString(1)));
        }

        return eventi;
    }

    public static int getNumEventi(int id, ArrayList<Evento> e) {
        int c = 0;
        for (int i = 0; i < e.size(); i++)
            if (e.get(i).getId() == id)
                c++;
        return c;
    }

    public static void addEvento(Context context,String descr){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("desc", descr);
        db.insert("Evento", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("evento",null,null);
    }

    public static Evento getEvento(Context context,int id){
        Evento e = new Evento();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql = String.format("select * from EVENTO WHERE id=%d",id);

        Cursor c = db.rawQuery(sql,null);

        while(c.moveToNext()) {
            e = (new Evento(c.getInt(0), c.getString(1)));
        }
        return e;
    }

    public String getDescr() {
        return descr;
    }

    public int getId() {
        return id;
    }
}
