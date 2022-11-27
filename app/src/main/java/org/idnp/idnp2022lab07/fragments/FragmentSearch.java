package org.idnp.idnp2022lab07.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.idnp.idnp2022lab07.R;
import org.idnp.idnp2022lab07.activities.MainActivity;

public class FragmentSearch extends Fragment implements FragmentCallbacks{
    public static final String SENDER = "FRAGMENT_SEARCH";
    private Button btnBuscar;
    private EditText edtParametro;
    private TextView txtFragmentIn;
    private MainActivity main;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSearch() {
        // Required empty public constructor
    }

    public static FragmentSearch newInstance(String param1, String param2) {
        FragmentSearch fragment = new FragmentSearch();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        btnBuscar = view.findViewById(R.id.btnBuscarParametro);
        edtParametro = view.findViewById(R.id.edtBuscarParametro);
        txtFragmentIn= view.findViewById(R.id.txtFragmentIn);

        btnBuscar.setOnClickListener(btnBuscar_Event);
        //return inflater.inflate(R.layout.fragment_buscar, container, false);

        return view;
    }

    private View.OnClickListener btnBuscar_Event = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String parametro = edtParametro.getText().toString();
            main.onMsgFromFragToMain(SENDER, parametro);
        }
    };

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        txtFragmentIn.setText(strValue);
    }
}