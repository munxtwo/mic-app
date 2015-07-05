package com.ktay.MicApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.ktay.MicApp.activity.ToggleMicActivity;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent toggleMicIntent = new Intent(getApplicationContext(), ToggleMicActivity.class);
        startActivity(toggleMicIntent);
    }

}
