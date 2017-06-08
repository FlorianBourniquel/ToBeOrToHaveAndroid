package com.example.florian.tobeortohave.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.florian.tobeortohave.adapter.CategorieRecyclerAdapter;
import com.example.florian.tobeortohave.model.Category;
import com.example.florian.tobeortohave.model.Database;
import com.example.florian.tobeortohave.onClickAction.OnClickCategory;
import com.example.florian.tobeortohave.R;

import java.util.List;

public class MainCategory extends SuperActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.sharedOnCreate();

        List<Category> categories = Database.getInstance().getCategories();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        recyclerView.getParent();
        CategorieRecyclerAdapter categorieRecyclerAdapter = new CategorieRecyclerAdapter(categories, new OnClickCategory());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 2);
        recyclerView.setAdapter(categorieRecyclerAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

}
