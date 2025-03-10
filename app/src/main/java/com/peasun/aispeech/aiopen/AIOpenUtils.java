package com.peasun.aispeech.aiopen;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class AIOpenUtils {

    public static void registerLiveTvApp(Context context) {
        Intent localIntent = new Intent();
        localIntent.setAction(AIOpenConstant.AI_OPEN_ACTION_APP_REGISTER);
        Bundle data = new Bundle();
        data.putString("package_name", context.getPackageName());
        data.putLong("category", AIOpenConstant.SEMANTIC_LIVE);
        localIntent.putExtras(data);

        /**
         * 注意对接的语音版本，将setPackage的参数改为对应语音软件的package name.
         * 国际版"com.peasun.aispeechgl"
         * 大陆版"com.peasun.aispeech"
         */
        localIntent.setPackage("com.peasun.aispeech");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(localIntent);
        } else {
            context.startService(localIntent);
        }
    }

    public static AIOpenReceiver registerLiveTvReciver(Context context) {
        AIOpenReceiver receiver = new AIOpenReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(AIOpenConstant.AI_OPEN_ACTION_LIVE);
        //context.registerReceiver(receiver, filter, AIOpenConstant.AI_OPEN_ACTION_PERMISSION, null);
        context.registerReceiver(receiver, filter);
        return receiver;
    }
}
