package com.example.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pkmmte.pkrss.Article;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Article> list;

    public RecyclerAdapter(List<Article> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
       final Article article = list.get(position);

       holder.getTitulo().setText(article.getTitle());
       holder.getDesc().setText(article.getAuthor());
       new DownloadImageTask(holder.getFeatureImage()).execute(article.getEnclosure().getUrl());
       holder.getBtnLink().setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_VIEW, article.getSource());
               holder.itemView.getContext().startActivity(intent);
           }
       } );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
