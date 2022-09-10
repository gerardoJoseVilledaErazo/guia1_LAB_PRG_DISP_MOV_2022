package com.example.guia01_multiplicacionrusa_palindrimo_aniobisiesto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.guia01_multiplicacionrusa_palindrimo_aniobisiesto.Validaciones.Validaciones;

import java.util.Locale;

public class PalindromoActivity extends AppCompatActivity {

    private EditText edtPalindromo;
    private Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindromo);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.edtPalindromo = findViewById(R.id.edtPalindromo);
        this.btnProcesar = findViewById(R.id.btnProcesar);


        btnProcesar.setOnClickListener(view -> {
            if (Validaciones.esEditTextVacio(edtPalindromo)){

                char[] cadena = edtPalindromo.getText().toString().toLowerCase(Locale.ROOT).toCharArray();

                if (esPalindrome(cadena)){
                    new AlertDialog.Builder(this).setTitle("Resultado").setMessage(edtPalindromo.getText().toString()+": Es Palindromo")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            }).show();
                } else {
                    new AlertDialog.Builder(this).setTitle("Resultado").setMessage(edtPalindromo.getText().toString()+": NO es Palindromo")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            }).show();
                }
            }
        });
    }

    private boolean esPalindrome(char[] cadena){
        int limiteInferior = 0;
        int limiteSuperior = cadena.length - 1; // Se resta 1 porque el limiteInferior arranca en 0
        boolean resultado = true;
        while (limiteInferior < limiteSuperior && resultado){
            if (cadena[limiteInferior] == cadena[limiteSuperior]){
                limiteInferior++;
                limiteSuperior--;
            } else {
                resultado=false;
            }
        }
        return resultado;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}