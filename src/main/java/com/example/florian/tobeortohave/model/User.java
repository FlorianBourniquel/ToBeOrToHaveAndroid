package com.example.florian.tobeortohave.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class User {
    private List<Product> followedProducts = new LinkedList<>();

    public List<Product> getFollowedProducts() {
        return followedProducts;
    }

    public List<Product> getFollowedProductsSortByName() {
        List<Product> products = followedProducts;
        Collections.sort(products, Product.ProductNameComparator);
        return products;
    }

    public List<Product> getFollowedProductsSortByPrice() {
        List<Product> products = followedProducts;
        Collections.sort(products, Product.ProductPriceComparator);
        return products;
    }

    public List<Product> getFollowedProductsWithNotification() {
        List<Product> products = new LinkedList<>();
        for (Product product: followedProducts) {
            if (product.isNotification()) {
                products.add(product);
            }
        }
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int res = Boolean.compare(o2.isNewNotification(),o1.isNewNotification());
                return res;
            }
        });
        return products;
    }
    
    public void addFollowedProduct (Product product) {
        followedProducts.add(product);
    }

    public void removeFollowedProduct (Product product) {
        followedProducts.remove(product);
    }

}

