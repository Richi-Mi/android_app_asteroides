package com.example.asteroides.modelo;

import java.util.List;

/** Interface.
 * Una interfaz es una clase abstracta pura, es decir, una clase donde se indican los metodo, pero no se implementa ninguno
 * Permite al programador establecer una estructura que ha de seguir toda clase que implemente la interfaz
 * * Solo se definen los nombres de los metodos, parametros y tipo de retorno.
 * * tambien contiene constantes.
 */

public interface AlmacenPuntuaciones {
    public void guardarPuntuacion( int puntos, String nombre, long fecha );
    public List<String> listaPuntuaciones( int cantidad );
}
