package no.bacheloroppgaven.android.learningbasics1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
    }

    private void initButtons() {
        btnNotes = (Button) findViewById(R.id.btn_notes);
        btnNotes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_notes:
                Intent i = new Intent(getApplicationContext(), NotesActivity.class);
                startActivity(i);
                break;
            default:
        }
    }


}
