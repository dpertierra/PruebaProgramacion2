package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 42025177 on 22/8/2017.
 */

public class Textos_Fragment extends Fragment {
    EditText texto;
    EditText texto2;
    Button btn;
    Cambios activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textos_layout,container,false);
        texto = (EditText)view.findViewById(R.id.texto);
        texto2 = (EditText)view.findViewById(R.id.texto2);
        btn = (Button)view.findViewById(R.id.btn);
        activity = (Cambios) getActivity();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = texto.getText().toString().trim();
                String text2 = texto2.getText().toString().trim();
                activity.TextomasLargo(text1,text2);
                activity.ChangetoResultados();
            }
        });
        return view;
    }
}
