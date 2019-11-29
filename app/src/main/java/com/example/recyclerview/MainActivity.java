package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Article> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PkRSS.with(this).load("http://www.androidpro.com.br/feed/").skipCache().callback(this).async();

        adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        list.clear();
        list.addAll(newArticles);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed() {

    }
}
