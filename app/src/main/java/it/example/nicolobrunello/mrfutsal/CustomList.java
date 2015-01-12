package it.example.nicolobrunello.mrfutsal;

/**
 * Created by Nicolo Brunello on 22/12/14.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Giocatore>{
    private final Activity context;
    private ArrayList<Giocatore> giocatore;
    public CustomList(Activity context, ArrayList<Giocatore> g) {
        super(context, R.layout.riga_giocatore, g);
        this.context = context;
        this.giocatore = g;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Giocatore g = giocatore.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.riga_giocatore, null, true);

        TextView txtNome = (TextView) rowView.findViewById(R.id.txtnome);
        TextView txtCognome = (TextView) rowView.findViewById(R.id.txtcognome);
        TextView txtDataNascita = (TextView) rowView.findViewById(R.id.txtdatanascita);
        TextView txtDescr = (TextView) rowView.findViewById(R.id.txtdescr);
        TextView txtRuolo = (TextView) rowView.findViewById(R.id.txtruolo);
        TextView txtSquadra = (TextView) rowView.findViewById(R.id.txtsquadra);

        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        txtNome.setText(g.getNome());
        txtCognome.setText(g.getCognome());
        txtDataNascita.setText(g.getData_n());
        txtRuolo.setText(String.valueOf(g.getIsPortiere()));
        //imageView.setImageResource(g.getImageID());

        return rowView;
    }
}