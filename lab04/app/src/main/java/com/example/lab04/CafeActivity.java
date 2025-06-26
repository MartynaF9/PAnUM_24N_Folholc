package com.example.lab04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab04.model.Cafe;

public class CafeActivity extends AppCompatActivity {
    public static final String EXTRA_CAFEID = "cafeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        Cafe c = Cafe.cafes[getIntent().getIntExtra(EXTRA_CAFEID,0)];

        ((ImageView)findViewById(R.id.photo)).setImageResource(c.getImageResId());
        ((TextView)findViewById(R.id.name)).setText(c.getName());
        ((TextView)findViewById(R.id.address)).setText("Adres: "+c.getAddress());
        ((TextView)findViewById(R.id.hours)).setText("Godziny otwarcia: "+c.getHours());
    }
}
