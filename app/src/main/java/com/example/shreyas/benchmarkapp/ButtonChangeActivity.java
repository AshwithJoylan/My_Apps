package com.example.shreyas.benchmarkapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ButtonChangeActivity extends AppCompatActivity {

    private static final String NOTIFICATION_CHANNEL_ID = "0";
    private Button btnChangeColor;
    private Button btnButton;
    private int NOTIFICATION_ID = 12323;
    NotificationCompat.Builder mBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_change);

        final Button btnChangeColor = (Button) findViewById(R.id.btnChangeColor);
        final Button btnButton = (Button) findViewById(R.id.btnButton);
        mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this, "M_CH_ID");
        mBuilder.setAutoCancel(true);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnChangeColor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ButtonChangeActivity.this, btnChangeColor);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.red:
                                sendNotification("Colour changed to Red");
                                btnButton.setBackgroundColor(Color.RED);
                                break;
                            case R.id.blue:
                                btnButton.setBackgroundColor(Color.BLUE);
                                sendNotification("Colour changed to Blue");
                                break;
                            case R.id.green:
                                btnButton.setBackgroundColor(Color.GREEN);
                                sendNotification("Colour changed to Green");
                                break;
                            case R.id.yellow:
                                btnButton.setBackgroundColor(Color.YELLOW);
                                sendNotification("Colour changed to Yellow");
                                break;
                        }
                        return true;
                    }
                });
                popup.show();//showing popup menu
            }
        });

    }

    private void sendNotification(String msg) {
        mBuilder.setSmallIcon(R.drawable.benchmark_icon);
        mBuilder.setTicker("Notification");
        mBuilder.setWhen(System.currentTimeMillis());
        mBuilder.setContentTitle("MyApp NotiFication");
        mBuilder.setContentText(msg);

        Intent intent = new Intent(this, ButtonChangeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID, mBuilder.build());



    }


}
