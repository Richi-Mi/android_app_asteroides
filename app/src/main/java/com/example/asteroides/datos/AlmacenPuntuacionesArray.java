package com.example.asteroides.datos;

import com.example.asteroides.modelo.AlmacenPuntuaciones;

import java.util.ArrayList;
import java.util.List;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones {

    private List<String> puntuaciones;

    public AlmacenPuntuacionesArray() {
        puntuaciones = new ArrayList<String>();
        puntuaciones.add("123000 Pepito Dominguez");
        puntuaciones.add("111000 Paco Perez");
        puntuaciones.add("003000 Pedro Martinez");
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        puntuaciones.add( 0, puntos + " " + nombre );
    }

    @Override
    public List<String> listaPuntuaciones( int cantidad ) {
        return puntuaciones;
    }
}
