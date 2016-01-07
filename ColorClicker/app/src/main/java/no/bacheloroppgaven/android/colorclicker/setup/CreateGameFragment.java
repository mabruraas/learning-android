package no.bacheloroppgaven.android.colorclicker.setup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.bacheloroppgaven.android.colorclicker.R;

public class CreateGameFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "SelectModeFragment";
    private static final int[] BUTTONS = {
//            R.id.btn_mode_join,
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
            default:
                Log.e(LOG_TAG, "Selected mode is not supported");
        }
    }
}
