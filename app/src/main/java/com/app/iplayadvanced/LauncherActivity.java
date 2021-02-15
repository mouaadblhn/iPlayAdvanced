package com.app.iplayadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class LauncherActivity extends AppCompatActivity {
    private final int LAUNCHER_DURATION = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        // Hide status bar.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get launcher logo & Animate it.
        ImageView launcherImg = (ImageView)findViewById(R.id.launcher_logo);
        launcherImg.setTranslationY(-200f);
        onAnimate(launcherImg);

        // Next Activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                finish();
            }
        },LAUNCHER_DURATION);
    }

    public void onAnimate(View view) {
        view.animate().alpha(1f).setDuration(800);
        view.animate().translationYBy(200).setDuration(800);
    }
}