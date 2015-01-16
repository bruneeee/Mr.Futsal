package it.example.nicolobrunello.mrfutsal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 13/01/15.
 */
public class Partita {
    private int id;
    private int idSquadra;
    private int isInCasa;
    private int isdisputata;
    private String avversaria;
    private String data;
    private String arbitro;

    public Partita(){
    }

    public Partita(int id,int idsquadra,int iscasa,int isdisputata,String avversaria,String data,String arbitro){
        this.id =id;
        this.idSquadra = idsquadra;
        this.isInCasa = iscasa;
        this.isdisputata = isdisputata;
        this.avversaria = avversaria;
        this.data = data;
        this.arbitro = arbitro;
    }
    public static ArrayList<Partita> getPartite(Context context){
        ArrayList<Partita> p = new ArrayList<Partita>();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //String sql ="select * from PARTITA GROUP BY is_disputata ORDER BY datetime(data)";
        String sql ="select * from PARTITA ORDER BY datetime(data)";

        Cursor c = db.rawQuery(sql, null);

        while(c.moveToNext()) {//int id,int sq,string avversaria,string date,String nomarbitro,int iscasa,int isDisputata
            p.add(new Partita(c.getInt(0), c.getInt(1), c.getInt(5), c.getInt(6),c.getString(2),c.getString(3),c.getString(4)));
        }

        return p;
    }

    public static void addPartita(Context context,int idsquadra,int iscasa,int isdisputata,String avversaria,String data,String arbitro){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id_squadra", idsquadra);
        contentValues.put("avversaria",avversaria);
        contentValues.put("data",data);
        contentValues.put("nomeArbitro",arbitro);
        contentValues.put("is_casa",iscasa);
        contentValues.put("is_disputata",isdisputata);

        db.insert("PARTITA", null, contentValues);
    }

    public static void deleteAll(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("PARTITA",null,null);
    }

    public static Partita getPartita(Context context,int id){
        Partita p = new Partita();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql =String.format("select * from PARTITA WHERE id = '%d'",id);

        Cursor c = db.rawQuery(sql, null);

        while(c.moveToNext()) {//int id,int sq,string avversaria,string date,String nomarbitro,int iscasa,int isDisputata
            p= new Partita(c.getInt(0), c.getInt(1), c.getInt(5), c.getInt(6),c.getString(2),c.getString(3),c.getString(4));
        }

        return p;
    }

    public int getIdSquadra() {
        return idSquadra;
    }

    public int getIsInCasa() {
        return isInCasa;
    }

    public int getIsdisputata() {
        return isdisputata;
    }

    public String getAvversaria() {
        return avversaria;
    }

    public String getData() {
        return data;
    }

    public String getArbitro() {
        return arbitro;
    }
}