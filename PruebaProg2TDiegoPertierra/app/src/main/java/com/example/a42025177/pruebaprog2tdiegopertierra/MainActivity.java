package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDatos;
    Button btnLista;
    Button btnCambios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDatos = (Button)findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getApplicationContext(), Datos.class);
                startActivity(ir);
            }
        });
        btnLista = (Button)findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir2 = new Intent(getApplicationContext(), Lista.class);
                startActivity(ir2);
            }
        });
        btnCambios = (Button)findViewById(R.id.btnCambios);
        btnCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir3 = new Intent(getApplicationContext(), Cambios.class);
                startActivity(ir3);
            }
        });
    }

    }

