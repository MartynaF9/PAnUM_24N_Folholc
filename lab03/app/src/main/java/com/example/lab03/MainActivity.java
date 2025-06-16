package com.example.lab03;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue, outputValue;
    private Spinner conversionSpinner;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        outputValue = findViewById(R.id.outputValue);
        conversionSpinner = findViewById(R.id.conversionSpinner);
        convertButton = findViewById(R.id.convertButton);

        // Definicja opcji konwersji
        final String[] options = {
                "Złotówki na Euro",
                "Centymetry na Cale",
                "Stopnie Celsjusza na Fahrenheita",
                "Kilometry na Mile"
        };

        // Adapter dla Spinnera
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);

adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         conversionSpinner.setAdapter(adapter);

         convertButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String inputStr = inputValue.getText().toString().trim();
                 if (inputStr.isEmpty()) {
                     Toast.makeText(MainActivity.this, "Wpisz wartość do konwersji", Toast.LENGTH_SHORT).show();
                     return;
                 }

                 double inputNumber;
                 try {
                     inputNumber = Double.parseDouble(inputStr);
                 } catch (NumberFormatException e) {
                     Toast.makeText(MainActivity.this, "Nieprawidłowa liczba", Toast.LENGTH_SHORT).show();
                     return;
                 }

                 int selectedPosition =
conversionSpinner.getSelectedItemPosition();
                 double result = 0;

                 switch (selectedPosition) {
                     case 0: // Złotówki na Euro (przykładowy kurs 1 EUR = 4.5 PLN)

                         result = inputNumber / 4.5;
                         break;
                     case 1: // Centymetry na Cale ( 1 cal = 2.54 cm)
                         result = inputNumber / 2.54;
                         break;
                     case 2: // Stopnie Celsjusza na Fahrenheita (F = C * 9/5 + 32)
                         result = inputNumber * 9 / 5 + 32;
                         break;
                     case 3: // Kilometry na Mile (1 mila = 1.60934 km)
                         result = inputNumber / 1.60934;
                         break;
                     default:
                         Toast.makeText(MainActivity.this, "Nieznany typ konwersji", Toast.LENGTH_SHORT).show();
                         return;

                 }

                 outputValue.setText(String.format("%.4f", result));

             }
         });
    }
}