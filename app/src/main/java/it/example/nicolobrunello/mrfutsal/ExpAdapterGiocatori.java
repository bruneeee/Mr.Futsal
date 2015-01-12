package it.example.nicolobrunello.mrfutsal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicolobrunello on 12/01/15.
 */
public class ExpAdapterGiocatori extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<String> listdataheader;  //categorie
    private ArrayList<Giocatore> giocatori;

    public ExpAdapterGiocatori (Context context,ArrayList<String> l,ArrayList<Giocatore> g){
        this._context = context;
        this.listdataheader = l;
        this.giocatori = g;
    }

    @Override
    public int getGroupCount() {
        return this.listdataheader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.giocatori.size();
    }

    @Override
    public Object getGroup(int i) {
        return this.giocatori.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return this.giocatori.get(i2);
    }

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

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getGroup(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater.from(this._context));
            view = inflater.inflate(R.layout.riga_head_dettagli,null);
        }
        TextView txtNome = (TextView) view.findViewById(R.id.lbltitolo);
        txtNome.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        final Giocatore g=(Giocatore) getChild(i,i2);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater.from(this._context));
            view = inflater.inflate(R.layout.riga_giocatore,null);
        }
        TextView txtNome = (TextView) view.findViewById(R.id.txtnome);
        TextView txtCognome = (TextView) view.findViewById(R.id.txtcognome);
        TextView txtDataNascita = (TextView) view.findViewById(R.id.txtdatanascita);
        TextView txtRuolo = (TextView) view.findViewById(R.id.txtruolo);

        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        txtNome.setText(g.getNome());
        txtCognome.setText(g.getCognome());
        txtDataNascita.setText(g.getData_n());
        txtRuolo.setText(String.valueOf(g.getIsPortiere()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
