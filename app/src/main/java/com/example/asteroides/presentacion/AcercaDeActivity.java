package com.example.asteroides.presentacion;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.asteroides.R;

public class AcercaDeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.acerca_de );
    }
}
