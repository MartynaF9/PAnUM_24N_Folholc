package com.example.projektzaliczeniowy;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/** Wyświetla szczegóły wybranego produktu i umożliwia przejście do zamówienia. */
public class ProductDetailActivity extends AppCompatActivity {

    private String productName;
    private double productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView img = findViewById(R.id.imgProductDetail);
        TextView tvName = findViewById(R.id.tvNameDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);
        TextView tvPrice = findViewById(R.id.tvPriceDetail);
        Button btnOrder = findViewById(R.id.btnOrder);

        Intent in = getIntent();
        productName = in.getStringExtra("name");
        String desc = in.getStringExtra("description");
        productPrice = in.getDoubleExtra("price", 0.0);
        int imgRes = in.getIntExtra("image", 0);

        img.setImageResource(imgRes);
        tvName.setText(productName);
        tvDesc.setText(desc);
        tvPrice.setText(String.format("Cena: %.2f zł", productPrice));

        btnOrder.setOnClickListener(v -> {
            Intent o = new Intent(this, OrderActivity.class);
            o.putExtra("name", productName);
            o.putExtra("price", productPrice);
            startActivity(o);
        });
    }
}

