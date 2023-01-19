package com.example.asteroides;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );

        // Accediendo a los valores de los recursos de la app en la carpeta Res.
        Resources res = getResources();

        Drawable drawable = res.getDrawable(android.R.drawable.alert_dark_frame);
        String titulo     = res.getString( R.string.Asteroides );
        int color         = res.getColor( R.color.black );
        float fontSize    = res.getDimension( R.dimen.tamaño_fuente );
        boolean limit     = res.getBoolean( R.bool.limite );
        String[] dias     = res.getStringArray( R.array.dias_semana );
    }

    public void lanzarAcercaDe( View view ) {
        Intent i = new Intent( this, AcercaDe.class );
        startActivity( i );
    }

    public void lanzarPreferencias( View view ) {
        Intent i = new Intent( this, PreferenciasActivity.class );
        startActivity( i );
    }

    public void salirApp( View view ) {
        finish(); // Metodo para cerrar la app, es equivalente al metodo de retorno.
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        int id = item.getItemId();

        if ( id == R.id.action_settings ) {
            lanzarPreferencias( null );
            return true;
        }
        if ( id == R.id.acercaDe ) {
            lanzarAcercaDe( null );
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    public void mostrarPreferencias( View view ) {
        /**
         * El código comienza creando el objeto pref de la clase SharedPreferences y le asigna las preferencias definidas para la apliación. para ello le mandamos el objeto context.
         * Se utilizan los metodos getBoolean y getString()
         * Ambos reciben 2 parametros. El valor de key que queremos buscar y el valor asignado por defecto en caso de no encontrar esa key.
         *
         * getString( key, defaultValue )
         * */

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences( this );
        String s = "musica: " + pref.getBoolean("musica", true ) + ", graficos: " + pref.getString("graficos", "?");
        // context, string a mostrar, tiempo que lo va a mostrar
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}