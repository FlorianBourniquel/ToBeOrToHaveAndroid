package com.example.florian.tobeortohave.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;

import com.example.florian.tobeortohave.activity.MainCategory;
import com.example.florian.tobeortohave.activity.MainProductSheet;
import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.R;

import java.util.Date;
import java.util.List;

/**
 * Created by Florian on 16/05/2017.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        List<Product> products = Database.getInstance().getProducts();
        for (int i = products.size() - 1; i > products.size() - 3; i--) {
            products.get(i).setNewNotification(true);
            products.get(i).setNotification(true);
            products.get(i).setDate(new Date(System.currentTimeMillis()));
        }
        List<Product> productList = Database.getInstance().getUser().getFollowedProductsWithNotification();
        int mid = 0;
        for (Product product: productList) {
            android.support.v4.app.NotificationCompat.Builder mBuilder =
                    new android.support.v4.app.NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.ic_menu_share)
                            .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_icon))
                            .setContentTitle(product.getName())
                            .setContentText("Il y a une nouvelle promotion sur cet article.");
            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(context, MainProductSheet.class);
            Bundle b = new Bundle();
            b.putString("key", product.getName());
            resultIntent.putExtras(b);
            resultIntent.setAction(Long.toString(System.currentTimeMillis()));
            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainCategory.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            // mId allows you to update the notification later on.
            mBuilder.mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
            mNotificationManager.notify(mid++, mBuilder.build());
        }
    }
}