package com.example.guia01_multiplicacionrusa_palindrimo_aniobisiesto.Validaciones;

import android.widget.EditText;

public class Validaciones {

    // Metodo para Validar si EditText se encuentra vacio
    public static boolean esEditTextVacio(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Campo requerido.");
            editText.requestFocus();
            return false;
        }
        return true;
    }
}
