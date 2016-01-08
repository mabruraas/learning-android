package no.bacheloroppgaven.android.colorclicker.setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.bacheloroppgaven.android.colorclicker.R;
import no.bacheloroppgaven.android.colorclicker.lobby.LobbyActivity;

public class CreateGameFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "SelectModeFragment";
    private static final int[] BUTTONS = {
            R.id.btn_create_create_game
    };

    public CreateGameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_game, container, false);

        for (int id : BUTTONS) {
            view.findViewById(id).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_create_game:
                // TODO: Check all view fields, save variables and start gameActivity
                Intent lobbyIntent = getConfigFromView();
                Log.d(LOG_TAG, "Starting game");
                startActivity(lobbyIntent);
                break;
            default:
                Log.e(LOG_TAG, "Selected mode is not supported");
        }
    }

    private Intent getConfigFromView() {
        Intent lobbyIntent = new Intent(getContext(), LobbyActivity.class);
        lobbyIntent.putExtra("host", true);
        return lobbyIntent;
    }
}
