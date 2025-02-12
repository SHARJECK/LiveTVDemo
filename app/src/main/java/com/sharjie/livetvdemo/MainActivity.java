package com.sharjie.livetvdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.peasun.aispeech.aiopen.AIOpenService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AIOpenService.class);
        startService(intent);
    }
}
