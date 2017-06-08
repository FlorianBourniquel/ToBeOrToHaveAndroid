package com.example.florian.tobeortohave.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.florian.tobeortohave.adapter.NotifactionRecyclerAdapter;
import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.onClickAction.OnClickProduct;
import com.example.florian.tobeortohave.R;

import java.util.List;


public class MainNotification extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.sharedOnCreate();

        List<Product> products = Database.getInstance().getUser().getFollowedProductsWithNotification();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        recyclerView.getParent();
        NotifactionRecyclerAdapter notifactionRecyclerAdapter = new NotifactionRecyclerAdapter(products, new OnClickProduct());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 1);
        recyclerView.setAdapter(notifactionRecyclerAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
