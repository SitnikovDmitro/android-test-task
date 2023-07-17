package com.testtask.example1432;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchGame(View view) {
        startActivity(new Intent(this, GameActivity.class));
    }

    public void launchBrowser(View view) {
        startActivity(new Intent(this, BrowserActivity.class));
    }

}