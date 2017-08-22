package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Cambios extends AppCompatActivity {
    FragmentManager manager;
    FragmentTransaction transaction;
    String textomaslargo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);
        manager = getSupportFragmentManager();
        Fragment textos = new Textos_Fragment();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.holder, textos);
        transaction.commit();
    }
    public String TextomasLargo(String text1, String text2)
    {


        if (text1.length()>text2.length())
        {
            textomaslargo = text1 +" " + "(" + text1.length() + ")";
        }
        else if (text2.length()>text1.length())
        {
            textomaslargo = text2 +" " + "(" + text2.length() + ")";
        }
        else {
            textomaslargo = "Los textos tenian la misma cantidad de caracteres " + "(" + text1.length()+")";
        }
        return textomaslargo;
    }
    public void ChangetoResultados()
    {
        manager = getSupportFragmentManager();
        Fragment resultados = new FragmentResultados();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.holder, resultados);
        transaction.commit();
    }

}
