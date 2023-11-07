package models;

import enums.Contenido;

/**
 *
 * @author Pablo
 */
public class Tablero {

    private Casilla[][] casillas;
    private final int numFilas = 9;
    private final int numColumnas = 9;

    public Tablero() {
    }

    public void inicializar() {
        // Creamos un arreglo de casillas
        casillas = new Casilla[numFilas][numColumnas];

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                // Creamos una casilla por cada posición del arreglo
                casillas[i][j] = new Casilla();
            }
        }
    }

    public void setCasilla(int fila, int columna, Contenido valor) {

    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public Casilla[] getFilas(int fila) {
        // Creamos un arreglo para representar las filas del tablero
        Casilla[] filas = new Casilla[numColumnas];

        for (int i = 0; i < numColumnas; i++) {
            // Almacenamos cada elemento de la fila
            filas[i] = casillas[fila - 1][i];
        }
        return filas;
    }

    public Casilla[] getColumnas(int columna) {
        // Creamos un arreglo para representar las columnas del tablero
        Casilla[] columnas = new Casilla[numFilas];

        for (int i = 0; i < numFilas; i++) {
            // Almacenamos cada elemento de la columna
            columnas[i] = casillas[i][columna - 1];
        }
        return columnas;
    }

    public Casilla[][] getBloque(int fila, int columna) {
        // Calculamos la fila en la que se encuentra el bloque
        int filaBloque = (fila - 1)/3;
        // Calculamos la columna en la que se encuentra el bloque
        int columnaBloque = (columna - 1)/3;
        
        // Creamos un arreglo para representar un bloque 3x3 dentro del tablero
        Casilla[][] bloque = new Casilla[3][3];
        // Calculamos la fila en la que se encuentra la primera casilla del bloque
        int inicioFila = filaBloque * 3;
        // Calculamos la columna en la que se encuentra la primera casilla del bloque
        int inicioColumna = columnaBloque * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bloque[i][j] = casillas[inicioFila + i][inicioColumna + j];
            }
        }
        return bloque;
    }
}
