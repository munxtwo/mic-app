package com.ktay.MicApp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.ktay.MicApp.R;
import com.ktay.MicApp.task.StreamAudioTask;

/**
 * Displays UI for toggle button to turn mic on/off.
 */
public class ToggleMicActivity extends Activity {

	private static final String TAG = "ToggleMicActivity";
	private static final String TOGGLE_MIC_INTENT_STATUS_KEY = "status";
	private static final int SPEAKER_PLUGGED = 1;

	private StreamAudioTask mStreamAudioTask;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		if ((Integer) intent.getExtras().get(TOGGLE_MIC_INTENT_STATUS_KEY) == SPEAKER_PLUGGED) {
			setContentView(R.layout.toggle_mic);
			setupToggleButton();
		} else {
			Log.d(TAG, "Speaker unplugged, nothing happening!!!");
		}
	}

	private void setupToggleButton() {
		ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					// The toggle is enabled
					Log.d(TAG, "Mic toggle enabled ...");

					mStreamAudioTask = new StreamAudioTask(getApplicationContext());
					mStreamAudioTask.execute();
				} else {
					// The toggle is disabled
					Log.d(TAG, "Mic toggle disabled ...");

					if (mStreamAudioTask != null) {
						mStreamAudioTask.cancel(true);
					}
				}
			}
		});
	}
}
