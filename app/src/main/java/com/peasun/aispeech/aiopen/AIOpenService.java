package com.peasun.aispeech.aiopen;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Shahsen on 2020/2/23.
 */
public class AIOpenService extends Service {
    private String TAG = "AIOpenService";

    AIOpenReceiver aiOpenReceiver = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Bundle data = intent.getExtras();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                switch (action) {
                    case AIOpenConstant.AI_OPEN_ACTION_LIVE: {
                        if (data != null) {
                            //play text
                            String command = data.getString("common");
                            String keyword = data.getString("keyword");

                            Log.d(TAG, "receive :" + command + ", " + keyword);
                            if (TextUtils.isEmpty(command) || TextUtils.isEmpty(keyword)) {
                                //todo
                                //task for channel changing

                            }
                        }
                    }
                    break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //register live app to ai server
        AIOpenUtils.registerLiveTvApp(this);

        //register receiver
        aiOpenReceiver = AIOpenUtils.registerLiveTvReciver(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        unregisterReceiver(aiOpenReceiver);
    }
}
