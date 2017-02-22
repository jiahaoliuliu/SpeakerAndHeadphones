package com.example.jiahaoliu.speakerandheadphones;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

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

        stopSound();
    }

    private void playSound() {
        MediaPlayer mp = new MediaPlayer();
        if(!mp.isPlaying()){
//            playMusic();

            playMusicUsingUri();
        }
    }

    private void playMusic() {
        mMediaPlayer = MediaPlayer.create(mContext, R.raw.alert_now);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    private void playMusicUsingUri() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.reset();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
        // This also works
//        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);

        Uri uri = Uri.parse("android.resource://" + mContext.getPackageName() + "/" + R.raw.alert_now);

            try {
                mMediaPlayer.setDataSource(mContext, uri);
                mMediaPlayer.prepare();
                mMediaPlayer.setLooping(true);
                mMediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void stopSound() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }
}
