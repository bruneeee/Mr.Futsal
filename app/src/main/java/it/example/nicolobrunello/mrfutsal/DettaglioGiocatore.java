package it.example.nicolobrunello.mrfutsal;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class DettaglioGiocatore extends Fragment {

    private ArrayList<Squadra> squadre;
    private String cognome,nome,data_n,descr;
    private int isPortiere,id_squadra,id=-1;

    TextView lblcognome,txtnome,lblruolo,lbldata;

    public DettaglioGiocatore() {
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
        View rootView = inflater.inflate(R.layout.fragment_dettagliogiocatore, container, false);

        lblcognome = (TextView) rootView.findViewById(R.id.lblcognome);
        lbldata = (TextView) rootView.findViewById(R.id.lbldata);
        lblruolo = (TextView) rootView.findViewById(R.id.lblruolo);


        cognome = this.getArguments().getString("cognome","");
        nome = this.getArguments().getString("nome","");
        data_n = this.getArguments().getString("datanascita","");
        isPortiere = this.getArguments().getInt("is_portiere",0);
        id = this.getArguments().getInt("id",-1);

        lblcognome.setText(cognome + " "+ nome);
        lbldata.setText(data_n);

        if(isPortiere == 1){//TODO cambiare l'immagine di sfondo ?
            lblruolo.setText("Portiere");

        }
        else{
            lblruolo.setText("Giocatore");

        }
        return rootView;
    }
}
