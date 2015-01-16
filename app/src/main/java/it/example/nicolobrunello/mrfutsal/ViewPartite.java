package it.example.nicolobrunello.mrfutsal;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewPartite extends Fragment {

    ArrayList<Partita> partite;

    public ViewPartite() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setTitle("CULO");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_partite, container, false);


        Partita.deleteAll(getActivity());
        Partita.addPartita(getActivity(),1,1,1,"Avversaria1","2014-10-10 12:00:00","stronzone");
        Partita.addPartita(getActivity(),2,0,1,"Fuoricasa","2014-10-03 12:00:00","stronzone");

        partite = Partita.getPartite(getActivity());

        ListView list = (ListView) rootView.findViewById(R.id.listpartite);
        ListAdapterPartite adapter = new ListAdapterPartite(getActivity(),partite);

        list.setAdapter(adapter);

        return rootView;
    }


}
