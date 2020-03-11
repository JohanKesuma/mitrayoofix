package com.example.mitrayoofix.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mitrayoofix.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onMasukButtonClicked(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterPagerActivity.class);
        startActivity(intent);
    }
}
