package com.example.a42025177.pruebaprog2tdiegopertierra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 42025177 on 22/8/2017.
 */

public class FragmentResultados extends Fragment {
    TextView textView;
    Cambios activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resultadotextos_layout, container, false);
        activity = (Cambios) getActivity();
        textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(activity.textomaslargo);
        return view;
    }
}
