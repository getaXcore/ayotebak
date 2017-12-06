package taufan.ayotebak;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Taufan Septaufani on 06-Dec-17.
 */

public class serv extends Service {
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.gametune);
        mp.setLooping(false);

    }
    public void onDestroy()
    {
        mp.stop();
    }
    public void onStart(Intent intent,int startid){

        Log.d("On start","gametune");
        mp.start();
    }
}
