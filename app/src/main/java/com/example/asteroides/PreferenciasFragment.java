package com.example.asteroides;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

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

        // Obtenemos la preferencia guardada.
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences( getActivity() );
        int c_fragments = Integer.parseInt( pref.getString("fragmentos", "9" ) );
        // Obetenemos la referencia del EditText de preferencias que contiene el valor de los fragmentos del asteroide.
        final EditTextPreference fragmentos = (EditTextPreference) findPreference("fragmentos");

        fragmentos.setSummary("En cuantos trozos se divide un asteroide ( " + c_fragments + " ) ");

        // asignamos un evento para cuando este cambie de valor
        fragmentos.setOnPreferenceChangeListener( new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                int valor;
                try {
                    // Intentamos convertir la nueva preferencia a entero.
                    Log.d("Preferences", "Entre al try");
                    valor = Integer.parseInt( (String) newValue );
                }
                // getActivity(). - Funcion de los fragments que devuelve la actividad en que se implemento el fragment.
                catch ( Exception e ) {
                    Toast.makeText(getActivity(), "Ha de ser un numero", Toast.LENGTH_SHORT).show();
                    // retornamos false para que el valor de la preferencia no sea modificado.
                    return false;
                }
                if( valor >= 0 && valor <= 9 ) {
                    // Modificamos la explicacion de la preferencia para que aparezca el nuevo valor entre parentesis.
                    fragmentos.setSummary("En cuantos trozos se divide un asteroide ( " + valor + " ) ");
                    // Retornamos true para que se acepte el nuevo valor de la preferencia.
                    return true;
                }
                else {
                    Toast.makeText(getActivity(), "Maximo de fragmentos 9", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });

    }
}
