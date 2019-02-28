package com.soul.amazingbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HumitureActivity extends AppCompatActivity {

    int count = 62;
    private MyWatch watchTemperature;
    private MyWatch watchHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humiture);

        watchTemperature = (MyWatch) findViewById(R.id.watchTemperature);
        watchHumidity = (MyWatch) findViewById(R.id.watchHumidity);
    }

    public void onTestClick(View view) {
        watchTemperature.setSpeed(count);
        watchHumidity.setSpeed(count);
    }
}
