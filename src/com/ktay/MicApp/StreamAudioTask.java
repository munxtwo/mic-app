package com.ktay.MicApp;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.AsyncTask;
import android.widget.Toast;

public class StreamAudioTask extends AsyncTask<Integer, Void, Void> {

    private static final int RECORDING_RATE = 44100;
    private static final int CHANNEL = AudioFormat.CHANNEL_IN_MONO;
    private static final int FORMAT = AudioFormat.ENCODING_PCM_16BIT;

    private static int BUFFER_SIZE = AudioRecord.getMinBufferSize(
            RECORDING_RATE, CHANNEL, FORMAT);

    private Context mContext;

    public StreamAudioTask(final Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        if (!isCancelled()) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onCancelled(Void aVoid) {
//        super.onCancelled(aVoid);
        Toast.makeText(mContext, "disabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(mContext, "enabled", Toast.LENGTH_SHORT).show();
    }
}
