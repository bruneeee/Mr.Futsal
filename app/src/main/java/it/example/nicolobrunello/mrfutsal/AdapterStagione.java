package it.example.nicolobrunello.mrfutsal;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NicoloBrunello on 10/01/15
 */
public class AdapterStagione extends ArrayAdapter<Stagione> {

    private final Activity context;
    private ArrayList<Stagione> stagioni;

    public AdapterStagione(Activity context, ArrayList<Stagione> s) {
        super(context, R.layout.spinner_stagioni, s);
        Log.e("Spinner_Stagioni","CREATO");
        this.context = context;
        this.stagioni = s;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_stagioni, parent, false);

        TextView main_text = (TextView) mySpinner.findViewById(R.id.lblanno);
        main_text.setText(stagioni.get(position).getDescrizione());

        return mySpinner;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_stagioni, parent, false);

        TextView main_text = (TextView) mySpinner.findViewById(R.id.lblanno);
        main_text.setText(stagioni.get(position).getDescrizione());

        return mySpinner;
    }
}
