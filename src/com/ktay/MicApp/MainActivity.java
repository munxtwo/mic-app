package com.ktay.MicApp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(getApplicationContext(), "enabled", Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle is disabled
                    Toast.makeText(getApplicationContext(), "disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
