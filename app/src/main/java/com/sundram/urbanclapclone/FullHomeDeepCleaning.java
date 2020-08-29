package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class FullHomeDeepCleaning extends AppCompatActivity implements View.OnClickListener {

    TextView login_tv, back_tv;
    ImageView collapseImage_bg;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private VideoView mVideoView;
    MediaController mediaController; @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_home_deep_cleaning);
        login_tv = findViewById(R.id.login_button_text);
        login_tv.setText("View all Full Home Cleaning Services");
        login_tv.setOnClickListener(this);
        back_tv = findViewById(R.id.back_tv);
        back_tv.setOnClickListener(this);
        //setting up the title of collapsableToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);
        collapsingToolbarLayout.setTitle("Full Home Cleaning Services");
      //  collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(R.color.white));
//setting up the mediaController and videoView
        mVideoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        //setting up the path of the video
        initializePlayer();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(FullHomeDeepCleaning.this, "Thank you for watching..",
                        Toast.LENGTH_SHORT).show();
                mVideoView.start();
            }
        });
        //setting collapsetoolbar bg
       // collapseImage_bg = findViewById(R.id.collapse_iv);
       // collapseImage_bg.setBackgroundResource(R.drawable.full_home_cleaning);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.login_button_text:
                Intent jump = new Intent(FullHomeDeepCleaning.this, ViewAllFullHomeDeepCleaning.class);
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
        Intent back = new Intent(FullHomeDeepCleaning.this,ServiceListItem.class);
        startActivity(back);
        finish();
    }
}
