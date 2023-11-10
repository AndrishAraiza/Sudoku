/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;


 /*
 *
 * @author andrisharaizaespinoza
 */
public final class TableroSudoku extends JPanel {
    /*
    * Atributos para la creacion del tablero
    */
    private JTextField[][] listaTxt;   // Matriz de campos de texto para celdas del tablero
    private int txtAncho;             // Ancho de un campo de texto
    private int txtAltura;            // Altura de un campo de texto
    private int txtMargen;            // Margen entre celdas del tablero
    private int txtTamañoLetra;       // Tamaño de letra en los campos de texto
    private Color panelBackground;    // Color de fondo del panel
    private Color txtBackground1;     // Color de fondo de celdas de tipo 1
    private Color txtForeground1;     // Color de texto de celdas de tipo 1
    private Color txtBackground2;     // Color de fondo de celdas de tipo 2
    private Color txtForeground2;     // Color de texto de celdas de tipo 2
    private Color txtBackground3;     // Color de fondo de celdas de tipo 3
    private Color txtForeground3;     // Color de texto de celdas de tipo 3
    private Tablero sudoku;           // Instancia de la clase Tablero
    private ArrayList<JTextField> listaTxtAux; // Lista de campos de texto auxiliar
    
    
    /*
    * Constructor de la clase 
    */
    public TableroSudoku(){
        iniciarComponentes();
    }
    /*
    * Inicializamos los componentes de la matriz
    */
    public void iniciarComponentes(){
     
        listaTxt = new JTextField[9][9];
        txtAncho = 35;
        txtAltura = 36;
        txtMargen = 4;
        txtTamañoLetra = 27;
        //Volores predeterminados de los fondos del tablero
        panelBackground = Color.BLACK;
        txtBackground1 = Color.WHITE;
        txtForeground1 = Color.BLACK;
        txtBackground2 = Color.WHITE;
        txtForeground2 = Color.BLACK;
        txtBackground3 = Color.WHITE;
        txtForeground3 = Color.BLACK;
        
        sudoku = new Tablero();
        listaTxtAux = new ArrayList<>();
    }
    
    /*
    * Este metodo crea y ordena las celdas del tablero
    */
    public void crearSudoku(){
        this.setLayout(null);
        // Ordenamiento del tablero
        this.setSize(txtAncho * 9 + (txtMargen * 4), txtAltura * 9 + (txtMargen * 4));
        // Color de fondo del panel
        this.setBackground(panelBackground);
        crearCamposTxt();
    
    }
    /*
    * Crea los campos de texto que forman el tablero de Sudoku.
    */
    public void crearCamposTxt() {
        int x = txtMargen;
        int y = txtMargen;
        // Iterar a través de las filas del tablero
        for(int i = 0; i< listaTxt.length; i++){
            // Iterar a través de las columnas del tablero
            for(int j = 0; j < listaTxt[0].length; j++){
            
                JTextField txt = new JTextField(); // Crea un nuevo objeto de campo de texto
                this.add(txt); // Agrega el campo de texto al panel actual
                txt.setBounds(x, y, txtAncho, txtAltura); // Establece la posición y el tamaño del campo de texto
                txt.setBackground(txtBackground1); // Establece el color de fondo del campo de texto (tipo 1)
                txt.setForeground(txtBackground1); // Establece el color del texto del campo de texto (tipo 1)
                txt.setFont(new Font("Arial", Font.BOLD, txtTamañoLetra)); // Establece la fuente y el tamaño de la letra en el campo de texto
                txt.setVisible(true); // Hace visible el campo de texto en la interfaz
                txt.setEditable(false); // Deshabilita la edición del campo de texto
                txt.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al estilo de una mano al pasar sobre el campo de texto
                txt.setBorder(BorderFactory.createLineBorder(panelBackground, 1)); // Establece un borde alrededor del campo de texto, con el color del panel de fondo
                x += txtAncho; // Desplaza la posición 'x' hacia la derecha en el ancho de un campo de texto, al crear la siguiente celda.
                
                // Añadir un margen si la celda es múltiplo de 3
                if((j+1) %3==0){
                    x+=txtMargen; // Si la columna es múltiplo de 3, añade un margen adicional entre celdas.
                }
                listaTxt[i][j] = txt; // Almacena el campo de texto recién creado en la matriz 'listaTxt'.
                generarEventos(txt); // Agrega eventos de mouse a los campos de texto
           }
            
            x = txtMargen; // Reinicia la posición 'x' al margen inicial, para comenzar una nueva fila de celdas.
            y += txtAltura; // Desplaza la posición 'y' hacia abajo en la altura de un campo de texto, para crear la siguiente fila de celdas.

            
            // Añadir un margen vertical si la fila es múltiplo de 3
            if((i+1)%3 == 0){
                y += txtMargen; // Si la fila es múltiplo de 3, añade un margen vertical adicional entre bloques de celdas.
            }
    }
}
    
