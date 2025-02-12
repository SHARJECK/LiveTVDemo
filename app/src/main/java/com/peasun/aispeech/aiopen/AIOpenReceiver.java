package com.peasun.aispeech.aiopen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Shahsen on 2020/2/23.
 */
public class AIOpenReceiver extends BroadcastReceiver {
    private String TAG = "AIOpenReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        String action = intent.getAction();
        Bundle data = intent.getExtras();
        if (TextUtils.isEmpty(action)) {
            return;
        }

        switch (action) {
            case AIOpenConstant.AI_OPEN_ACTION_APP_REGISTER_REQUIRE: {
                if (data != null) {
                    long category = data.getLong("category", -1);
                    //start register task
                    if (category == AIOpenConstant.SEMANTIC_LIVE) {//only for karaoke
                        Log.d(TAG, "register require, " + category);
                        AIOpenUtils.registerLiveTvApp(context);
                    }
                }
            }
            break;

        }
    }
}
