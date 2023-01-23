package com.example.asteroides;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asteroides.modelo.MiAdaptador;
import com.example.asteroides.presentacion.MainActivity;

/** @author Mendoza Castañeda José Ricardo.
 *  RecyclerView.
 *  Para crear una lista de elementos con RecyclerView debemos seguir los siguientes pasos:
 *  1) Diseñar un layout que visualice el RecyclerView
 *  2) Implementar la actividad
 *  3) Diseñar un layout individual que se repetira en la lista
 *  ---
 *  4) Personalizar cada una de los layouts individuales segun nuestros datos utilizando un adaptador.
 *  5) Definir como queremos que se posicionen los elementos en las vistas.
 * */

public class Puntuaciones extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.puntuaciones );
        recyclerView = findViewById( R.id.recyclerView );
        // Creamos el adaptador.
        adaptador = new MiAdaptador( this, MainActivity.almacen.listaPuntuaciones(3) );
        // Asignamos el adaptador al recyclerView.
        recyclerView.setAdapter( adaptador );
        // Creamos un layout manager del tipo LinearLayoutManager.
        layoutManager = new LinearLayoutManager( this );
        // Asignamos el layout al recyclerView.
        recyclerView.setLayoutManager( layoutManager );

        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Nos indicaran la posicion de una vista dentro del adaptador.
                int pos = recyclerView.getChildAdapterPosition( view );
                String s = MainActivity.almacen.listaPuntuaciones( 10 ).get( pos );
                Toast.makeText(Puntuaciones.this, "Selección: " + pos + " - " + s, Toast.LENGTH_LONG).show();
            }
        });
    }
}
