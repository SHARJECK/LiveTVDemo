package com.sharjeck.livetvdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.peasun.aispeech.aiopen.AIOpenReceiver;
import com.peasun.aispeech.aiopen.AIOpenService;
import com.peasun.aispeech.aiopen.AIOpenUtils;

public class MainActivity extends Activity {
    AIOpenReceiver aiOpenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         * register scene app
         */
        AIOpenUtils.registerLiveTvApp(this);

        Log.d("MainActivity", "register broadcast");
        aiOpenReceiver = AIOpenUtils.registerLiveTvReciver(this);

        Intent intent = new Intent(this, AIOpenService.class);
        startService(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(aiOpenReceiver);
    }
}
