package com.example.florian.tobeortohave.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.florian.tobeortohave.model.Category;
import com.example.florian.tobeortohave.onClickAction.AdaptableViewHolder;
import com.example.florian.tobeortohave.onClickAction.OnItemClickListener;
import com.example.florian.tobeortohave.R;

import java.util.List;


public class CategorieRecyclerAdapter extends RecyclerView.Adapter<AdaptableViewHolder> {


    private List<Category> categories;
    private OnItemClickListener clickListener;


    public CategorieRecyclerAdapter(List<Category> categories, OnItemClickListener onItemClickListener) {
        this.categories = categories;
        this.clickListener = onItemClickListener;
    }

    @Override
    public AdaptableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.category,parent,false);
        AdaptableViewHolder newsViewHolder = new AdaptableViewHolder(cardView);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptableViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.getCardView().findViewById(R.id.image);
        imageView.setImageResource(R.drawable.placeholder);
        Category category = categories.get(position);
        holder.bind(clickListener);
        TextView text = (TextView) holder.getCardView().findViewById(R.id.titre);
        text.setText(category.getName());
        new AsyncTaskImage(imageView).execute(category.getUrl());


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

}
