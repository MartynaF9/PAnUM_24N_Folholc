package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Drink;

public class DrinkCategoryActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Drink.drinks);
        ListView list = findViewById(R.id.list_drinks);
        list.setAdapter(adapter);

        list.setOnItemClickListener((av,v,pos,id)->{
            Intent i = new Intent(this, DrinkActivity.class);
            i.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
            startActivity(i);
        });
    }
}
