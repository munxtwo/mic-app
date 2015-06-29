package com.ktay.MicApp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.ktay.MicApp.receiver.ExternalSpeakerConnectionReceiver;

public class MainActivity extends Activity {

    private BroadcastReceiver mExternalSpeakerConnectionReceiver;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mExternalSpeakerConnectionReceiver = new ExternalSpeakerConnectionReceiver();
        getApplicationContext().registerReceiver(mExternalSpeakerConnectionReceiver, new IntentFilter(Intent
                .ACTION_HEADSET_PLUG));
    }

    @Override
    protected void onPause() {
        if (mExternalSpeakerConnectionReceiver != null) {
            getApplicationContext().unregisterReceiver(mExternalSpeakerConnectionReceiver);
        }

        super.onPause();
    }
}
