package com.ktay.MicApp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.ktay.MicApp.activity.ToggleMicActivity;

/**
 * BroadcastReceiver that listens for the ACTION_HEADSET_PLUG intent.
 */
public class ExternalSpeakerConnectionReceiver extends BroadcastReceiver {

	private static final String TAG = "ExternalSpeakerConnectionReceiver";

	private static final String ACTION_HEADSET_INTENT_STATE_KEY = "state";

	private static final String TOGGLE_MIC_INTENT_STATUS_KEY = "status";

	private static final int SPEAKER_UNPLUGGED = 0;

	private static final int SPEAKER_PLUGGED = 1;

	@Override
	public void onReceive(final Context context, Intent intent) {
		Intent toggleMicIntent = new Intent(context, ToggleMicActivity.class);

		// 0 for unplugged, 1 for plugged
		if (intent.getIntExtra(ACTION_HEADSET_INTENT_STATE_KEY, 0) == 0) {
			Log.d(TAG, "External speaker unplugged ...");

			toggleMicIntent.putExtra(TOGGLE_MIC_INTENT_STATUS_KEY, SPEAKER_UNPLUGGED);
		} else {
			Log.d(TAG, "External speaker plugged ...");

			toggleMicIntent.putExtra(TOGGLE_MIC_INTENT_STATUS_KEY, SPEAKER_PLUGGED);
		}

		context.startActivity(toggleMicIntent);
	}
}
