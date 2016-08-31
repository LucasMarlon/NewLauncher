package com.example.treinamento_xiaomi.launcher.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

public class CustomGridLayoutManager extends GridLayoutManager {

    public CustomGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
