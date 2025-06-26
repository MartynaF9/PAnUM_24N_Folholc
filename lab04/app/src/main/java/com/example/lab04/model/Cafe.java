package com.example.lab04.model;

import com.example.lab04.R;

public class Cafe {
    private final String name;
    private final String address;
    private final String hours;
    private final int imageResId;             // <-- NOWE POLE

    public static final Cafe[] cafes = {
            new Cafe("Częstochowa I",
                    "ul. Długa 5, Częstochowa",
                    "8:00–20:00",
                    R.drawable.czestochowa1),

            new Cafe("Częstochowa II",
                    "ul. Krótka 10, Częstochowa",
                    "9:00–18:00",
                    R.drawable.czestochowa2),

            new Cafe("Warszawa",
                    "ul. Marszałkowska 1, Warszawa",
                    "7:00–22:00",
                    R.drawable.warszawa)
    };

    private Cafe(String n, String a, String h, int img) {
        name = n; address = a; hours = h; imageResId = img;
    }

    /* gettery */
    public String getName()  { return name; }
    public String getAddress(){ return address; }
    public String getHours() { return hours; }
    public int    getImageResId() { return imageResId; }

    @Override public String toString() { return name; }
}
