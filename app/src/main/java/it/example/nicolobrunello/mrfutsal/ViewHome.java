package it.example.nicolobrunello.mrfutsal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class ViewHome extends Fragment implements View.OnClickListener{

    Button btnsquadre , btngiocatori, btnnewgiocatore;

    public ViewHome() {
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        btnsquadre = (Button) rootView.findViewById(R.id.btnsquadre);
        btngiocatori = (Button) rootView.findViewById(R.id.btngiocatori);
        btnnewgiocatore = (Button) rootView.findViewById(R.id.btnnewgiocatore);

        btnsquadre.setOnClickListener(this);
        btngiocatori.setOnClickListener(this);
        btnnewgiocatore.setOnClickListener(this);

        ArrayList<Partita> p = Partita.getPartite(getActivity());

        return rootView;
    }
    @Override
    public void onClick(View v){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.btnsquadre:
                // codice per aprire fragment squadre
                fragment = Fragment.instantiate(getActivity(), ViewSquadre.class.getName());
                break;
            case R.id.btngiocatori:
                // codice per aprire fragment giocatori
                fragment = Fragment.instantiate(getActivity(), ViewGiocatori.class.getName());
                break;
            case R.id.btnnewgiocatore:
                // codice per aprire fragment partite
                fragment = Fragment.instantiate(getActivity(), ViewPartite.class.getName());
                //Bundle bundle = new Bundle();
                //fragment.setArguments(bundle);
                break;
        }
        if (fragment != null){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }
}