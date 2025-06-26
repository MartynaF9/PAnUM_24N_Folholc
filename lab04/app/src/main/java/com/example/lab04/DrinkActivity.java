package com.example.lab04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Drink;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID = "drinkId";

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_drink);

        Drink d = Drink.drinks[getIntent().getIntExtra(EXTRA_DRINKID,0)];

        ((ImageView)findViewById(R.id.photo)).setImageResource(d.getImageResId());
        ((TextView)findViewById(R.id.name)).setText(d.getName());
        ((TextView)findViewById(R.id.description)).setText(d.getDescription());
        ((TextView)findViewById(R.id.price)).setText("Cena: "+d.getPrice()+" zł");
    }
}
