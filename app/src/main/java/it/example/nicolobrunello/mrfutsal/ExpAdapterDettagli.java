package it.example.nicolobrunello.mrfutsal;

import android.app.Activity;
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

    private Activity activity;
    private LayoutInflater inflater;

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

    public void setInflater(LayoutInflater inflater, Activity activity) {
        Log.e("AdapterExp","CREATO INFLATER");
        this.inflater = inflater;
        this.activity = activity;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent)  {
        Log.e("AdapterExp","CREATO GROUP");
        convertView = inflater.inflate(R.layout.riga_head_dettagli, null);
        //mettere Valori
        ((TextView) convertView).setText(elementi.get(groupPosition));
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        if(groupPosition == 0){//fa parte dei dettagli
            Log.e("AdapterExp","CREATO CHILD tipe0");
            convertView = inflater.inflate(R.layout.riga_dettaglio, null);

            TextView lbltitolo = (TextView) convertView.findViewById(R.id.lbltitolos);
            TextView lblvalore = (TextView) convertView.findViewById(R.id.lblvalores);
            lbltitolo.setText(statistiche.get(childPosition));
            lblvalore.setText("culo");
        }
        else{//fa parte dei giocatori
            Log.e("AdapterExp","CREATO CHILD tipe1");
            convertView = inflater.inflate(R.layout.riga_giocatore, null);
            Giocatore g = giocatori.get(childPosition);

            TextView txtNome = (TextView) convertView.findViewById(R.id.txtnome);
            TextView txtCognome = (TextView) convertView.findViewById(R.id.txtcognome);
            TextView txtDataNascita = (TextView) convertView.findViewById(R.id.txtdatanascita);
            TextView txtDescr = (TextView) convertView.findViewById(R.id.txtdescr);
            TextView txtRuolo = (TextView) convertView.findViewById(R.id.txtruolo);
            TextView txtSquadra = (TextView) convertView.findViewById(R.id.txtsquadra);

            //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

            txtNome.setText(g.getNome());
            txtCognome.setText(g.getCognome());
            txtDataNascita.setText(g.getData_n());
            txtRuolo.setText(String.valueOf(g.getIsPortiere()));
            //imageView.setImageResource(g.getImageID());
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    @Override
         public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i2) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i2) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
