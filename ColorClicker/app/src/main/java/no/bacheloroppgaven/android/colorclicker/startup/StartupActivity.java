package no.bacheloroppgaven.android.colorclicker.startup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import no.bacheloroppgaven.android.colorclicker.R;

public class StartupActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private static final int[] BUTTONS = {
            R.id.btn_create_new_game,
            R.id.btn_join_game
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        initButtons();
    }

    private void initButtons() {
        for (int id : BUTTONS) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_join_game:
                // JoinGameFragment
                break;
            case R.id.btn_create_new_game:
                // CreateGameFragment
                break;
            default:
                // ShowError ?
                break;
        }
    }
}
