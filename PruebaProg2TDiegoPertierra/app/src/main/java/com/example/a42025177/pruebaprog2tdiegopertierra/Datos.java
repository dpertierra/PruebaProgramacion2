package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Datos extends AppCompatActivity {
    EditText text;
    BaseSQLite acceso;
    SQLiteDatabase db;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        text = (EditText)findViewById(R.id.edt);
        acceso = new BaseSQLite(this, "basePrueba", null, 1);
        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregaraBase(text.getText().toString());
            }
        });
    }
    public void AgregaraBase(String Nombre)
    {
        if (Nombre.length()>0)
        {
            if (connectToDatabase())
            {
                Cursor ConjuntoRegistros;
                ConjuntoRegistros = db.rawQuery("select Nombre from Usuarios where Nombre='" + Nombre+"'", null);
                if(ConjuntoRegistros.moveToFirst() == true)
                {

                    do
                    {

                        String UserSQL = ConjuntoRegistros.getString(0);

                        if(UserSQL.equals(Nombre))
                        {
                            Toast.makeText(this, "El usuario ya existe por favor elija otro", Toast.LENGTH_LONG).show();

                        }
                    }while (ConjuntoRegistros.moveToNext()==true);

                }
                else {
                    ContentValues nuevoregistro;
                    nuevoregistro= new ContentValues();
                    nuevoregistro.put("Nombre", Nombre);
                    db.insert("Usuarios", null, nuevoregistro);
                    Toast.makeText(this, "Se agregó el usuario: " + Nombre, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    boolean connectToDatabase() {
        db = acceso.getWritableDatabase();
        if (db != null) {
            return true;
        }
        return false;
    }
    public void Volver(View view)
    {
        Intent ir = new Intent(this, MainActivity.class);
        startActivity(ir);
    }
}
