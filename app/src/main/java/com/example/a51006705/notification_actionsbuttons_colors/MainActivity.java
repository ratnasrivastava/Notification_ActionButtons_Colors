package com.example.a51006705.notification_actionsbuttons_colors;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a51006705.notification_actionsbuttons_colors.App.CHANNEL_1_ID;

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


    }

    public void sendOnChannel2(View view) {
    }
}
