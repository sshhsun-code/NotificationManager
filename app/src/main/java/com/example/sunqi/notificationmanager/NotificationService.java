package com.example.sunqi.notificationmanager;

import android.content.Context;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

/**
 * Created by sunqi on 2017/3/24.
 */

public class NotificationService extends NotificationListenerService {

    private NotificationDataHandler mhandler;
    private Context mContext;

    public NotificationService() {

    }

    public NotificationService(NotificationDataHandler handler, Context context) {
        this.mhandler = handler;
        this.mContext = context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
       if (mhandler != null) {
        mhandler.onNotificationPosted(sbn);
       }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (mhandler != null) {
            mhandler.onNotificationRemoved(sbn);
        }
    }

    public interface NotificationDataHandler {
        void onNotificationPosted(StatusBarNotification sbn);
        void onNotificationRemoved(StatusBarNotification sbn);
    }
}
