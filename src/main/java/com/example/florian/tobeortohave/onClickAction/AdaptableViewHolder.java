package com.example.florian.tobeortohave.onClickAction;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class AdaptableViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;

    public AdaptableViewHolder(CardView itemView) {
        super(itemView);
        cardView = itemView;

    }

    public CardView getCardView() {
        return cardView;
    }



    public void bind (final OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(cardView);
            }
        });

    }
}
