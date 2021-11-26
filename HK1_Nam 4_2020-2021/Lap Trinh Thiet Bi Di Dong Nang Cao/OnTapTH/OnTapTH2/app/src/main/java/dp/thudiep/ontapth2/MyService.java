package dp.thudiep.ontapth2;

import static dp.thudiep.ontapth2.MyApplication.CHANEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;


public class MyService extends Service {
    private String mText;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Thu Diệp","MyService onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String text = (String) bundle.get("object_song");

            if(text != null) {
                mText = text;
                sendNotification(text);
            }
        }
        return START_NOT_STICKY;
    }
    private void sendNotification(String text) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.notification);
        remoteViews.setTextViewText(R.id.text,text);

        // CHANEL_ID ghi r nhấn alt enter để import từ MyAplication
        Notification notification = new NotificationCompat.Builder(this,CHANEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setSound(null)
                .build();

        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Thu Diệp","MyService onDestroy");
    }
}