    public void generarEventos(JTextField txt){
        MouseListener evento = new MouseListener() {
            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed(txt); // Llama al método 'pressed' cuando se presiona el campo de texto
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
             
            }
        };
        txt.addMouseListener(evento);
    }
    
    /*
    * Responde al evento de presionar un campo de texto seleccionado.
    */
    public void pressed(JTextField txt) {
        // Iterar a través de la lista de campos de texto auxiliar
        for(JTextField jTxt : listaTxtAux){
            jTxt.setBackground(txtBackground1);
            jTxt.setForeground(txtBackground1);
            jTxt.setBorder(BorderFactory.createLineBorder(panelBackground,1));
        }
            listaTxtAux.clear();
         
         // Iterar a través de las filas del tablero   
        for(int i = 0; i <listaTxt.length; i++){
            // Iterar a través de las columnas del tablero
            for (int j = 0; j < listaTxt[0].length; j++){
                if(listaTxt[i][j] == txt){
                    // Cambia los colores de celdas relacionadas al campo de texto seleccionado
                    
                    // Cambiar el color de fondo y texto de las celdas en la misma columna
                    for(int k = 0; k < listaTxt.length; k++){
                        listaTxt[k][j].setBackground(txtBackground2);
                        listaTxt[k][j].setForeground(txtBackground2);
                        listaTxtAux.add(listaTxt[k][j]);
                    }
                    
                    // Cambiar el color de fondo y texto de las celdas en la misma fila
                    for(int k = 0; k < listaTxt[0].length; k++){
                        listaTxt[i][k].setBackground(txtBackground2);
                        listaTxt[i][k].setForeground(txtBackground2);
                        listaTxtAux.add(listaTxt[i][k]);
                }
                    
                    // Calcular la posición de fila y columna en el bloque actual
                    int posFila = sudoku.BloqueActual(i);
                    int posColumna = sudoku.BloqueActual(j);
                    // Iterar a través de las celdas en el mismo bloque
                    for(int k = posFila-3; k <posFila; k++){            
                        for(int l = posColumna-3; l <posColumna; l++){
                            // Cambiar el color de fondo y texto de las celdas en el mismo bloque
                            listaTxt[k][l].setBackground(txtBackground2);
                            listaTxt[k][l].setForeground(txtBackground2);
                            listaTxtAux.add(listaTxt[k][l]);
                        }
                    }
                    // Cambiar el color de fondo, texto y el borde del campo de texto seleccionado
                    listaTxt[i][j].setBackground(txtBackground3);
                    listaTxt[i][j].setForeground(txtBackground3);
                    listaTxt[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                    return;
                }
            }
        }
    }
    
    public JTextField[][] getListaTxt() {
        return listaTxt;
    }

    public void setListaTxt(JTextField[][] listaTxt) {
        this.listaTxt = listaTxt;
    }

    public int getTxtAncho() {
        return txtAncho;
    }

    public void setTxtAncho(int txtAncho) {
        this.txtAncho = txtAncho;
    }

    public int getTxtAltura() {
        return txtAltura;
    }

    public void setTxtAltura(int txtAltura) {
        this.txtAltura = txtAltura;
    }

    public int getTxtMargen() {
        return txtMargen;
    }

    public void setTxtMargen(int txtMargen) {
        this.txtMargen = txtMargen;
    }

    public int getTxtTamañoLetra() {
        return txtTamañoLetra;
    }

    public void setTxtTamañoLetra(int txtTamañoLetra) {
        this.txtTamañoLetra = txtTamañoLetra;
    }

    public Color getPanelBackground() {
        return panelBackground;
    }

    public void setPanelBackground(Color panelBackground) {
        this.panelBackground = panelBackground;
    }

    public Color getTxtBackground1() {
        return txtBackground1;
    }

    public void setTxtBackground1(Color txtBackground1) {
        this.txtBackground1 = txtBackground1;
    }

    public Color getTxtForeground1() {
        return txtForeground1;
    }

    public void setTxtForeground1(Color txtForeground1) {
        this.txtForeground1 = txtForeground1;
    }

    public Color getTxtBackground2() {
        return txtBackground2;
    }

    public void setTxtBackground2(Color txtBackground2) {
        this.txtBackground2 = txtBackground2;
    }

    public Color getTxtForeground2() {
        return txtForeground2;
    }

    public void setTxtForeground2(Color txtForeground2) {
        this.txtForeground2 = txtForeground2;
    }

    public Color getTxtBackground3() {
        return txtBackground3;
    }

    public void setTxtBackground3(Color txtBackground3) {
        this.txtBackground3 = txtBackground3;
    }

    public Color getTxtForeground3() {
        return txtForeground3;
    }

    public void setTxtForeground3(Color txtForeground3) {
        this.txtForeground3 = txtForeground3;
    }

    
} 
    
    