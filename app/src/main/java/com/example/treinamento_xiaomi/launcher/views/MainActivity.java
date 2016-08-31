package com.example.treinamento_xiaomi.launcher.views;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.adapter.DrawerAdapter;
import com.example.treinamento_xiaomi.launcher.fragments.FirstPageFragment;
import com.example.treinamento_xiaomi.launcher.fragments.SecondPageFragment;
import com.example.treinamento_xiaomi.launcher.fragments.ThirdPageFragment;
import com.example.treinamento_xiaomi.launcher.adapter.ViewPagerAdapter;
import com.example.treinamento_xiaomi.launcher.model.Pac;
import com.example.treinamento_xiaomi.launcher.utils.CustomGridLayoutManager;
import com.example.treinamento_xiaomi.launcher.utils.PrefManager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity {

    private PrefManager prefManager;
    private PackageManager pm;
    private List<Pac> homePacs;
    private DrawerAdapter drawerAdapterObject;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
        }
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        setupViewPager(viewPager);
        pm = getPackageManager();
        setPacHome();

    }

    @Override
    public void onBackPressed() {

    }

    public void setPacHome(){
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacList = pm.queryIntentActivities(mainIntent, 0);
        homePacs = new ArrayList<Pac>();
        for(ResolveInfo ri : pacList){
            String label = ri.activityInfo.packageName;
            if(label.equals("com.android.browser") || label.equals("com.android.contacts") ||
                    label.equals("com.android.mms") || label.equals("com.android.dialer")){
                Pac pac = new Pac();
                pac.icon = ri.activityInfo.loadIcon(pm);
                pac.label = ri.loadLabel(pm).toString();
                pac.packageName = ri.activityInfo.packageName;
                pac.name = ri.activityInfo.name;
                homePacs.add(pac);
            }
        }

        Pac pac = new Pac();
        pac.icon = ResourcesCompat.getDrawable(getResources(), R.drawable.all_apps, null);
        pac.label = "Apps";
        pac.packageName = "com.example.treinamento_xiaomi.launcher";
        pac.name = "com.example.treinamento_xiaomi.launcher.views.AllAppsActivity";

        homePacs.add(2,pac);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        CustomGridLayoutManager layoutManager =
                new CustomGridLayoutManager(getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);

        drawerAdapterObject = new DrawerAdapter(this, homePacs);
        recyclerView.setAdapter(drawerAdapterObject);

    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(MainActivity.this, ThemeManagerActivity.class));
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstPageFragment());
        adapter.addFragment(new SecondPageFragment());
        adapter.addFragment(new ThirdPageFragment());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        indicator.setViewPager(viewPager);
    }
}
