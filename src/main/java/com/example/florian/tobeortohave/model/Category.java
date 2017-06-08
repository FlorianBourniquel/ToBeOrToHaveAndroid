package com.example.florian.tobeortohave.model;

import java.util.List;



public class Category {
    private List<Product> products;
    private String image;
    private String name;
    private int id;
    private static int cpt = 0;

    public Category(List<Product> products, String image, String name) {
        this.products = products;
        this.image = image;
        this.name = name;
        this.id = cpt++;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }
}
