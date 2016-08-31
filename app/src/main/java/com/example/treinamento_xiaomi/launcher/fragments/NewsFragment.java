package com.example.treinamento_xiaomi.launcher.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.treinamento_xiaomi.launcher.R;
import com.example.treinamento_xiaomi.launcher.adapter.NewsAdapter;
import com.example.treinamento_xiaomi.launcher.model.News;
import com.example.treinamento_xiaomi.launcher.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by treinamento-xiaomi on 30/08/2016.
 */
public class NewsFragment extends Fragment {

    private List<News> newsList;
    private NewsAdapter newsAdapter;

    public NewsFragment() {
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

        View view = inflater.inflate(R.layout.news_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_news);

        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(view.getContext(), newsList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newsAdapter);
        prepareNews();

        return view;
    }

    /**
     * Adding few albums for testing
     */
    private void prepareNews() {

        News a = new News("True Romance", R.drawable.album);
        newsList.add(a);

        a = new News("Xscpae", R.drawable.album);
        newsList.add(a);

        a = new News("Maroon 5", R.drawable.album);
        newsList.add(a);

        a = new News("Born to Die", R.drawable.album);
        newsList.add(a);

        a = new News("Honeymoon", R.drawable.album);
        newsList.add(a);

        a = new News("I Need a Doctor", R.drawable.album);
        newsList.add(a);

        a = new News("Loud", R.drawable.album);
        newsList.add(a);

        a = new News("Legend", R.drawable.album);
        newsList.add(a);

        a = new News("Hello", R.drawable.album);
        newsList.add(a);

        a = new News("Greatest Hits", R.drawable.album);
        newsList.add(a);

        newsAdapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}