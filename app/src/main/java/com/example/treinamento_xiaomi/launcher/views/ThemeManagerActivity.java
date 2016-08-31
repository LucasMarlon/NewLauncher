package com.example.treinamento_xiaomi.launcher.views;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.treinamento_xiaomi.launcher.utils.Util;

public class ThemeManagerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Util.URI));
        intent.setPackage("com.android.browser");
        startActivity(intent);
        finish();
    }
}
