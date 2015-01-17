package it.example.nicolobrunello.mrfutsal;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by nicolobrunello on 16/01/15.
 */
public class ModificaSquadra extends Fragment implements View.OnClickListener{

    private String nome;
    private int id,id_stagione;

    EditText txtnome;
    Spinner stagioni;
    Button aggiorna,annulla;

    public ModificaSquadra() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nuovasquadra, container, false);

        stagioni = (Spinner) rootView.findViewById(R.id.spinnerstagioni);
        txtnome = (EditText) rootView.findViewById(R.id.txtnome);

        nome = this.getArguments().getString("nome","");
        id = this.getArguments().getInt("id", -1);
        id_stagione = this.getArguments().getInt("id_s",VariabiliGloabali.idcurrentseason);

        Stagione.deleteAll(getActivity());
        Stagione.addStagione(getActivity(),"Stagione1");
        Stagione.addStagione(getActivity(),"Stagione2");
        Stagione.addStagione(getActivity(),"Stagione3");

        AdapterStagione adapter = new AdapterStagione(getActivity(),Stagione.getStagioni(getActivity()));
        stagioni.setAdapter(adapter);

        if(id != -1){   //La squadra esiste già
            txtnome.setText(nome);
            stagioni.setSelection(id_stagione);
        }
        else{           //la squadra non esiste
            txtnome.setText("");
            stagioni.setSelection(id_stagione);
        }
        //TODO modifica giocatori e azioni bottoni
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnaggiorna:
                break;
            case R.id.btnannulla:
                break;
        }
    }
}
