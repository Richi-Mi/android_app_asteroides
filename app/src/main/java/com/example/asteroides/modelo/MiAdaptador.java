package com.example.asteroides.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asteroides.R;

import java.util.List;

/** ¿Que es un adaptador?
 * Un adaptador es un mecanismo estandar en android que nos permite crear una serie de vistas que han de ser mostradas dentro de un contenedor,
 * En este caso creamos el adaptador a partir de la clase RecyclerView.Adapter
 * */

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private LayoutInflater inflador;
    private List<String> lista;
    protected View.OnClickListener onClickListener;

    public MiAdaptador( Context context, List<String> lista ) {
        // Conjunto de datos a mostrar.
        this.lista = lista;
        // El inflador nos va a permitir crear una vista a partir de su XML.
        inflador = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    // Devuelve una vista de un elemento sin personalizar
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Usamos el metodo inflate para crear una vista a partir del layout XML definido en elemento_lista
        // el segundo parametro se indica el layout padre que contendra a la vista que se va a crear.
        // El tercer parametro del metodo permite indicar si queremos que la vista sea insertada eb el padre.
        // Indicamos false dado que esta operación la va hacer el RecyclerView.
        View v = inflador.inflate( R.layout.elemento_lista, parent, false );
        v.setOnClickListener( onClickListener );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Personaliza un elemento de tipo ViewHolder según su posición
        holder.titulo.setText( lista.get( position ) );
        switch ( Math.round( (float) Math.random() * 3 )) {
            case 0:
                holder.icon.setImageResource( R.drawable.list_icon_asteroide );
                break;
            case 1:
                holder.icon.setImageResource( R.drawable.icon_app );
                break;
            case 3:
                holder.icon.setImageResource( R.drawable.icono_asteroides_2 );
        }
    }

    @Override
    public int getItemCount() {
        // Se utiliza para indicar el numero de elementos a visualizar.
        return lista.size();
    }

    // Esta clase contendra las vistas que queremos modificar de un elemento.
    // En este caso 2 TextView con un ImageView.

    public void setOnItemClickListener( View.OnClickListener onClickListener ) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /** @apiNote Esta clase es utilizada para evitar tener que crear las vistas de cada elemento desde cero
         * Lo que hace el ViewHolder es que contendra las 3 vistas ya creadas pero sin personalizar de esta forma se tiene el mismo viewHolder para todos.
         * y simplemente se personaliza segun la posición.
         * */

        public TextView titulo, subtitulo;
        public ImageView icon;

        ViewHolder( View itemView ) {
            super( itemView );
            titulo = itemView.findViewById( R.id.titulo );
            subtitulo = itemView.findViewById( R.id.subitulo );
            icon = itemView.findViewById( R.id.icono );
        }

    }
}
