package com.example.asteroides;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

/** class PreferenciasFragment.
 * Permite crear un fragment que contiene una ventana con las opciones de preferencias definidas en un recurso XML
 * Un fragment es un elemento que puede ser incrustado dentro de una actividad
 * */

public class PreferenciasFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource( R.xml.preferencias );
    }
}
