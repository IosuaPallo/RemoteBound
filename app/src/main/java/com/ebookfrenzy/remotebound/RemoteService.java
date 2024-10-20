package com.ebookfrenzy.remotebound;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RemoteService extends Service {

    final Messenger myMessenger = new Messenger(new IncomingHandler());




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myMessenger.getBinder();
    }

    public RemoteService() {
    }

    class IncomingHandler extends Handler{
        public void handleMessage(Message message){
            Bundle data = message.getData();
            String dataString = data.getString("MyString");
            Toast.makeText(getApplicationContext(), dataString,Toast.LENGTH_SHORT).show();
        }
    }

}
