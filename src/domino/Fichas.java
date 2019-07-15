/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import javax.swing.*;
import java.util.ArrayList;


/**
 * @author invitado
 */
public class Fichas {


    private int cara1, cara2;
    private ImageIcon imagen;
    private boolean tapa;

    Fichas(int i, int i0, boolean tapa) {
        cara1 = i;
        cara2 = i0;

        imagen = new ImageIcon("src/imagenes/" + i + "-" + i0 + ".jpg");

        this.tapa = tapa;
    }

    public ImageIcon getImagenDomino() {
        return imagen;
    }

    public int getCara1() {
        return cara1;
    }


    public int getCara2() {
        return cara2;
    }

    public int getSum(){
        return cara1 + cara2;
    }
}


