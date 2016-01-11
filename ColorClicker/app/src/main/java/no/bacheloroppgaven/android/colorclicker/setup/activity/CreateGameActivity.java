package no.bacheloroppgaven.android.colorclicker.setup.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import no.bacheloroppgaven.android.colorclicker.R;
import no.bacheloroppgaven.android.colorclicker.setup.fragment.CreateGameFragment;

public class CreateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_create_game, new CreateGameFragment());
        ft.commit();
    }
}
