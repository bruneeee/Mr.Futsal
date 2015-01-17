package it.example.nicolobrunello.mrfutsal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;


import java.util.ArrayList;


public class ViewGiocatori extends Fragment {

    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
    private ArrayList<Giocatore> portieri = new ArrayList<Giocatore>();
    private ArrayList<String> titoli = new ArrayList<String>();

    public ViewGiocatori() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_giocatori, container, false);

        /*
         spostata la gestione del db nella classe Giocatore
        */
        //DBHelper dbHelper = new DBHelper(getActivity());
        //SQLiteDatabase db = dbHelper.getWritableDatabase();


        /*
         primo metodo per aggiungere un record alla tabella
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", "Fernando");
        contentValues.put("cognome", "Torres");
        contentValues.put("dataNascita", "1984/04/20");
        contentValues.put("descrizione", "Descrizione");
        contentValues.put("id_ruolo", 10);
        contentValues.put("id_squadra", 11);
        db.insert("giocatore", null, contentValues);
        */

        /*
         secondo metodo per aggiungere un record (using query)
        db.execSQL("INSERT INTO giocatore (nome,cognome,dataNascita,descrizione,id_ruolo,id_squadra )VALUES ( 'Torres','Fernando','1984/04/20','Descr',1,1 );");
        */

        /*
         metodo per eliminare tutti i valori dalla tabella
        db.delete("giocatore",null,null);
        */

        /*
        giocatori.add(new Giocatore(1,"Barla","Michele","11/11/1111","Descr",10,10));
        */
        /*Giocatore.deleteAll(getActivity());
        Giocatore.addGiocatore(getActivity(),"Cognome","Nome","11/11/1111",1);
        Giocatore.addGiocatore(getActivity(),"Cognome1","Nome1","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome2","Nome2","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome3","Nome3","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome4","Nome4","11/11/1111",1);
        Giocatore.addGiocatore(getActivity(),"Cognome5","Nome5","11/11/1111",1);
        Giocatore.addGiocatore(getActivity(),"Cognome6","Nome6","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome7","Nome7","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome8","Nome8","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Cognome9","Nome9","11/11/1111",1);*/

        titoli.add("GIOCATORI");
        titoli.add("PORTIERI");


        giocatori = Giocatore.getGiocatori(getActivity());
        portieri = Giocatore.getPortieri(getActivity());

        ExpAdapterGiocatori adapter = new ExpAdapterGiocatori(getActivity(),titoli,giocatori,portieri);
        ExpandableListView explist = (ExpandableListView) rootView.findViewById(R.id.explistg);
        explist.setAdapter(adapter);
        explist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long l) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = null;

                Bundle bundle = new Bundle();
                if(i==0) {
                    bundle.putString("cognome", giocatori.get(i2).getCognome());
                    bundle.putString("nome", giocatori.get(i2).getNome());
                    bundle.putString("datanascita", giocatori.get(i2).getData_n());
                    bundle.putInt("is_portiere", giocatori.get(i2).getIsPortiere());
                    bundle.putInt("id", giocatori.get(i2).getId());
                }
                else{
                    bundle.putString("cognome", portieri.get(i2).getCognome());
                    bundle.putString("nome", portieri.get(i2).getNome());
                    bundle.putString("datanascita", portieri.get(i2).getData_n());
                    bundle.putInt("is_portiere", portieri.get(i2).getIsPortiere());
                    bundle.putInt("id", portieri.get(i2).getId());
                }
                fragment = Fragment.instantiate(getActivity(), DettaglioGiocatore.class.getName());

                FragmentTransaction ft = fragmentManager.beginTransaction();
                fragment.setArguments(bundle);
                ft.replace(R.id.container, fragment);
                ft.commit();

                return false;
            }
        });
        //TODO manca pulsante aggiunta giocatore + gestione lista vuota

        return rootView;
    }
}


