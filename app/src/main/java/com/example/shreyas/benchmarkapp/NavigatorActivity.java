package com.example.shreyas.benchmarkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigatorActivity extends AppCompatActivity {
    private Button btnBenchmark;

    public void setIntent(View view) {
        switch (view.getId()) {
            case R.id.btnBenchmark:
                Intent i1 = new Intent(getBaseContext(), BenchmarkMainActivity.class);
                startActivity(i1);
                break;

            case R.id.btnImageConverter:
                Intent i2 = new Intent(getBaseContext(), ImageActivity.class);
                startActivity(i2);
                break;
            case R.id.btnChangeColor:
                Intent i3 = new Intent(getBaseContext(), ButtonChangeActivity.class);
                startActivity(i3);
                break;
            default:
                break;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        btnBenchmark = (Button) findViewById(R.id.btnBenchmark);

    }
}
