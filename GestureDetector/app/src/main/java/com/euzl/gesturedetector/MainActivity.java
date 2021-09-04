package com.euzl.gesturedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toastButton = findViewById(R.id.toast_button);
        Button textButton = findViewById(R.id.textview_button);

        toastButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ToastActivity.class)));
    }
}