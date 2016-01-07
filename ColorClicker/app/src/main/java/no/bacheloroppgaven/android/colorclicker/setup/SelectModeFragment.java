package no.bacheloroppgaven.android.colorclicker.setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.bacheloroppgaven.android.colorclicker.R;

public class SelectModeFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "SelectModeFragment";
    private static final int[] BUTTONS = {
            R.id.btn_mode_join,
            R.id.btn_mode_create,
            R.id.btn_mode_practice
    };

    public SelectModeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_mode, container, false);

        for (int id : BUTTONS) {
            view.findViewById(id).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mode_create:
                Log.d(LOG_TAG, "Starting new transaction for creating new game");
                startActivity(new Intent(getContext(), CreateGameActivity.class));
                break;
            case R.id.btn_mode_join:
                Log.d(LOG_TAG, "Starting new transaction for joining existing game");
                startActivity(new Intent(getContext(), JoinGameActivity.class));
                break;
            case R.id.btn_mode_practice:
                Log.d(LOG_TAG, "Starting new transaction for offline practice");
//                startActivity(new Intent(getContext(), LocalGameActivity.class));
                break;
            default:
                Log.e(LOG_TAG, "Selected mode is not supported");
        }
    }
}
