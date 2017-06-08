package com.example.florian.tobeortohave.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.florian.tobeortohave.adapter.ProductRecyclerAdapter;
import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.model.Product;
import com.example.florian.tobeortohave.onClickAction.OnClickProduct;
import com.example.florian.tobeortohave.R;

import java.util.List;


public class MainProduct extends SuperActivity {

    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.sharedOnCreate();
        Bundle b = getIntent().getExtras();
        if(b != null) {
            value = b.getString("key");
            List<Product> products;
            if (value.equals("Mes Favoris"))
                 products = Database.getInstance().getUser().getFollowedProducts();
            else
                products = Database.getInstance().getProductsByCategoriesNameSortByName(value);
            onCreateSort(products);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort_by_name) {
            List<Product> products;
            if (value.equals("Mes Favoris"))
                products = Database.getInstance().getUser().getFollowedProductsSortByName();
            else
                products = Database.getInstance().getProductsByCategoriesNameSortByName(value);
            onCreateSort(products);
            return true;
        }
        if (id == R.id.action_sort_by_price) {
            List<Product> products;
            if (value.equals("Mes Favoris"))
                products = Database.getInstance().getUser().getFollowedProductsSortByPrice();
            else
                products = Database.getInstance().getProductsByCategoriesNameSortByPrice(value);
            onCreateSort(products);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onCreateSort(List<Product> products) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        recyclerView.getParent();
        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(products, new OnClickProduct());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 2);
        recyclerView.setAdapter(productRecyclerAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
}
