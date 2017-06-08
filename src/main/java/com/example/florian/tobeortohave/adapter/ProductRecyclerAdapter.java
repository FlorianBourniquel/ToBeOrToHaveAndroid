package com.example.florian.tobeortohave.adapter;

import android.graphics.Paint;
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

import java.text.DecimalFormat;
import java.util.List;


public class ProductRecyclerAdapter extends RecyclerView.Adapter<AdaptableViewHolder> {


    private List<Product> products;
    private OnItemClickListener clickListener;


    public ProductRecyclerAdapter(List<Product> products, OnItemClickListener onItemClickListener) {
        this.products = products;
        this.clickListener = onItemClickListener;
    }

    @Override
    public AdaptableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false);
        AdaptableViewHolder newsViewHolder = new AdaptableViewHolder(cardView);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptableViewHolder holder, int position) {
        DecimalFormat df = new DecimalFormat("#.00");
        ImageView imageView = (ImageView) holder.getCardView().findViewById(R.id.image);
        imageView.setImageResource(R.drawable.placeholder);
        Product product = products.get(position);
        holder.bind(clickListener);
        TextView text = (TextView) holder.getCardView().findViewById(R.id.titre);
        text.setText(product.getName());
        TextView price = (TextView) holder.getCardView().findViewById(R.id.price);
        price.setText("Prix: " + df.format(product.getPrice()) + " €");
        TextView priceWithDiscount = (TextView) holder.getCardView().findViewById(R.id.price_with_discount);
        if (product.isDiscount()) {
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            priceWithDiscount.setText("Prix: " + df.format(product.getPriceWithDiscount()) + " €");
        }
        else {
            price.setPaintFlags(price.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            priceWithDiscount.setText("");
        }
        new AsyncTaskImage(imageView).execute(product.getUrl());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
