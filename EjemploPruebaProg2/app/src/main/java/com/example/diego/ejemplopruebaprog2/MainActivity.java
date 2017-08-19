package com.example.diego.ejemplopruebaprog2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    FragmentTransaction transaction;
    BasePruebaSQLiteHelper acceso;
    SQLiteDatabase db;
    ArrayList<String> ListaPeliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        Fragment Botones = new Botones_Fragment();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.holder, Botones);
        transaction.commit();


    }
    public void ChangetoLista()
    {
        manager = getSupportFragmentManager();
        Fragment Lista = new Fragment_Lista();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.holder, Lista);
        transaction.commit();
    }
}
