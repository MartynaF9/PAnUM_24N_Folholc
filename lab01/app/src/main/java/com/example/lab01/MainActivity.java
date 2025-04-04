package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_number;
    Button b_convert;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        b_convert = findViewById(R.id.b_convert);
        tv_result = findViewById(R.id.tv_result);

        b_convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               int dec = Integer.parseInt(et_number.getText().toString());
               String bin = Integer.toBinaryString(dec);
               String oct = Integer.toOctalString(dec);
               String hex = Integer.toHexString(dec);
               tv_result.setText("DEC: " + dec + "\n\n" +
                       "BIN: " + bin + "\n\n" +
                       "OCT: " + oct + "\n\n" +
                       "HEX: " + hex);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}