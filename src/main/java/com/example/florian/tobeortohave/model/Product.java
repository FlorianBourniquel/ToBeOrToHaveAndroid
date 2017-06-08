package com.example.florian.tobeortohave.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Florian on 30/04/2017.
 */

public class Product {
    private String image;
    private String name;
    private double price;
    private double discount;
    private int id;
    private boolean isDiscount;
    private boolean isNewNotification;
    private boolean isNotification;
    private Date date;
    private static int cpt = 0;
    private String description;
    private String lightDescription;

    public Product(String image, String name, double price, String description, String lightDescription) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.lightDescription = lightDescription;
        this.id = cpt++;
        this.discount = 0.0;
        this.isDiscount = false;
        this.isNewNotification = false;
    }

    public Product(String image, String name, double price, double discount, String description, String lightDescription) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.lightDescription = lightDescription;
        this.isDiscount = true;
        this.isNewNotification = false;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public static Comparator<Product> ProductNameComparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }

    };

    public static Comparator<Product> ProductNewNotificationComparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Boolean.compare(o1.isNewNotification(),o2.isNewNotification());
        }

    };

    public static Comparator<Product> ProductPriceComparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            double price1;
            double price2;
            if (o1.isDiscount)
                price1 = o1.getPriceWithDiscount();
            else
                price1 = o1.getPrice();
            if (o2.isDiscount)
                price2 = o2.getPriceWithDiscount();
            else
                price2 = o2.getPrice();

            return (int) (price1 - price2);
        }

    };

    public void setDiscount(double discount) {
        this.isDiscount = true;
        this.discount = discount;
    }

    public double getPriceWithDiscount () {
        return price - (price * discount);
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void removeDiscount() {
        this.discount = 0.0;
        this.isDiscount = false;
    }

    public boolean isNewNotification() {
        return isNewNotification;
    }

    public void setNewNotification(boolean newNotification) {
        isNewNotification = newNotification;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNotification(boolean notification) {
        isNotification = notification;
    }

    public boolean isNotification() {
        return isNotification;
    }

    public Date getDate() {
        return date;
    }

    public String getLightDescription() {
        return lightDescription;
    }
}
