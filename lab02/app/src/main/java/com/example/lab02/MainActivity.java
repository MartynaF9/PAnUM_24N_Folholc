package com.example.lab02;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;  // sekundach
    private int tenths = 0;  // dziesiąte części sekundy
    private boolean running;  // czy jest on aktywny, uruchomiony
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            tenths = savedInstanceState.getInt("tenths");
            running = savedInstanceState.getBoolean("running");
        }
        runtimer();

    }

    public void onClickStart(View view) {
        running = true;


    }



    public void onClickReset(View view) {
        running = false;
        seconds = 0;
        tenths = 0;
    }

    public void onClickStop(View view) {
        running = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    private void runtimer() {
        final TextView timeView = findViewById(R.id.Screen);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.US, "%d:%02d:%02d.%d", hours, minutes, secs,
                        tenths);
                timeView.setText(time);
                if (running) {
                    ++tenths;
                    if (tenths == 10) {
                        seconds++;
                        tenths = 0;
                    }
                }
                handler.postDelayed(this, 100);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putInt("tenths", tenths);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }
    }

