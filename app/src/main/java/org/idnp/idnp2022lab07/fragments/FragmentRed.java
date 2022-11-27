package org.idnp.idnp2022lab07.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.idnp.idnp2022lab07.R;
import org.idnp.idnp2022lab07.activities.MainActivity;


public class FragmentRed extends Fragment
        implements FragmentCallbacks {

    public static final String SENDER = "FRAGMENT_RED";
    private Context context;
    private Button btnFragRedSend;
    private MainActivity main;
    private TextView txtMensajeRed;

    public FragmentRed() {
    }

    public static FragmentRed newInstance() {
        FragmentRed fragment = new FragmentRed();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        try {
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_red, container, false);
        btnFragRedSend = view.findViewById(R.id.btnFragRedSend);
        txtMensajeRed = view.findViewById(R.id.txtMensajeRed);

        btnFragRedSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.onMsgFromFragToMain("RED", "Mensaje");
            }
        });

        return view;
    }


    @Override
    public void onMsgFromMainToFragment(String strValue) {
        txtMensajeRed.setText(strValue);
    }
}