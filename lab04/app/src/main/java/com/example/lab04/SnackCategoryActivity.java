package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Snack;

public class SnackCategoryActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_snack_category);

        ArrayAdapter<Snack> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Snack.snacks);
        ListView list = findViewById(R.id.list_snacks);
        list.setAdapter(adapter);

        list.setOnItemClickListener((av,v,pos,id)->{
            Intent i = new Intent(this, SnackActivity.class);
            i.putExtra(SnackActivity.EXTRA_SNACKID, (int) id);
            startActivity(i);
        });
    }
}
