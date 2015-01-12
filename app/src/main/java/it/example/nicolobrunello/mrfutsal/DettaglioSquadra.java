package it.example.nicolobrunello.mrfutsal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DettaglioSquadra extends Fragment {

    private ArrayList<String> el = new ArrayList<String>();
    private ArrayList<String> st = new ArrayList<String>();
    private TextView lblnome,lblpvinte,lblppareggiate,lblpperse,lblgolf,lblgols;
    private ExpandableListView explistdettagli;
    private int id_squadra;//,id_stagione;

    public DettaglioSquadra() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dettagliosquadra, container, false);

        lblnome = (TextView) rootView.findViewById(R.id.lblnome);
        lblpvinte = (TextView) rootView.findViewById(R.id.lblpvinte);
        lblppareggiate = (TextView) rootView.findViewById(R.id.lblppareggiate);
        lblpperse = (TextView) rootView.findViewById(R.id.lblpperse);
        lblgolf = (TextView) rootView.findViewById(R.id.lblgolf);
        lblgols = (TextView) rootView.findViewById(R.id.lblgols);
        explistdettagli = (ExpandableListView) rootView.findViewById(R.id.listdettagli);

        id_squadra = this.getArguments().getInt("id_squadra",0);


        lblnome.setText(Squadra.getSquadra(getActivity(),id_squadra).getNome());
        //TODO statistiche
        /*
        lblpvinte.setText("");
        lblppareggiate.setText("");
        lblpperse.setText("");
        lblgolf.setText("");
        lblgols.setText("");
        */
        el.add("STATISTICHE");
        el.add("GIOCATORI");
        st.add("Statistica1");
        //TODO prendere dati statistiche

        explistdettagli.setDividerHeight(2);
        explistdettagli.setGroupIndicator(null);
        explistdettagli.setClickable(true);

        ExpAdapterDettagli adapter = new ExpAdapterDettagli(getActivity(),el,st,Squadra.getGiocatori(getActivity(),id_squadra));
        adapter.setInflater(LayoutInflater.from(getActivity()),getActivity());
        explistdettagli.setAdapter(adapter);

        return rootView;
    }
}
