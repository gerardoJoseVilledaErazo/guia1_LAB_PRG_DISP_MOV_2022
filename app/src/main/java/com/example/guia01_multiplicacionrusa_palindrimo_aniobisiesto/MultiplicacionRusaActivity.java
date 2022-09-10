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

public class MultiplicacionRusaActivity extends AppCompatActivity {

    private EditText edtMultiplicador;
    private EditText edtMultiplicando;
    private Button btnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion_rusa);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.edtMultiplicador = findViewById(R.id.edtMultiplicador);
        this.edtMultiplicando = findViewById(R.id.edtMultiplicando);
        this.btnProcesar = findViewById(R.id.btnProcesar);


        btnProcesar.setOnClickListener(view -> {
            if (Validaciones.esEditTextVacio(edtMultiplicador) && Validaciones.esEditTextVacio(edtMultiplicando)){

                int multiplicador = Integer.parseInt(edtMultiplicador.getText().toString());
                int multiplicando = Integer.parseInt(edtMultiplicando.getText().toString());


                new AlertDialog.Builder(this).setTitle("Resultado").setMessage(String.valueOf(multiplicacionRusa(multiplicador, multiplicando)))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();
            }
        });
    }

    private int multiplicacionRusa(int multiplicador, int multiplicando){
        int resultado = 0;

        while(multiplicador > 0){

            if(multiplicador % 2 != 0){
                resultado += multiplicando;
            }

            multiplicador /= 2;
            multiplicando *= 2;
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