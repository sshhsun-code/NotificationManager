package com.example.sunqi.notificationmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

/**
 * Created by sunqi on 2017/3/24.
 */

public class NotificationUtil {

    public static void showNotificaiton(Context context){
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("通知标题");
        builder.setContentText("通知内容");
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
