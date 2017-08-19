package com.example.diego.ejemplopruebaprog2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Diego on 18/8/2017.
 */

public class BasePruebaSQLiteHelper extends SQLiteOpenHelper {

        public BasePruebaSQLiteHelper(Context context, String Nombre, SQLiteDatabase.CursorFactory fabrica, int version)
        {
            super(context, Nombre, fabrica,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("SQLite","Declaro e inicializo la variable para crear la tabla Peliculas");
            String sqlCrearTablaPeliculas;
            sqlCrearTablaPeliculas= "create table Peliculas(Pelicula text)";
            Log.d("SQLite" , "Invoco creador de tabla");
            db.execSQL(sqlCrearTablaPeliculas);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {

        }
    }

