package com.example.diego.ejemplopruebaprog2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Diego on 19/8/2017.
 */

public class Fragment_Lista extends Fragment {
    BasePruebaSQLiteHelper acceso;
    SQLiteDatabase db;
    MainActivity activity;
    Button btnvolver;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.lista_layout,container,false);
        acceso = new BasePruebaSQLiteHelper(getContext(), "basePrueba", null, 1);
        ListView listView = (ListView)vista.findViewById(R.id.listview);
        ArrayList<String>Pelis = mostrarPeliculas();
        Adapter_Peliculas adapterPeliculas= new Adapter_Peliculas(Pelis, getContext());
        listView.setAdapter(adapterPeliculas);
        activity = (MainActivity)getActivity();
        btnvolver = (Button)vista.findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.ChangetoBotones();
            }
        });
        return vista;
    }
    boolean connectToDatabase() {
        db = acceso.getWritableDatabase();
        if (db != null) {
            return true;
        }
        return false;
    }
    ArrayList<String> mostrarPeliculas() {
    ArrayList<String> Peliculas = new ArrayList<>();
        if (connectToDatabase()) {
        Cursor cursor = db.rawQuery("SELECT Pelicula from Peliculas ", null);
        if (cursor.moveToFirst()) {
            do {
                Peliculas.add(cursor.getString(0));
            } while (cursor.moveToNext());


        }
        db.close();
    }
        return Peliculas;

}}
