package it.example.nicolobrunello.mrfutsal;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class DettaglioGiocatore extends Fragment implements View.OnClickListener{

    private ArrayList<Evento> eventi;
    private String cognome,nome,data_n;
    private int isPortiere,id,partitegiocate,golsegnati,espulsioni;

    TextView lblcognome,lblruolo,lbldata;
    TextView lblvalpartite,lblvalgol,lblvalgolpartite,lblvalfalli,lblvalespulsioni;
    Button btnmodifica;

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
        lblvalpartite = (TextView) rootView.findViewById(R.id.lblvalpartgiocate);
        lblvalgol = (TextView) rootView.findViewById(R.id.lblvalgol);
        lblvalgolpartite = (TextView) rootView.findViewById(R.id.lblvalgolpartita);
        lblvalespulsioni = (TextView) rootView.findViewById(R.id.lblvalespulsioni);
        btnmodifica = (Button) rootView.findViewById(R.id.btnmodifica);


        cognome = this.getArguments().getString("cognome","");
        nome = this.getArguments().getString("nome","");
        data_n = this.getArguments().getString("datanascita","");
        isPortiere = this.getArguments().getInt("is_portiere",0);
        id = this.getArguments().getInt("id",-1);

        lblcognome.setText(cognome + " "+ nome);
        lbldata.setText(data_n);

        if(isPortiere == 1){//TODO cambiare l'immagine di sfondo
            lblruolo.setText("Portiere");

        }
        else{
            lblruolo.setText("Giocatore");

        }

        btnmodifica.setOnClickListener(this);
        /*
        Evento.deleteAll(getActivity());
        Evento.addEvento(getActivity(),"gol");
        Evento.addEvento(getActivity(),"espulsione");
        /*TODO dovrebbe funzionare oppure no !!!
        eventi = Convocato_Evento.getEventifromGiocatore(getActivity(),id);

        partitegiocate = Convocazione.getnumPartite(getActivity(),id);
        golsegnati = Evento.getNumEventi(0,eventi);//id = 0 --> gol
        espulsioni = Evento.getNumEventi(1,eventi);//id = 1 --> espulsione
        */
        partitegiocate = 10;
        golsegnati = 2;
        espulsioni = 1;
        float golpartita = (float)golsegnati/(float)partitegiocate;

        lblvalpartite.setText(String.valueOf(partitegiocate));
        lblvalgol.setText(String.valueOf(golsegnati));
        lblvalespulsioni.setText(String.valueOf(espulsioni));
        lblvalgolpartite.setText(String.format("%.2f",golpartita));

        return rootView;
    }

    @Override
    public void onClick(View view) {
        //TODO goto modifica giocatore...
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = Fragment.instantiate(getActivity(), ModificaGiocatore.class.getName());
        Bundle bundle = new Bundle();
        bundle.putString("cognome",cognome);
        bundle.putString("nome",nome);
        bundle.putString("datanascita",data_n);
        bundle.putInt("id",id);
        bundle.putInt("is_portiere",isPortiere);
        fragment.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}
