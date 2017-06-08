package com.example.florian.tobeortohave.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.florian.tobeortohave.adapter.AsyncTaskImage;
import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.onClickAction.OnClickButtonProductSheetAdd;
import com.example.florian.tobeortohave.onClickAction.OnClickButtonProductSheetRemove;
import com.example.florian.tobeortohave.R;

import java.text.DecimalFormat;

public class MainProductSheet extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sheet);
        super.sharedOnCreate();
        Bundle b = getIntent().getExtras();
        if(b != null) {
            DecimalFormat df = new DecimalFormat("#.00");
            String productName = b.getString("key");
            Product product = Database.getInstance().getProductsByName(productName);
            removeNotification(product);
            ImageView imageView = (ImageView) findViewById(R.id.image_product_sheet);
            imageView.setImageResource(R.drawable.placeholder);
            TextView text = (TextView) findViewById(R.id.title_product_sheet);
            text.setText(product.getName());
            TextView price = (TextView) findViewById(R.id.price_product_sheet);
            price.setText("Prix: " + df.format(product.getPrice()) + " €");
            TextView priceWithDiscount = (TextView) findViewById(R.id.price_with_discount);
            if (product.isDiscount()) {
                price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                priceWithDiscount.setText("Prix avec promotion: " + df.format(product.getPriceWithDiscount()) + " €");
            }
            else {
                price.setPaintFlags(price.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                priceWithDiscount.setText("");
            }
            ImageButton button = (ImageButton) findViewById(R.id.button_product_sheet);
            if (Database.getInstance().getUser().getFollowedProducts().contains(product)) {
                button.setImageResource(R.drawable.btn_rating_star_on_normal_holo_dark);
                button.setOnClickListener(new OnClickButtonProductSheetRemove());
            }
            else {
                button.setImageResource(R.drawable.btn_rating_star_off_normal_holo_dark);
                button.setOnClickListener(new OnClickButtonProductSheetAdd());
            }
            TextView description = (TextView) findViewById(R.id.description_product_sheet);
            description.setText(product.getDescription());
            TextView lightDescription = (TextView) findViewById(R.id.light_description_product_sheet);
            lightDescription.setText(product.getLightDescription());
            new AsyncTaskImage(imageView).execute(product.getUrl());
        }
    }

    private void removeNotification (Product product) {
        if (product.isNewNotification()) {
            product.setNewNotification(false);
        }
    }
}
