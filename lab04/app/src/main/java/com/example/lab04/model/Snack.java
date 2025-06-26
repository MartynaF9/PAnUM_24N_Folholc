package com.example.lab04.model;

import com.example.lab04.R;

public class Snack {
    private final String name, description;
    private final int price;
    private final int imageResId;

    public static final Snack[] snacks = {
            new Snack("Croissant", "Maślany rogalik na ciepło.", 7, R.drawable.croissant),
            new Snack("Muffin czekoladowy", "Muffin z kawałkami czekolady.", 8, R.drawable.muffin),
            new Snack("Ciastko owsiane", "Ciasteczko z płatków owsianych i żurawiny.", 6, R.drawable.cookie)
    };

    private Snack(String n, String d, int p, int img) {
        name = n; description = d; price = p; imageResId = img;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getImageResId() { return imageResId; }

    @Override public String toString() { return name; }
}
