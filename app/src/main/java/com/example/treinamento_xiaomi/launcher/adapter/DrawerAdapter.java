package com.example.treinamento_xiaomi.launcher.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.model.Pac;

import java.util.List;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private List<Pac>  pacsAdapter;
    private Context context;

    public DrawerAdapter(Context context, List<Pac> pacs) {
        this.pacsAdapter = pacs;
        this.context = context;
    }

    @Override
    public DrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DrawerAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.icon_text.setText(pacsAdapter.get(i).label);
        viewHolder.icon_image.setImageDrawable(pacsAdapter.get(i).icon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = new Intent(Intent.ACTION_MAIN);
                launchIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cp = new ComponentName(pacsAdapter.get(i).packageName, pacsAdapter.get(i).name);
                launchIntent.setComponent(cp);
                context.startActivity(launchIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pacsAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView icon_text;
        private ImageView icon_image;

        public ViewHolder(View view) {
            super(view);
            icon_text = (TextView)view.findViewById(R.id.icon_text);
            icon_image = (ImageView) view.findViewById(R.id.icon_image);
        }
    }

}
