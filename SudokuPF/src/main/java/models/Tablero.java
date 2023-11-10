/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andrisharaizaespinoza
 */
public class Tablero {
     
    private int tablero[][];
   /*
    Creamos la matriz del tablero de 9x9 con valores en algunas casiilas
    ya predeterminados
    */ 
    public Tablero(){
        int sudo[][] ={
        {0,6,0,1,0,4,0,5,0},
        {0,0,8,3,0,5,6,0,0},
        {2,0,0,0,0,0,0,0,1 },
        {8,0,0,4,0,7,0,0,6},
        {0,0,6,0,0,0,3,0,0},
        {7,0,0,9,0,1,0,0,4},
        {5,0,0,0,0,0,0,0,2},
        {0,0,7,2,0,6,9,0,0},
        {0,4,0,5,0,8,0,7,0},
        };
        tablero = sudo;
    }
    /*
    *Metodos para resolver correctamente el sudoku
    */
    //Recorren las columnas y filas de la matriz 
    public boolean resolverTablero(){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){
                if (tablero[i][j] ==0){
                    //si alguna de las posiciones es = 0 podemos agregar valores
                    for (int valor = 1; valor <= 9; valor++){
                      /*
                      *Restriccion a la hora de poner un valor en una casilla
                      *Que no se encuentren en la misma fila, columna o bloque
                      */
                      //Validar fila, columna y bloque
                      if(getFilas(i, valor) && getColumna(j, valor) && getBloque(i,j,valor)){
                          tablero[i][j] = valor;
                          if(resolverTablero()) return true;
                          //Back-tracking
                          tablero[i][j]=0;
                      }
                   } return false;
                }
            }
        }return true;
    } 
    /*
    *Verificacion de los bloques del tablero
    */
    public int BloqueActual(int pos){
        if(pos<=2) return 3;
        else if(pos <=5) return 6;
        else return 9;
    }
    /*
    *Verificacion de la ubicacion actual en el tablero
    */
    public boolean getBloque(int i, int j, int valor){
        int posFila = BloqueActual(i);
        int posColumna = BloqueActual(j);
        //Recorer filas y columnas del cuadrante actual
        for(int k = posFila -3; k < posFila; k++){
            for(int l = posColumna -3; l < posColumna; l++){
            //Verificar si el valor que queremos ingresar se encuentra en el bloque actual
            if(tablero[k][l]==valor){
                return false;
            }
        }
      }
            return true;
    }
    
    /*
    *Verificacion de las filas del tablero
    */
    public boolean getFilas(int i, int valor){
        //Recorer la fila
        for (int j = 0; j < tablero[i].length; j++){
            //Verificacion si el numero ya esta en dicha fila
            if (tablero[i][j]==valor){
                return false;
            }
        }
        return true;
    }
    
    /**
     *Verificacion de las columnas del tablero
     */
    public boolean getColumna(int j, int valor){
        //Recorer columnas
        for(int i = 0; i < tablero.length; i++){
            //Verificacion si el numero ya esta en dicha columna
            if(tablero[i][j]== valor){
                return false;
            }
        }
        return true;
    }
    /**
     * Método para inicializar y resolver el juego de Sudoku.
     */
    public void inicializar(){
        resolverTablero();
        for(int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[0].length; j++){ 
                System.out.print(tablero[i][j]);
                if(!(j==tablero[0].length-1)) System.out.print(" - ");
            }
            System.out.println();
        }
    }
    
    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
}
