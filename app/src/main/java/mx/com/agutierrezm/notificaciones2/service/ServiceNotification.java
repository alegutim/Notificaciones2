package mx.com.agutierrezm.notificaciones2.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import mx.com.agutierrezm.notificaciones2.R;

/**
 * Created by Alumno on 24/06/2016.
 */
public class ServiceNotification extends Service {
    private MyAsyncTask myAsyncTask;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myAsyncTask==null){
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute();
        }

        return START_STICKY;
    }

    private class MyAsyncTask extends AsyncTask<Integer,Integer,Boolean>
    {
        private NotificationCompat.Builder mNotif;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mNotif = new NotificationCompat
                    .Builder(getApplicationContext())
                    .setContentTitle("Descargando MP4")
                    .setContentText("Descargando pumas vs jaguares")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_communication_ring_volume))
                    .setSmallIcon(android.R.drawable.ic_dialog_email);
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            for ( int i=0; i<10;i++) {
                publishProgress(i);
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }



        @Override
        protected void onProgressUpdate(Integer... values) {
            mNotif.setProgress(10,values[0],false);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0,mNotif.build());

        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result){
                // eliminar progreso
                mNotif.setProgress(0,0,false);
                mNotif.setContentTitle("Descarga completa ;)");
                mNotif.setContentText("Se ha compleado la descarga de pumas");
                mNotif.setContentInfo("Descargado");

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,mNotif.build());
                myAsyncTask = null;

            }
        }
    }

}
