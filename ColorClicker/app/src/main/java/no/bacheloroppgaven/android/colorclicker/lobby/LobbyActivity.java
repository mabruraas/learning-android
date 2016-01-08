package no.bacheloroppgaven.android.colorclicker.lobby;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import no.bacheloroppgaven.android.colorclicker.R;

public class LobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (false) { // TODO: Check if user is host or participant
            ft.add(R.id.container_lobby, new LobbyWaitFragment());
        } else {
            ft.add(R.id.container_lobby, new StartGameFragment());
        }

        ft.commit();
    }
}
