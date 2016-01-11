package no.bacheloroppgaven.android.colorclicker.lobby.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import no.bacheloroppgaven.android.colorclicker.R;
import no.bacheloroppgaven.android.colorclicker.lobby.fragment.LobbyWaitFragment;
import no.bacheloroppgaven.android.colorclicker.lobby.fragment.StartGameFragment;

public class LobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Bundle extras = getIntent().getExtras();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (extras.getBoolean("host")) {
            ft.add(R.id.container_lobby, new StartGameFragment());
        } else {
            ft.add(R.id.container_lobby, new LobbyWaitFragment());
        }

        ft.commit();
    }
}
