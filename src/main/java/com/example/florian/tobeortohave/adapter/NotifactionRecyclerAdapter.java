package com.example.florian.tobeortohave.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.florian.tobeortohave.onClickAction.AdaptableViewHolder;
import com.example.florian.tobeortohave.onClickAction.OnItemClickListener;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.R;

import java.text.SimpleDateFormat;
import java.util.List;


public class NotifactionRecyclerAdapter extends RecyclerView.Adapter<AdaptableViewHolder> {


    private List<Product> products;
    private OnItemClickListener clickListener;


    public NotifactionRecyclerAdapter(List<Product> products, OnItemClickListener onItemClickListener) {
        this.products = products;
        this.clickListener = onItemClickListener;
    }

    @Override
    public AdaptableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.notification,parent,false);
        AdaptableViewHolder newsViewHolder = new AdaptableViewHolder(cardView);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptableViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.getCardView().findViewById(R.id.image);
        imageView.setImageResource(R.drawable.placeholder);
        Product product = products.get(position);
        holder.bind(clickListener);
        Context context = holder.getCardView().getContext();
        TextView text = (TextView) holder.getCardView().findViewById(R.id.notification_text_middle);
        text.setText(product.getName());
        TextView textView = (TextView) holder.getCardView().findViewById(R.id.titre);
        textView.setText(product.getName());
        TextView date = (TextView) holder.getCardView().findViewById(R.id.notification_date);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        date.setText(format.format(product.getDate()));
        new AsyncTaskImage(imageView).execute(product.getUrl());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
