package com.example.vk;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

 WebView mWebView;
    private static final String TAG = "Токен";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Log.d(TAG, "Токен");
        VkWebViewClient vkWebViewClient = new VkWebViewClient();
            vkWebViewClient.myActivity = this;
        mWebView = (WebView)findViewById(R.id.webView2);
        mWebView.setWebViewClient(vkWebViewClient);
        mWebView.loadUrl("https://oauth.vk.com/authorize?client_id=5623657&display=mobile&redirect_uri=https://vk.com/friends&scope=friends&response_type=token&v=5.53&state=123456");
    }
}
class VkWebViewClient extends WebViewClient {
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    private static final String TAG = "Токен";
    public Activity myActivity;
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        boolean newBoolean = url.contains("blank.html");
        if (newBoolean) {
            url = url.replace("#", "?");
            Uri uri = Uri.parse(url);
            String access_token = uri.getQueryParameter("access_token");
            Log.d(TAG, access_token);
            sPref = myActivity.getPreferences(Activity.MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString("saved_text", access_token);
            ed.apply();

        }
        }
    }
