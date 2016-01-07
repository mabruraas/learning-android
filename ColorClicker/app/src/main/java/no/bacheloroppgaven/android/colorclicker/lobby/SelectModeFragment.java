package no.bacheloroppgaven.android.colorclicker.lobby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import no.bacheloroppgaven.android.colorclicker.R;

public class SelectModeFragment extends Fragment implements View.OnClickListener {
    public SelectModeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_mode, container, false);

        Button b = (Button) view.findViewById(R.id.btn_mode_join);
        b.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mode_join:
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.activity_lobby_fragment_container, new JoinGameFragment());

                ft.commit();
                break;
            default:
        }
    }
}
