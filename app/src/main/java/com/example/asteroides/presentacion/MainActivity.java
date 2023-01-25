package com.example.asteroides.presentacion;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.asteroides.datos.AlmacenPuntuacionesArray;
import com.example.asteroides.modelo.AlmacenPuntuaciones;
import com.example.asteroides.R;

public class MainActivity extends AppCompatActivity {

    public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();

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
        Intent i = new Intent( this, AcercaDeActivity.class );
        startActivity( i );
    }

    public void lanzarPreferencias( View view ) {
        Intent i = new Intent( this, PreferenciasActivity.class );
        startActivity( i );
    }

    public void lanzarPuntuaciones( View view ) {
        // Metodo para cerrar la app, es equivalente al metodo de retorno.
        //finish();

        Intent i = new Intent( this, PuntuacionesActivity.class );
        startActivity( i );
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
        if ( id == R.id.menu_puntuaciones ) {
            lanzarPuntuaciones( null );
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