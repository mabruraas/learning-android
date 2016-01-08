package no.bacheloroppgaven.android.colorclicker.lobby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.bacheloroppgaven.android.colorclicker.R;
import no.bacheloroppgaven.android.colorclicker.game.GameActivity;

public class StartGameFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "StartGameFragment";
    private static final int[] BUTTONS = {
            R.id.btn_start_game
    };

    public StartGameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_game, container, false);

        for (int id : BUTTONS) {
            // TODO: Make button clickable
//            getActivity().findViewById(id).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_game:
                Log.d(LOG_TAG, "Starting game");
                startActivity(new Intent(getContext(), GameActivity.class));
                break;
            default:
                Log.e(LOG_TAG, "View not recognized");
        }
    }
}
