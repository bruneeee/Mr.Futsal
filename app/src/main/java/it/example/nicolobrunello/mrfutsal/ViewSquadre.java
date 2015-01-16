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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewSquadre extends Fragment{

    Spinner sstagione;
    ArrayList<Stagione> stagioni = new ArrayList<Stagione>();
    ArrayList<Squadra> squadre = new ArrayList<Squadra>();

    public ViewSquadre() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_squadre, container, false);
        sstagione = (Spinner) rootView.findViewById(R.id.spinnerstagioni);

        /*//Stagione.deleteAll(getActivity());
        Stagione.addStagione(getActivity(),"2014/15");
        Stagione.addStagione(getActivity(),"2013/14");
        Stagione.addStagione(getActivity(),"2012/13");

        //Squadra.deleteAll(getActivity());
        Squadra.addSquadra(getActivity(),"squadra1st0",0);
        Squadra.addSquadra(getActivity(),"squadra2st0",0);
        Squadra.addSquadra(getActivity(),"squadra1st1",1);
        Squadra.addSquadra(getActivity(),"squadra1st2",2);
        Squadra.addSquadra(getActivity(),"squadra2st2",2);*/

        stagioni = Stagione.getStagioni(getActivity());
        AdapterStagione adapterS = new AdapterStagione(getActivity(),stagioni);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sstagione.setAdapter(adapterS);
        sstagione.setSelection(0);

        squadre = Squadra.getSquadre(getActivity(),0);

        sstagione.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                squadre.clear();
                squadre = Squadra.getSquadre(getActivity(),i);
                ListAdapterSquadre adapter = new ListAdapterSquadre(getActivity(),squadre);
                ListView list = (ListView) rootView.findViewById(R.id.listsquadre);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        FragmentManager fragmentManager = getFragmentManager();
                        Fragment fragment = null;

                        Bundle bundle = new Bundle();
                        bundle.putInt("id_squadra", squadre.get(i).getId());

                        fragment = Fragment.instantiate(getActivity(), DettaglioSquadra.class.getName());

                        FragmentTransaction ft = fragmentManager.beginTransaction();
                        fragment.setArguments(bundle);
                        ft.replace(R.id.container, fragment);
                        ft.commit();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                squadre = Squadra.getSquadre(getActivity(),0);
            }
        });
        return rootView;
    }
}