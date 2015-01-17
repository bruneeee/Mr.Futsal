package it.example.nicolobrunello.mrfutsal;

/**
 * Created by nicolobrunello on 12/01/15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ModificaGiocatore extends Fragment implements View.OnClickListener{

    private String cognome,nome,data_n,descr;
    private int isPortiere,id=-1;

    EditText txtcognome,txtnome,txtdata;
    RadioButton rbgioc,rbport;
    RadioGroup rg;
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
        View rootView = inflater.inflate(R.layout.fragment_nuovogiocatore, container, false);

        txtcognome = (EditText) rootView.findViewById(R.id.txtcognome);
        txtdata = (EditText) rootView.findViewById(R.id.txtdatanascita);
        txtnome = (EditText) rootView.findViewById(R.id.txtnome);
        rbgioc = (RadioButton) rootView.findViewById(R.id.rbgiocatore);
        rbport = (RadioButton) rootView.findViewById(R.id.rbportiere);
        rg = (RadioGroup)rootView.findViewById(R.id.radiogroup);
        btnaggiorna = (Button) rootView.findViewById(R.id.btnaggiorna);
        btnannulla = (Button) rootView.findViewById(R.id.btnannulla);

        cognome =   this.getArguments().getString("cognome","");
        nome =      this.getArguments().getString("nome","");
        data_n =    this.getArguments().getString("datanascita","");
        isPortiere= this.getArguments().getInt("is_portiere",0);
        id =        this.getArguments().getInt("id",-1);

        if(id == -1){   //il giocatore non esiste
            btnaggiorna.setText("Crea");
        }

        txtcognome.setText(cognome);
        txtnome.setText(nome);
        txtdata.setText(data_n);

        if(isPortiere == 1){
            rbport.setChecked(true);
        }
        else{
            rbgioc.setChecked(true);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbportiere:
                        isPortiere = 1;
                        Log.e("cecked","1");
                        break;
                    case R.id.rbgiocatore:
                        isPortiere = 0;
                        Log.e("cecked","0");
                        break;
                }
            }
        });

        btnaggiorna.setOnClickListener(this);
        btnannulla.setOnClickListener(this);

        return rootView;
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnaggiorna:
                if(id == -1) {//Nuovo giocatore
                    Giocatore.addGiocatore(getActivity(),txtcognome.getText().toString(),
                            txtnome.getText().toString(),txtdata.getText().toString(),isPortiere);
                    Log.e("Creato","Giocatore");
                }else{
                    //TODO chiamare Giocatore.replace() e chiudere fragment
                }
                Log.e("Id_giocatore",String.valueOf(id));
                break;
            case R.id.btnannulla:
                //TODO chiudere fragment
                break;
        }
    }
}

