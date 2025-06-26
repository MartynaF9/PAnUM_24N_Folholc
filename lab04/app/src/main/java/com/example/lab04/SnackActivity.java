package com.example.lab04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Snack;

public class SnackActivity extends AppCompatActivity {
    public static final String EXTRA_SNACKID = "snackId";

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_snack);

        Snack s = Snack.snacks[getIntent().getIntExtra(EXTRA_SNACKID,0)];

        ((ImageView)findViewById(R.id.photo)).setImageResource(s.getImageResId());
        ((TextView)findViewById(R.id.name)).setText(s.getName());
        ((TextView)findViewById(R.id.description)).setText(s.getDescription());
        ((TextView)findViewById(R.id.price)).setText("Cena: "+s.getPrice()+" zł");
    }
}
