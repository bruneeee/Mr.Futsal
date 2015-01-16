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
 * Created by nicolobrunello on 15/01/15.
 */
public class AdapterEventi extends ArrayAdapter<Evento> {

    private final Activity context;
    private ArrayList<Evento> eventi;

    public AdapterEventi(Activity context,ArrayList<Evento> e){
        super(context, R.layout.spinner_eventi, e);
        Log.e("Spinner_Eventi", "CREATO");
        this.context = context;
        this.eventi = e;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_eventi, parent, false);

        TextView main_text = (TextView) mySpinner.findViewById(R.id.lblevento);
        main_text.setText(eventi.get(position).getDescr());

        return mySpinner;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View mySpinner = inflater.inflate(R.layout.spinner_eventi, parent, false);

        TextView main_text = (TextView) mySpinner.findViewById(R.id.lblevento);
        main_text.setText(eventi.get(position).getDescr());

        return mySpinner;
    }
}
