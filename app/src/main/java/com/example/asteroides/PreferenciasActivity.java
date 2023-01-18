package com.example.asteroides;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class PreferenciasActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        /**
         * getFragmentManager(). - Obtenemos el manejador de fragments de la actividad
         * beginTransaction(). - Comenzamos la transaccion. Una transacción es una operación de insertado, borrado, o reemplazo de fragments
         * En este caso vamos a hacer un reemplazo del contenido de la actividad por un nuevo fragment de la clase PreferenciasFragment
         * .commit(). - Ejecuta la transacción.
         * */

        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace( android.R.id.content, new PreferenciasFragment())
                .commit();
    }
}
