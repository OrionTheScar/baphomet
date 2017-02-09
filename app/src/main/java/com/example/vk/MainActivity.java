package com.example.vk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//задача: получить access_token, который сохранили в next_activity и вывести его в log
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        String saved_text = sPref.getString("saved_text", "");
        Log.d(TAG, saved_text);
        //tvOut = (TextView) findViewById(R.id.tvOut);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
