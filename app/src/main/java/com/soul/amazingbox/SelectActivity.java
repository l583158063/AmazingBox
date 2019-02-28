package com.soul.amazingbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void onToSockButtonDown(View view) {
        Intent i = new Intent(SelectActivity.this, SocketActivity.class);
        startActivity(i);
    }

    public void onToHumitureButtonDown(View view) {
        Intent i = new Intent(SelectActivity.this, HumitureActivity.class);
        startActivity(i);
    }

    public void onToIrButtonDown(View view) {
        Intent i = new Intent(SelectActivity.this, RemoteActivity.class);
        startActivity(i);
    }
}
