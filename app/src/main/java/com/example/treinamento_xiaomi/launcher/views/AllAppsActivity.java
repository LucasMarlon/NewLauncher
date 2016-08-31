package com.example.treinamento_xiaomi.launcher.views;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.adapter.DrawerAdapter;
import com.example.treinamento_xiaomi.launcher.model.Pac;

import java.util.ArrayList;
import java.util.List;

public class AllAppsActivity extends Activity {

    private PackageManager pm;
    private List<Pac> allAppsPacs;
    private DrawerAdapter drawerAdapterAllAppsObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_apps);
        pm = getPackageManager();
        loadAllApps();
    }

    public void loadAllApps(){
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacList = pm.queryIntentActivities(mainIntent, 0);
        allAppsPacs = new ArrayList<Pac>();
        for(ResolveInfo ri : pacList){
            Pac pac = new Pac();
            pac.icon = ri.activityInfo.loadIcon(pm);
            pac.label = ri.loadLabel(pm).toString();
            pac.packageName = ri.activityInfo.packageName;
            pac.name = ri.activityInfo.name;
            allAppsPacs.add(pac);
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view_all_apps);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),4);
        recyclerView.setLayoutManager(layoutManager);

        drawerAdapterAllAppsObject = new DrawerAdapter(this, allAppsPacs);
        recyclerView.setAdapter(drawerAdapterAllAppsObject);
        /*
        drawerGrid.setOnItemLongClickListener(new DrawerLongClickListener(this, slidingDrawer, homeView, pacs));
        } else {
            drawerAdapterObject.pacsForAdapter = pacs;
            drawerAdapterObject.notifyDataSetInvalidated();
        }*/
    }
}
