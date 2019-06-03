package com.example.a51006705.notification_actionsbuttons_colors;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IntRange;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a51006705.notification_actionsbuttons_colors.App.CHANNEL_1_ID;
import static com.example.a51006705.notification_actionsbuttons_colors.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTitle;
    private EditText mEditTextMessage;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTitle = findViewById(R.id.edit_text_title);
        mEditTextMessage = findViewById(R.id.edit_text_message);



        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel1(View view) {
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();
        //to open main activity by touching
        Intent intent = new Intent(this, MainActivity.class);
        //It is a wrappper for Intent cause NotificationCompat.setContentIntent takes Pending Intent not Intent.
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent,0);

        //It is for opening another class
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toast", message);
        //FLAG_UPDAte_current to update message
        PendingIntent notificationIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                //setAutoCancelTrue means on touching it will disappear after performing action
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", notificationIntent)
                .build();
        notificationManagerCompat.notify(1, notification);

    }

    public void sendOnChannel2(View view) {

        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();
        Intent actionIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getService(this,0, actionIntent,0);

        Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setColor(Color.RED)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
}
