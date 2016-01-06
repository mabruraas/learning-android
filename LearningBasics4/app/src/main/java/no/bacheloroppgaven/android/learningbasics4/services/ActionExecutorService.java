package no.bacheloroppgaven.android.learningbasics4.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import no.bacheloroppgaven.android.learningbasics4.MainActivity;

public class ActionExecutorService extends IntentService {

    /**
     * Creates an IntentService.
     * Invoked by your subclass's constructor.
     */
    public ActionExecutorService() {
        super("ActionExecutorService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Bundle extras = intent.getExtras(); // For sending service parameters
        List<String> actions = getActiveActions();
        Intent broadcastIntent = new Intent();


        broadcastIntent.setAction(MainActivity.ActionBroadcaster.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);

        Log.d("ActionExecutorService", "Putting active actions on broadcaster intent");
       // broadcastIntent.putExtra("activeActions", actions.toArray());
        broadcastIntent.putStringArrayListExtra("activeActions", (ArrayList<String>) actions);

        Log.d("ActionExecutorService", "Sending broadcast");
        sendBroadcast(broadcastIntent);
    }

    private List<String> getActiveActions() {
        Log.d("ActiveActions", "Finding active actions in database");
        List<String> activeActions = new ArrayList<>();
        ParseQuery<ParseObject> query = new ParseQuery<>("Action");

        try {
            for (ParseObject parseObject : query.find()) {
                if (parseObject.getBoolean("active")) {
                    String activeAction = parseObject.getString("actionName");
                    Log.d("ActiveActions", "Found:" + activeAction);
                    activeActions.add(activeAction);
                }
            }
        } catch (ParseException e) {
            Log.d("ActiveActions", "ParseException occurred");
            e.printStackTrace();
        }

        Log.d("ActiveActions", "Found " + activeActions.size() + " active actions");
        return activeActions;
    }
}

