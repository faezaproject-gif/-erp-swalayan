package com.erp.swalayan;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.pm.PackageManager;
import android.view.Window;

public class MainActivity extends Activity {
  private WebView web;
  @Override public void onCreate(Bundle b){ super.onCreate(b); requestWindowFeature(Window.FEATURE_NO_TITLE);
    if(android.os.Build.VERSION.SDK_INT>=23 && checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED) requestPermissions(new String[]{Manifest.permission.CAMERA},10);
    web=new WebView(this); web.setWebViewClient(new WebViewClient()); web.setWebChromeClient(new WebChromeClient()); web.getSettings().setJavaScriptEnabled(true); web.getSettings().setDomStorageEnabled(true); web.getSettings().setMediaPlaybackRequiresUserGesture(false); web.getSettings().setAllowFileAccess(true); setContentView(web); web.loadUrl("file:///android_asset/index.html"); }
  @Override public void onBackPressed(){ if(web.canGoBack()) web.goBack(); else super.onBackPressed(); }
}
