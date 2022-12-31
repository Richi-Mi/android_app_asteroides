package com.example.asteroides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

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

}