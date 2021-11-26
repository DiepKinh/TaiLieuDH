package dp.thudiep.notification_toan;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Thu Diệp","MyService onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Toan song = (Toan) bundle.get("object_song");

            if(song != null) {
                mToan = song;
                sendNotification(song);
            }
        }
        return START_NOT_STICKY;
    }
    private void sendNotification(Toan song) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.notification);
        remoteViews.setTextViewText(R.id.tv_A,song.getTv_A());
        remoteViews.setTextViewText(R.id.tv_B,song.getTv_B());
        remoteViews.setTextViewText(R.id.tv_KQ,song.getTv_KQ());
        remoteViews.setTextViewText(R.id.img_pt,song.getTv_PT());




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
