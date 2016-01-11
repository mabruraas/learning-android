package no.bacheloroppgaven.android.colorclicker.lobby.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.bacheloroppgaven.android.colorclicker.R;

public class LobbyWaitFragment extends Fragment {
    public LobbyWaitFragment() {
        // Required empty public constructor
    }

    public static LobbyWaitFragment newInstance(String param1, String param2) {
        LobbyWaitFragment fragment = new LobbyWaitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lobby_wait, container, false);



        return view;
    }
}
