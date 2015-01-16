package it.example.nicolobrunello.mrfutsal;


/**
 * Created by nicolobrunello on 22/12/14.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NOME="mrfutsal";
    private static final int DB_VERSIONE = 1 ;
    private static final String TABLE_GIOCATORE = "CREATE TABLE IF NOT EXISTS giocatore (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, nome VARCHAR NOT NULL,cognome VARCHAR NOT NULL,dataNascita DATE NOT NULL, is_portiere BINARY(1) NOT NULL);";
    private static final String TABLE_STAGIONE ="CREATE TABLE IF NOT EXISTS stagione    (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, anno VARCHAR(7) NOT NULL);";
    private static final String TABLE_SQUADRA = "CREATE TABLE IF NOT EXISTS squadra     (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, nome TEXT NOT NULL, id_stagione INTEGER NOT NULL);";
    private static final String TABLE_PARTITA = "CREATE TABLE IF NOT EXISTS partita     (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, id_squadra INT NOT NULL, avversaria VARCHAR NOT NULL,data DATETIME NOT NULL,nomeArbitro VARCHAR(45) NULL, is_casa BINARY(1) NOT NULL,is_disputata BINARY(1) NOT NULL);";
    private static final String TABLE_EVENTO = "CREATE TABLE IF NOT EXISTS evento       (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, descr VARCHAR(45) NULL);";
    private static final String TABLE_CONVOCATI = "CREATE TABLE IF NOT EXISTS convocati (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, giocatore_id INTEGER NOT NULL ,partita_id INTEGER NOT NULL)";
    private static final String TABLE_GIOCSQUADRA="CREATE TABLE IF NOT EXISTS giocatore_has_squadra (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,giocatore_id INTEGER NOT NULL ,squadra_id INTEGER  NOT NULL ,id_stagione INTEGER  NOT NULL );";
    private static final String TABLE_EVCONVOCATO = "CREATE TABLE IF NOT EXISTS Evento_has_convocati` ( evento_id INTEGER PRIMARY KEY  NOT NULL UNIQUE, id_giocatore INTEGER PRIMARY KEY  NOT NULL UNIQUE, id_partita INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE);";

    public DBHelper (Context context)
    {
        super(context,DB_NOME,null,DB_VERSIONE);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_GIOCATORE);
        db.execSQL(TABLE_STAGIONE);
        db.execSQL(TABLE_SQUADRA);
        db.execSQL(TABLE_PARTITA);
        db.execSQL(TABLE_EVENTO);
        db.execSQL(TABLE_CONVOCATI);
        db.execSQL(TABLE_GIOCSQUADRA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion)
    {

    }
}
