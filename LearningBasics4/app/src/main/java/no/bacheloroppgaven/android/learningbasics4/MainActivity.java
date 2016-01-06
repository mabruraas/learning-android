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
    TextView vActiveActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this);

        initButtons();
        initTextFields();
    }

    private void initButtons() {
        Log.d("Init", "Initializing buttons");
        Button btn = (Button) findViewById(R.id.btn_trigger);
        btn.setOnClickListener(this);
    }

    private void initTextFields() {
        vActiveActions = (TextView) findViewById(R.id.txt_action_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_trigger:
                Log.d("OnClick", "Init IntentService, and trigger");
                startService(new Intent(getApplicationContext(), ActionExecutorService.class));
                break;
            default:
                Log.d("OnClick", "Could not find button");
        }
    }

    public class ActionBroadcaster extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ActionBroadcaster", "BroadcastReceiver triggered");

            Log.d("ActionBroadcaster", "Getting active actions from parameter intent sent from service");
            String[] activeActions = (String[]) intent.getExtras().get("activeActions");

            Log.d("ActionBroadcaster", "ActiveActions.length: " + activeActions.length);
            Log.d("ActionBroadcaster", "View component text: " + vActiveActions.getText());
            if (vActiveActions != null) {
                for (String activeAction : activeActions) {
                    Log.d("ActionBroadcaster", "Adding "+ activeAction + " as action to view component");
                    vActiveActions.setText(vActiveActions.getText() + "\n" + activeAction);
                }
            }
        }
    }
}
