package models;

public class Casilla {
    private int contenido;
    
    public Casilla() {
        contenido = 0;
    }
    
    public void setContenido(int nContenido){
        this.contenido = nContenido;
    }
    
    public int getContenido() {
        return this.contenido;
    }
    
    public boolean esEditable() {
        return contenido == 0;
    }
    
    @Override
    public String toString() {
        return String.valueOf(contenido);
    }
}
