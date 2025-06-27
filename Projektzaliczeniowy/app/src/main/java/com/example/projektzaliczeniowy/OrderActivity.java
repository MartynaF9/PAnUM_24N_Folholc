package com.example.projektzaliczeniowy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** Formularz potwierdzenia zamówienia: zapis do bazy i wysyłka e-mail. */
public class OrderActivity extends AppCompatActivity {

    private DBHelper db;
    private String productName;
    private double productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        db = new DBHelper(this);

        TextView tvName  = findViewById(R.id.tvProductName);
        TextView tvPrice = findViewById(R.id.tvProductPrice);
        EditText etQty   = findViewById(R.id.etQuantity);
        Button btnSave   = findViewById(R.id.btnSave);
        Button btnEmail  = findViewById(R.id.btnEmail);

        Intent in = getIntent();
        productName  = in.getStringExtra("name");
        productPrice = in.getDoubleExtra("price", 0.0);

        tvName.setText(productName);
        tvPrice.setText(String.format(Locale.getDefault(), "%.2f zł", productPrice));
        etQty.setText("1");

        btnSave.setOnClickListener(v -> {
            int q = Integer.parseInt(etQty.getText().toString());
            String time = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
                    .format(new Date());
            db.addOrder(new Order(productName, q, productPrice, time));
            Toast.makeText(this, "Zamówienie zapisane", Toast.LENGTH_SHORT).show();
        });

        btnEmail.setOnClickListener(v -> {
            int q = Integer.parseInt(etQty.getText().toString());
            String time = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
                    .format(new Date());
            String body = "Produkt: " + productName +
                    "\nIlość: " + q +
                    "\nCena: " + productPrice + " zł" +
                    "\nCzas zamówienia: " + time;

            /* >>> pobieramy adres z strings.xml <<< */
            String emailAddress = getString(R.string.order_email);

            Intent mail = new Intent(Intent.ACTION_SENDTO);
            mail.setData(Uri.parse("mailto:"));
            mail.putExtra(Intent.EXTRA_SUBJECT, "Zamówienie - Kawiarenka");
            mail.putExtra(Intent.EXTRA_TEXT, body);

            if (mail.resolveActivity(getPackageManager()) != null) startActivity(mail);
            else Toast.makeText(this, "Brak aplikacji e-mail.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (db != null) db.close();
    }
}

