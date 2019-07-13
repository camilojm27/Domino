/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author invitado
 */
public class Principal {
    
    public static void main(String args[]) {



        ControlUnit control = new ControlUnit();
        control.repartirFichas();
        control.imprimirMano();
        try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        }
        catch (Exception e) {}

        EventQueue.invokeLater(new Runnable() {public void run() { GUIPrincipal myWindow =
                new GUIPrincipal(); }});
        
    
        
    }
    
}
