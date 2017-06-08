package com.example.florian.tobeortohave.onClickAction;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.R;

public class OnClickButtonProductSheetRemove implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        ImageButton button = (ImageButton) v.findViewById(R.id.button_product_sheet);
        button.setOnClickListener(new OnClickButtonProductSheetAdd());
        View view = (View) v.getParent();
        TextView textView = (TextView) view.findViewById(R.id.title_product_sheet);
        Product product = Database.getInstance().getProductsByName(String.valueOf(textView.getText()));
        Database.getInstance().getUser().removeFollowedProduct(product);
        button.setImageResource(R.drawable.btn_rating_star_off_normal_holo_dark);

    }
}
