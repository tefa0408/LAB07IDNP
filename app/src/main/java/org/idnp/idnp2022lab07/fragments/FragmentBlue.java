package org.idnp.idnp2022lab07.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.idnp.idnp2022lab07.R;

public class FragmentBlue extends Fragment implements FragmentCallbacks{
    public static final String SENDER="FRAGMENT_BLUE";
    private TextView txtMessageBlue;
    public FragmentBlue() {
        // Required empty public constructor
    }

    public static FragmentBlue newInstance(String param1, String param2) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_blue, container, false);
        txtMessageBlue=view.findViewById(R.id.txtMessageBlue);
        //return inflater.inflate(R.layout.fragment_blue, container, false);
        return view;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        txtMessageBlue.setText(strValue);
    }
}