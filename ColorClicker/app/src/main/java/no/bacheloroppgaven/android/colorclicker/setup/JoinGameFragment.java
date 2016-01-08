package no.bacheloroppgaven.android.colorclicker.setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import no.bacheloroppgaven.android.colorclicker.R;
import no.bacheloroppgaven.android.colorclicker.lobby.LobbyActivity;

public class JoinGameFragment extends Fragment implements View.OnClickListener {
    private static final String LOG_TAG = "JoinGameFragment";
    private static final int[] BUTTONS = {
            R.id.btn_join_find_game,
            R.id.btn_join_random
    };

    public JoinGameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_join_game, container, false);

        for (int id : BUTTONS) {
            view.findViewById(id).setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.btn_join_find_game:
                i = getGame();
                break;
            case R.id.btn_join_random:
                i = getOldestAvailableGame();
                break;
            default:
                Log.e(LOG_TAG, "View not recognized");
        }
        openLobby(i);
    }

    private void openLobby(Intent i) {
        if (i != null) {
            Log.d(LOG_TAG, "Opening game lobby");
            startActivity(i);
        } else {
            Log.d(LOG_TAG, "Intent was null");
        }
    }

    private Intent getGame() {
        String enteredKey = ((EditText)
                getActivity().findViewById(R.id.etxt_game_key)).getText().toString();

        findGameByGameKey(enteredKey);
        Intent lobbyIntent = new Intent(getContext(), LobbyActivity.class);
        lobbyIntent.putExtra("host", false);
        return lobbyIntent;
    }

    private Intent getOldestAvailableGame() {
        // TODO: Get oldest available game in db
        Log.d(LOG_TAG, "Finding oldest available game");

        return new Intent(getContext(), LobbyActivity.class);
    }

    private void findGameByGameKey(String key) {
        if (key != null && !key.isEmpty()) {
            Log.d(LOG_TAG, "Finding game by key: " + key);
            // TODO: get game by key
        } else {
            Log.i(LOG_TAG, "Entered key was empty");
            // TODO: Handle invalid key
        }
    }
}
