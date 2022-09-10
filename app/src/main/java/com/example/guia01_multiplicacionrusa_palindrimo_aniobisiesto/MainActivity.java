package com.example.guia01_multiplicacionrusa_palindrimo_aniobisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.

        Button btnAnioBisiesto = findViewById(R.id.btnAnioBisiesto);
        btnAnioBisiesto.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), AnioBisiestoActivity.class);
            startActivity(intent);
        });

        Button btnMultiplicacionRusa = findViewById(R.id.btnMultiplicacionRusa);
        btnMultiplicacionRusa.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),MultiplicacionRusaActivity.class);
            startActivity(intent);
        });

        Button btnPalindromo = findViewById(R.id.btnPalindromo);
        btnPalindromo.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),PalindromoActivity.class);
            startActivity(intent);
        });
    }
}