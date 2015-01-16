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
 * Created by nicolobrunello on 13/01/15.
 */
public class ListAdapterPartite extends ArrayAdapter<Partita> {

    private final Activity context;
    private ArrayList<Partita> partite;

    public ListAdapterPartite(Activity context, ArrayList<Partita> p) {
        super(context, R.layout.riga_partita, p);
        this.context = context;
        this.partite = p;
        Log.e("N° partite ",String.valueOf(p.size()));
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Partita s = partite.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.riga_partita, null, true);

        TextView lbldata = (TextView) rowView.findViewById(R.id.lbldata);
        TextView lblsquadracasa = (TextView) rowView.findViewById(R.id.lblsquadracasa);
        TextView lblsquadraospite = (TextView) rowView.findViewById(R.id.lblsquadraospite);

        lbldata.setText(s.getData());
        if(s.getIsInCasa()==0){//partita fuori casa
            lblsquadracasa.setText(s.getAvversaria());
            lblsquadraospite.setText(Squadra.getSquadra(context,s.getIdSquadra()).getNome());
        }
        else{
            lblsquadraospite.setText(s.getAvversaria());
            lblsquadracasa.setText(Squadra.getSquadra(context,s.getIdSquadra()).getNome());
        }
        return rowView;
    }
}
