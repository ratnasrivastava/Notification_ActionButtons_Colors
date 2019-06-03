package com.example.a51006705.notification_actionsbuttons_colors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 51006705 on 03-06-2019.
 */

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("toast");
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
