package com.example.florian.tobeortohave.onClickAction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.example.florian.tobeortohave.activity.MainProduct;
import com.example.florian.tobeortohave.R;

/**
 * Created by Florian on 30/04/2017.
 */

public class OnClickCategory implements  OnItemClickListener {
    @Override
    public void onItemClick(CardView cardView) {

        Intent intent = new Intent(cardView.getContext(), MainProduct.class);
        Bundle b = new Bundle();
        TextView text = (TextView) cardView.findViewById(R.id.titre);
        b.putString("key", text.getText().toString());
        intent.putExtras(b);
        cardView.getContext().startActivity(intent);
    }
}
