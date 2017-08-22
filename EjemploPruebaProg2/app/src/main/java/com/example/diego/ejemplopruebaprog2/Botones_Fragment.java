package com.example.diego.ejemplopruebaprog2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Diego on 18/8/2017.
 */

public class Botones_Fragment extends Fragment {
    Button btnAgregar;
    Button btnBuscar;
    Button btnBorrar;
    Button btnMostrar;
    MainActivity activity;
    BasePruebaSQLiteHelper acceso;
    SQLiteDatabase db;
    EditText text;
    String NombrePelicula;
    ListView listView;
    ArrayList<String>Pelis;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle datosrecibidos) {
        View VistaaDevolver = inflater.inflate(R.layout.botones_layout, container, false);
        acceso = new BasePruebaSQLiteHelper(getContext(), "basePrueba", null, 1);
        activity = (MainActivity)getActivity();
        text = (EditText)VistaaDevolver.findViewById(R.id.edt);
        listView = (ListView)VistaaDevolver.findViewById(R.id.listview);
        Pelis = mostrarPeliculas();
        Adapter_Peliculas adapterPeliculas= new Adapter_Peliculas(Pelis, getContext());
        listView.setAdapter(adapterPeliculas);
        NombrePelicula = text.getText().toString();
        btnAgregar = (Button)VistaaDevolver.findViewById(R.id.btnagregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agregar(text.getText().toString());
                text.setText("");
            }
        });
        btnBuscar = (Button)VistaaDevolver.findViewById(R.id.btnbuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buscar(text.getText().toString());
                text.setText("");
            }
        });
        btnBorrar = (Button)VistaaDevolver.findViewById(R.id.btnborrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Borrar(text.getText().toString());
                text.setText("");
            }
        });
        btnMostrar = (Button)VistaaDevolver.findViewById(R.id.btnmostrartodos);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.ChangetoLista();
            }
        });
        return VistaaDevolver;
    }
    boolean connectToDatabase() {
        db = acceso.getWritableDatabase();
        if (db != null) {
            return true;
        }
        return false;
    }
    public void Agregar(String Pelicula)
    {
        if (connectToDatabase())
        {
            ContentValues nuevoregistro;
            nuevoregistro= new ContentValues();
            nuevoregistro.put("Pelicula", Pelicula);
            db.insert("Peliculas", null, nuevoregistro);
            Toast.makeText(getContext(), "Se agrego " + Pelicula, Toast.LENGTH_SHORT).show();
            Pelis = mostrarPeliculas();
            db.close();

        }
        Adapter_Peliculas adapterPeliculas= new Adapter_Peliculas(Pelis, getContext());
        listView.setAdapter(adapterPeliculas);
    }
    public void Buscar(String Pelicula)
    {
        if (connectToDatabase()){
        Cursor ConjuntoRegistros;
        ConjuntoRegistros = db.rawQuery("select Pelicula from Peliculas where Pelicula='" + Pelicula+"'", null);
        if(ConjuntoRegistros.moveToFirst() == true)
        {

            do
            {
                String PeliSQL = ConjuntoRegistros.getString(0);

                if(PeliSQL.equals(Pelicula))
                {
                    Toast.makeText(getContext(), "La pelicula esta en la base de datos", Toast.LENGTH_LONG).show();

                }
            }while (ConjuntoRegistros.moveToNext());
        }
        }
        db.close();
    }
    public void Borrar(String Pelicula)
    {
            if (connectToDatabase()) {
                db.execSQL("delete from Peliculas WHERE Pelicula ='" + Pelicula + "'");
                Toast.makeText(getContext(), "Se borro la pelicula correctamente", Toast.LENGTH_LONG).show();
            }
            db.close();
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

}
}

