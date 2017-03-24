package com.example.sunqi.notificationmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.service.notification.StatusBarNotification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NotificationService.NotificationDataHandler{
    private Button start_service_btn;
    private Button send_a_notificaiton;
    private Context mContext;
    private NotificationService service;
    private TextView notification_info_text;

    private Handler mhandler =  new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mContext = getApplicationContext();
    }

    private void initView() {
        notification_info_text = (TextView) findViewById(R.id.notification_info_text);
        start_service_btn = (Button) findViewById(R.id.start_service_btn);
        start_service_btn.setOnClickListener(this);
        send_a_notificaiton = (Button) findViewById(R.id.send_a_notificaiton);
        send_a_notificaiton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service_btn:
                service = new NotificationService(this,this);
                Intent intent = new Intent();
                intent.setClass(mContext,service.getClass());
                startService(intent);
                break;
            case R.id.send_a_notificaiton:
                NotificationUtil.showNotificaiton(this);
                break;
        }
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        StringBuilder sb = new StringBuilder();
        sb.append(sbn.getPackageName() + " : ")
                .append(sbn.getPostTime() + " : ")
                .append(sbn.toString());
        notification_info_text.append(sb.toString() + "/n");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        notification_info_text.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
