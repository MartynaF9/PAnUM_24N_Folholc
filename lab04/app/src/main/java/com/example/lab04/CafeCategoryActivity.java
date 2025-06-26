package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Cafe;

public class CafeCategoryActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_cafe_category);

        ArrayAdapter<Cafe> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Cafe.cafes);
        ListView list = findViewById(R.id.list_cafes);
        list.setAdapter(adapter);

        list.setOnItemClickListener((av,v,pos,id)->{
            Intent i = new Intent(this, CafeActivity.class);
            i.putExtra(CafeActivity.EXTRA_CAFEID, (int) id);
            startActivity(i);
        });
    }
}
