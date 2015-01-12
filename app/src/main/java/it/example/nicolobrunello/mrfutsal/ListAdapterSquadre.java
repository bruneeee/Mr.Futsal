package it.example.nicolobrunello.mrfutsal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by nicolobrunello on 10/01/15.
 */
public class ListAdapterSquadre extends ArrayAdapter<Squadra>{

    private final Activity context;
    private ArrayList<Squadra> squadra;
    public ListAdapterSquadre(Activity context, ArrayList<Squadra> g) {
        super(context, R.layout.riga_squadra, g);
        this.context = context;
        this.squadra = g;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Squadra s = squadra.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.riga_squadra, null, true);

        TextView lblNomeSq = (TextView) rowView.findViewById(R.id.lblnomesq);

        lblNomeSq.setText(s.getNome());
        return rowView;
    }
}
