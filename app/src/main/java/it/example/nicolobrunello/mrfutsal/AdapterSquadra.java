package it.example.nicolobrunello.mrfutsal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 26/12/14.
 */
public class AdapterSquadra extends ArrayAdapter<Squadra>{

    private final Activity context;
    private ArrayList<Squadra> squadre;

    public AdapterSquadra(Activity context,ArrayList<Squadra> s){
        super(context,R.layout.spinner_squadre,s);
        this.context=context;
        this.squadre = s;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_squadre, parent, false);

        TextView main_text = (TextView) mySpinner.findViewById(R.id.spinsquadra);

        main_text.setText(squadre.get(position).getNome());
        return mySpinner;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_squadre, parent, false);

        TextView main_text = (TextView) mySpinner .findViewById(R.id.spinsquadra);
        main_text.setText(squadre.get(position).getNome());

        return mySpinner;
    }
}