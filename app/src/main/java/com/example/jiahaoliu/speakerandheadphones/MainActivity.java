package com.example.jiahaoliu.speakerandheadphones;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        playSound();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }

    }

    private void playSound() {
        AudioManager audioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setMode(AudioManager.STREAM_MUSIC);
        // Force the music to be played on the speaker
//        audioManager.setSpeakerphoneOn(true);
//        audioManager.setWiredHeadsetOn(true);

        MediaPlayer mediaPlayer = new MediaPlayer();
        if(!mediaPlayer.isPlaying()){
            mMediaPlayer = MediaPlayer.create(mContext, R.raw.alert_now);
//            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.start();
        }
    }
}
