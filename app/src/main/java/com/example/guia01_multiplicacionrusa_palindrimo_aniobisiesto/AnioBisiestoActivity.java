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

public class AnioBisiestoActivity extends AppCompatActivity {

    private EditText edtAnioBisiesto;
    private Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anio_bisiesto);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.edtAnioBisiesto = findViewById(R.id.edtAnioBisiesto);
        this.btnProcesar = findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(view -> {
            if (Validaciones.esEditTextVacio(edtAnioBisiesto)){

                int anio = Integer.parseInt(edtAnioBisiesto.getText().toString());

                if (esBisiesto(anio)){
                    new AlertDialog.Builder(this).setTitle("Resultado").setMessage(edtAnioBisiesto.getText().toString()+": Es Bisiesto")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            }).show();
                } else {
                    new AlertDialog.Builder(this).setTitle("Resultado").setMessage(edtAnioBisiesto.getText().toString()+": NO es Bisiesto")
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

    /**
     * Todos los anios divisibles por 400 SON bisiestos (1600, 2000, 2400),
     * Todos los anios divisibles por 100 pero no por 400 son NO bisiestos (1700, 1800, 1900),
     * Todos los anios divisibles por 4 pero no por 100 SON bisiestos (1996, 2004, 2008),
     * Todos los anios no divisibles por 4 son NO bisiestos (2017, 2018, 2019).
     */
    private boolean esBisiesto(int anio){
        boolean resultado = true;

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)){
            resultado = true;
        } else {
            resultado = false;
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