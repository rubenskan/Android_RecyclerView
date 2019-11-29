package com.example.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{

    private ImageView featureImage;
    private TextView titulo;
    private TextView desc;
    private AppCompatButton btnLink;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.featureImage = itemView.findViewById(R.id.featureImage);
        this.titulo = itemView.findViewById(R.id.titulo);
        this.desc = itemView.findViewById(R.id.desc);
        this.btnLink = itemView.findViewById(R.id.btnLink);
    }

    public ImageView getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(ImageView featureImage) {
        this.featureImage = featureImage;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public TextView getDesc() {
        return desc;
    }

    public void setDesc(TextView desc) {
        this.desc = desc;
    }

    public AppCompatButton getBtnLink() {
        return btnLink;
    }

    public void setBtnLink(AppCompatButton btnLink) {
        this.btnLink = btnLink;
    }
}
