package no.bacheloroppgaven.android.learningbasics4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;

import no.bacheloroppgaven.android.learningbasics4.services.ActionExecutorService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this);

        initButtons();
    }

    private void initButtons() {
        Button btn = (Button) findViewById(R.id.btn_trigger);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_trigger:
                startService(new Intent(getApplicationContext(), ActionExecutorService.class));
                break;
            default:
                Log.d("btn", "Could not find button");
        }
    }

    public class ActionBroadcaster extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView vActiveActions = (TextView) findViewById(R.id.txt_action_list);
            String[] activeActions = (String[]) intent.getExtras().get("activeActions");

            if (vActiveActions != null && activeActions != null) {
                for (String activeAction : activeActions) {
                    vActiveActions.setText(vActiveActions.getText() + "\n" + activeAction);
                }
            }
        }
    }
}
