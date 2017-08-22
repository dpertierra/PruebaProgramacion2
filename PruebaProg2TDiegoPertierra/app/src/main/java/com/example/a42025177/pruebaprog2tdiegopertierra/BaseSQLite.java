package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 42025177 on 22/8/2017.
 */

public class BaseSQLite extends SQLiteOpenHelper {

    public BaseSQLite(Context context, String Nombre, SQLiteDatabase.CursorFactory fabrica, int version)
    {
        super(context, Nombre, fabrica,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Peliculas");
        String sqlCrearTablaPeliculas;
        sqlCrearTablaPeliculas= "create table Usuarios(Nombre text)";
        Log.d("SQLite" , "Invoco creador de tabla");
        db.execSQL(sqlCrearTablaPeliculas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
