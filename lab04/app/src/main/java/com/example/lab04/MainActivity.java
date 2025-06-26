package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener listener = (AdapterView<?> list, View v, int position, long id) -> {
            Class<?> target;
            if (position == 0)       target = DrinkCategoryActivity.class;
            else if (position == 1)  target = SnackCategoryActivity.class;
            else                     target = CafeCategoryActivity.class;
            startActivity(new Intent(this, target));
        };

        ListView listOptions = findViewById(R.id.list_options);
        listOptions.setOnItemClickListener(listener);
    }
}
