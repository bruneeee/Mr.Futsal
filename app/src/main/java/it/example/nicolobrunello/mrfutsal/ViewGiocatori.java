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
import android.widget.ListView;


import java.util.ArrayList;


public class ViewGiocatori extends Fragment {

    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();

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
        Giocatore.deleteAll(getActivity());
        Giocatore.addGiocatore(getActivity(),"Nome","Cognome","11/11/1111",1);
        Giocatore.addGiocatore(getActivity(),"Nome1","Cognome1","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Nome2","Cognome2","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Nome3","Cognome3","11/11/1111",0);
        Giocatore.addGiocatore(getActivity(),"Nome4","Cognome4","11/11/1111",1);

        giocatori = Giocatore.getGiocatori(getActivity());

        CustomList adapter = new CustomList(getActivity(),giocatori);
        ListView list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = null;

                Bundle bundle = new Bundle();
                bundle.putString("cognome",giocatori.get(i).getCognome());
                bundle.putString("nome",giocatori.get(i).getNome());
                bundle.putString("datanascita",giocatori.get(i).getData_n());
                bundle.putInt("is_portiere",giocatori.get(i).getIsPortiere());
                bundle.putInt("id",giocatori.get(i).getId());

                fragment = Fragment.instantiate(getActivity(), DettaglioGiocatore.class.getName());

                FragmentTransaction ft = fragmentManager.beginTransaction();
                fragment.setArguments(bundle);
                ft.replace(R.id.container, fragment);
                ft.commit();
            }
        });

        //TODO manca pulsante aggiunta giocatore + gestione lista vuota

        return rootView;
    }
}


