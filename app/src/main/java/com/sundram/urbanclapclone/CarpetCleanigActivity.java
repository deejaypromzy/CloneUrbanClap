package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CarpetCleanigActivity extends AppCompatActivity implements View.OnClickListener {

    TextView login_tv, back_tv;

    CollapsingToolbarLayout collapsingToolbarLayout;
    private VideoView mVideoView;
    MediaController mediaController;

    Toolbar toolbar;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpet_cleanig);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Carpet Services");

        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        login_tv.setOnClickListener(this);
        toolbar = findViewById(R.id.collpasableToolbar);
        setSupportActionBar(toolbar);

        //setting up the mediaController and videoView
        mVideoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        //setting up the path of the video
        initializePlayer();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(CarpetCleanigActivity.this, "Thank you for watching..",
                        Toast.LENGTH_SHORT).show();
                mVideoView.start();
            }
        });

        //setting up the collapsing toolbar

        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Carpet Cleaning");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                Intent jump = new Intent(CarpetCleanigActivity.this, ViewAllCarpetCleaningService.class);
                startActivity(jump);
                finish();
                break;

        }
    }


    private void initializePlayer() {
        mVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.confounding);
        mediaController.setAnchorView(mVideoView);

        mediaController.setMediaPlayer(mVideoView);
        mediaController.setVisibility(View.GONE);
        mVideoView.setMediaController(mediaController);
        mVideoView.start();
   /*     FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        mediaController.setLayoutParams(lp);

        ((ViewGroup) mediaController.getParent()).removeView(mediaController);

        ((FrameLayout) findViewById(R.id.videoViewWrapper)).addView(mediaController);*/
    }

    private void releasePlayer() {
        mVideoView.stopPlayback();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(CarpetCleanigActivity.this, ServiceListItem.class);
        startActivity(back);
        finish();
    }
}
