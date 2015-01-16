package it.example.nicolobrunello.mrfutsal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 11/01/15.
 */
public class ExpAdapterDettagli extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Giocatore> giocatori; //Lista Giocatori?
    private ArrayList<String> statistiche;  //Lista Statistiche da Inserire?
    private ArrayList<String> elementi;     //Lista Dei Titoli?

    public ExpAdapterDettagli (Context context,ArrayList<String> e, ArrayList<String> s ,ArrayList<Giocatore>g)
    {
        Log.e("AdapterExp","CREATO ADAPTER");
        this.context = context;
        this.giocatori = g;
        this.elementi = e;
        this.statistiche = s;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getGroup(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater.from(this.context));
            view = inflater.inflate(R.layout.riga_head_dettagli,null);
        }
        TextView txtNome = (TextView) view.findViewById(R.id.lbltitolo);
        txtNome.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {


        if(i == 0){//fa parte dei dettagli
            Log.e("AdapterExp","CREATO CHILD tipe0");
            if(view == null)
            {
                LayoutInflater inflater = (LayoutInflater.from(this.context));
                view = inflater.inflate(R.layout.riga_dettaglio,null);
            }
            TextView lbltitolo = (TextView) view.findViewById(R.id.lbltitolos);
            TextView lblvalore = (TextView) view.findViewById(R.id.lblvalores);
            lbltitolo.setText(statistiche.get(i2));
            lblvalore.setText("culo");
        }
        else{//fa parte dei giocatori
            Log.e("AdapterExp","CREATO CHILD tipe1");
            if(view == null)
            {
                LayoutInflater inflater = (LayoutInflater.from(this.context));
                view = inflater.inflate(R.layout.riga_giocatore,null);
            }
            Giocatore g = giocatori.get(i2);

            TextView txtNome = (TextView) view.findViewById(R.id.txtnome);
            TextView txtCognome = (TextView) view.findViewById(R.id.txtcognome);
            TextView txtDataNascita = (TextView) view.findViewById(R.id.txtdatanascita);
            TextView txtDescr = (TextView) view.findViewById(R.id.txtdescr);
            TextView txtRuolo = (TextView) view.findViewById(R.id.txtruolo);
            TextView txtSquadra = (TextView) view.findViewById(R.id.txtsquadra);

            //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

            txtNome.setText(g.getNome());
            txtCognome.setText(g.getCognome());
            txtDataNascita.setText(g.getData_n());
            txtRuolo.setText(String.valueOf(g.getIsPortiere()));
            //imageView.setImageResource(g.getImageID());
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override
         public int getGroupCount() {
        return this.elementi.size();
    }

    @Override
    public int getChildrenCount(int i) {

        if(i==0){
             return this.statistiche.size();
        }
        else{
             return this.giocatori.size();
        }
    }

    @Override
    public Object getGroup(int i) {
        return this.elementi.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        if(i==0){
            return this.statistiche.get(i2);
        }
        else{
            return this.giocatori.get(i2);
        }    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
