/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import javax.swing.*;
import java.util.ArrayList;


/**
 *
 * @author invitado
 */
public class Fichas  {
    public int getCara1() {
        return cara1;
    }

    public int getCara2() {
        return cara2;
    }

    private int cara1,cara2;
     private String imagen;
    private boolean tapa;

    Fichas(int i, int i0,  boolean tapa) {
    	cara1 = i;
    	cara2 = i0;

        imagen = new String("src/imagenes/"+i+"-"+i0+".jpg");

        this.tapa = tapa;
    }

    public String  getImagenDomino() {
        return imagen;
    }
}
