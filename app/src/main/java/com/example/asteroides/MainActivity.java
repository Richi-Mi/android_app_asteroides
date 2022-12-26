package com.example.asteroides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main_constraint );

        // Accediendo a los valores de los recursos de la app en la carpeta Res.
        Resources res = getResources();

        Drawable drawable = res.getDrawable(android.R.drawable.alert_dark_frame);
        Drawable icon     = res.getDrawable( R.drawable.ic_launcher_foreground );
        String titulo     = res.getString( R.string.Asteroides );
        int color         = res.getColor( R.color.black );
        float fontSize    = res.getDimension( R.dimen.tamaño_fuente );
        boolean limit     = res.getBoolean( R.bool.limite );
        String[] dias     = res.getStringArray( R.array.dias_semana );
    }

}