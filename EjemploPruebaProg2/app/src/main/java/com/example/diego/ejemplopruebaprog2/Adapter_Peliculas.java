package com.example.diego.ejemplopruebaprog2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 18/8/2017.
 */
public class Adapter_Peliculas extends BaseAdapter {

    private ArrayList<String> _ListaPeliculas;
    private Context _context;
    public Adapter_Peliculas(ArrayList<String>ListadePeliculas, Context ContextaUsar) {
        _ListaPeliculas = ListadePeliculas;
        _context = ContextaUsar;
    }

    @Override
    public int getCount() {
        return _ListaPeliculas.size();
    }

    @Override
    public String getItem(int PosicionaObtener) {
        String NombreaDevolver = _ListaPeliculas.get(PosicionaObtener);
        return NombreaDevolver;
    }

    @Override
    public long getItemId(int PosicionaObtener) {
        return PosicionaObtener;
    }

    @Override
    public View getView(int PosicionActual, View view, ViewGroup viewGroup) {
        View VistaaDevolver;
        LayoutInflater inflater;
        inflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaaDevolver = inflater.inflate(R.layout.list_item, viewGroup, false);
        TextView Titulo = (TextView)VistaaDevolver.findViewById(R.id.TituloPelicula);
        String TextoposicionActual = getItem(PosicionActual);
        Titulo.setText(TextoposicionActual);
        return VistaaDevolver;
    }
}
