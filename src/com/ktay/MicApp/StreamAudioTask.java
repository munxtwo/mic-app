package com.ktay.MicApp;

import android.content.Context;
import android.media.*;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class StreamAudioTask extends AsyncTask<Integer, Void, Void> {

    private static final String TAG = "Mic-App";

    private static final int RECORDING_RATE = 44100;
    private static final int CHANNEL_IN = AudioFormat.CHANNEL_IN_MONO;
    private static final int CHANNEL_OUT = AudioFormat.CHANNEL_OUT_MONO;
    private static final int FORMAT = AudioFormat.ENCODING_PCM_16BIT;

    private static int BUFFER_SIZE = AudioRecord.getMinBufferSize(
            RECORDING_RATE, CHANNEL_IN, FORMAT);

    private Context mContext;

    private AudioRecord audioRecorder;

    private AudioTrack audioTrack;

    private byte[] audioBuffer;

    public StreamAudioTask(final Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        try {
            audioBuffer = new byte[BUFFER_SIZE];
            audioRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC, RECORDING_RATE, CHANNEL_IN, FORMAT,
                    BUFFER_SIZE);
            audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, RECORDING_RATE, CHANNEL_OUT, FORMAT, BUFFER_SIZE,
                    AudioTrack.MODE_STREAM);

            Log.d(TAG, "Start AudioRecorder recording ...");
            audioRecorder.startRecording();

            Log.d(TAG, "Start AudioTrack playing ...");
            audioTrack.play();

            while (!isCancelled()) {
                audioRecorder.read(audioBuffer, 0, audioBuffer.length);
                audioTrack.write(audioBuffer, 0, audioBuffer.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onCancelled(Void aVoid) {
        Toast.makeText(mContext, "disabled", Toast.LENGTH_SHORT).show();
        audioRecorder.release();
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(mContext, "enabled", Toast.LENGTH_SHORT).show();
    }
}
