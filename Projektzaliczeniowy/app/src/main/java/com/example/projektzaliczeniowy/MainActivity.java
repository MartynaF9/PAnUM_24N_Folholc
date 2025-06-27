package com.example.projektzaliczeniowy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/** Ekran startowy – lista produktów (napoje / przekąski). */
public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;
    private final ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = findViewById(R.id.listViewProducts);

        // Dodaj przykładowe produkty
        productList.add(new Product("Cappuccino", "Espresso z mlekiem.", 10.0, R.drawable.cappuccino));
        productList.add(new Product("Latte", "Kawa z dużą ilością mleka.", 12.0, R.drawable.latte));
        productList.add(new Product("Herbata", "Herbata z cytryną.", 7.0, R.drawable.herbata));
        productList.add(new Product("Croissant", "Rogal maślany.", 5.0, R.drawable.croissant));
        productList.add(new Product("Muffin", "Babeczka czekoladowa.", 6.0, R.drawable.muffin));
        productList.add(new Product("Ciastko owsiane", "Chrupiące ciastko.", 4.0, R.drawable.ciastko));

        ProductAdapter adapter = new ProductAdapter(this, productList);
        listViewProducts.setAdapter(adapter);

        // Przejście do szczegółów po kliknięciu pozycji
        listViewProducts.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Product p = productList.get(position);
            Intent i = new Intent(MainActivity.this, ProductDetailActivity.class);
            i.putExtra("name", p.getName());
            i.putExtra("description", p.getDescription());
            i.putExtra("price", p.getPrice());
            i.putExtra("image", p.getImageResId());
            startActivity(i);
        });
    }

    /** Własny adapter, aby pokazać obraz + dwa teksty w wierszu ListView. */
    private static class ProductAdapter extends ArrayAdapter<Product> {
        ProductAdapter(Context ctx, ArrayList<Product> list) { super(ctx, 0, list); }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.list_item_product, parent, false);

            Product prod = getItem(position);
            if (prod != null) {
                ((ImageView) convertView.findViewById(R.id.imgProduct))
                        .setImageResource(prod.getImageResId());
                ((TextView) convertView.findViewById(R.id.tvName))
                        .setText(prod.getName());
                ((TextView) convertView.findViewById(R.id.tvDesc))
                        .setText(prod.getDescription());
            }
            return convertView;
        }
    }
}
