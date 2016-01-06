package no.bacheloroppgaven.android.learningbasics4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.parse.Parse;

import no.bacheloroppgaven.android.learningbasics4.services.ActionExecutorService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this);

        startService(new Intent(getApplicationContext(), ActionExecutorService.class));
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
