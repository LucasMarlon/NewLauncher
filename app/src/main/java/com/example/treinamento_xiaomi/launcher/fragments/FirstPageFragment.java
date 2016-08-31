package com.example.treinamento_xiaomi.launcher.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.adapter.ViewPagerAdapter;


/**
 * Created by treinamento-xiaomi on 29/08/2016.
 */
public class FirstPageFragment extends Fragment {

    public FirstPageFragment() {
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

        View view = inflater.inflate(R.layout.first_page_fragment, container, false);

        ViewPager viewPagerTabs = (ViewPager) view.findViewById(R.id.vpTabs);
        setupViewPager(viewPagerTabs);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerTabs);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new NewsFragment(), "Notícias 1");
        adapter.addFragment(new NewsFragment(), "Notícias 2");
        adapter.addFragment(new NewsFragment(), "Notícias 3");

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

}
