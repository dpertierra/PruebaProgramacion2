package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ArrayList<String>Pelis = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Pelis.add("Volver al Futuro");
        Pelis.add("Rambo");
        Pelis.add("Rocky");
        Pelis.add("Buscando a Nemo");
        Pelis.add("Forest Gump");
        Pelis.add("Toy Story");
        Pelis.add("Toy Story 2");
        Pelis.add("Toy Story 3");
        Pelis.add("Los Minions");
        Pelis.add("Harry Potter");

        ListView listView = (ListView)findViewById(R.id.listview);
        Adapter_Peliculas adapterPeliculas= new Adapter_Peliculas(Pelis, this);
        listView.setAdapter(adapterPeliculas);
    }
}
