package enums;

/**
 *
 * @author Pablo
 */
public enum Contenido {
    UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), VACIA(0);
   
    private final int valorNumerico;
    
    Contenido(int valorNumerico){
    this.valorNumerico = valorNumerico;
    }
    
    public int getValorNumerico(){
        return valorNumerico;
    }
}

