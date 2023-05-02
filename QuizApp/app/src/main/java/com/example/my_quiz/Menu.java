package com.example.my_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    Button bStart;
    Button lcation;
    Button blogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bStart = findViewById(R.id.bLogin);
        lcation = findViewById(R.id.Location);
        blogout = findViewById(R.id.bLogout);
        bStart.setOnClickListener(view ->{
            startActivity(new Intent(Menu.this, QuizActivity.class));
        });
        lcation.setOnClickListener(view ->{
            startActivity(new Intent(Menu.this, MapsActivity.class));
        });
        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Merci de votre Participation !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}