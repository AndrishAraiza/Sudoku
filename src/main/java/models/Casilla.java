package models;
import enums.Contenido;

/**
 *
 * @author Pablo
 */
public class Casilla {
    private Contenido contenido;
    
    public Casilla() {
        contenido = Contenido.VACIA;
    }
    
    public void setContenido(Contenido nContenido){
        this.contenido = nContenido;
    }
    
    public Contenido getContenido() {
        return this.contenido;
    }
    
    public boolean esEditable() {
        return contenido == Contenido.VACIA;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.contenido.getValorNumerico());
    }
}
