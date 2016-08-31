package com.example.treinamento_xiaomi.launcher.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.utils.Util;

/**
 * Created by treinamento-xiaomi on 29/08/2016.
 */
public class SecondPageFragment extends Fragment {

    private ImageView imgMiuiTheme;

    public SecondPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inf = inflater.inflate(R.layout.second_page_fragment, container, false);
        imgMiuiTheme = (ImageView) inf.findViewById(R.id.iv_miui_theme);
        imgMiuiTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Util.URI));
                intent.setPackage("com.android.browser");
                startActivity(intent);
            }
        });

        return inf;
    }
}
