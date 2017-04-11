package vacunas.app.com.appvacunas.clases;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import vacunas.app.com.appvacunas.HijosActivity;
import vacunas.app.com.appvacunas.VacunasActivity;
import vacunas.app.com.appvacunas.R;
import vacunas.app.com.appvacunas.Calculador;

/**
 * Created by adriana on 9/4/2017.
 */

public class Receiver extends BroadcastReceiver{
  @Override
  public void onReceive(Context context, Intent intent) {
    NotificationCompat.Builder mBuilder =
      new NotificationCompat.Builder(context)
        .setSmallIcon(R.drawable.ic_notifications)
        .setContentTitle("Vacunar")
        .setContentText("Vacuna Pendiente");
    Intent resultIntent = new Intent(context, VacunasActivity.class);
    int id = intent.getIntExtra(HijosActivity.EXTRA_HIJO_ID, 1);
    resultIntent.putExtra(HijosActivity.EXTRA_HIJO_ID, id);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    stackBuilder.addParentStack(VacunasActivity.class);
    stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    mBuilder.setContentIntent(resultPendingIntent);
    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    mBuilder.setAutoCancel(true);
    mNotificationManager.notify(1, mBuilder.build());
  }


}
