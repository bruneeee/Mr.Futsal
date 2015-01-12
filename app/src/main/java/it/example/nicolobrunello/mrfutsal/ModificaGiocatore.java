package it.example.nicolobrunello.mrfutsal;

/**
 * Created by nicolobrunello on 12/01/15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ModificaGiocatore extends Fragment implements View.OnClickListener{

    private ArrayList<Squadra> squadre;
    private String cognome,nome,data_n,descr;
    private int isPortiere,id_squadra,id=-1;


    Spinner sSquadre;

    TextView lblcognome,txtnome,lblruolo,lbldata;

    Button btnaggiorna,btnannulla;
    public ModificaGiocatore() {
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

        //txtdescrizione = (EditText) rootView.findViewById(R.id.txtdescrizione);

        //btnaggiorna = (Button) rootView.findViewById(R.id.btnaggiorna);
        //btnannulla = (Button) rootView.findViewById(R.id.btnannulla);

        cognome = this.getArguments().getString("cognome","");
        nome = this.getArguments().getString("nome","");
        data_n = this.getArguments().getString("datanascita","");
        descr = this.getArguments().getString("descr","");
        isPortiere = this.getArguments().getInt("is_portiere",0);
        id = this.getArguments().getInt("id",-1);

        //sRuoli = (Spinner) rootView.findViewById(R.id.spinnerruolo);
        //sSquadre = (Spinner) rootView.findViewById(R.id.spinnersquadra);

        //Squadra.deleteAll(getActivity());
        //Squadra.addSquadra(getActivity(),"Milan",1);
        //Squadra.addSquadra(getActivity(),"Inter",1);

        //ruoli = Ruolo.getRuoli(getActivity());
        //squadre = Squadra.getSquadre(getActivity());

        lblcognome.setText(cognome + " "+ nome);
        lbldata.setText(data_n);

        if(isPortiere == 1){//TODO cambiare l'immagine di sfondo ?
            lblruolo.setText("Portiere");

        }
        else{
            lblruolo.setText("Giocatore");

        }
/*
        // Creating adapter for spinner
        AdapterSquadra adapterS = new AdapterSquadra(getActivity(),squadre);
        // Drop down layout style - list view with radio button
        adapterS.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        // attaching data adapter to spinner

        sSquadre.setAdapter(adapterS);
        sSquadre.setSelection(id_squadra);

        btnaggiorna.setOnClickListener(this);
        btnannulla.setOnClickListener(this);
*/
        return rootView;
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnaggiorna:
                //TODO chiamare Giocatore.replace() e chiudere fragment
                break;
            case R.id.btnannulla:
                //TODO chiudere fragment
                break;
            case R.id.btnnewgiocatore:
                break;
        }
    }
}

