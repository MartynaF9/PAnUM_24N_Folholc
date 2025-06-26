package com.example.lab04.model;

import com.example.lab04.R;

public class Drink {
    private final String name, description;
    private final int price;
    private final int imageResId;

    public static final Drink[] drinks = {
            new Drink("Latte", "Espresso z gorącym mlekiem i pianką.", 14, R.drawable.latte),
            new Drink("Cappuccino", "Espresso z dużą ilością spienionego mleka.", 13, R.drawable.cappuccino),
            new Drink("Filter", "Klasyczna czarna kawa parzona przelewowo.", 10, R.drawable.filter)
    };

    private Drink(String n, String d, int p, int img) {
        name = n; description = d; price = p; imageResId = img;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getImageResId() { return imageResId; }

    @Override public String toString() { return name; }
}
