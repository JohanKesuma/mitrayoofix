package com.example.mitrayoofix.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mitrayoofix.MainActivity;
import com.example.mitrayoofix.R;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView yofix, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.logo_dashboard);
        yofix = findViewById(R.id.yoofix_text);
        slogan = findViewById(R.id.yoofix_sub_text);

        image.setAnimation(topAnim);
        yofix.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    private void runMain() {
        Intent intent = new Intent(this, MainActivity.class);

    }
}
