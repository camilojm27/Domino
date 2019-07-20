package domino;

import javax.swing.*;
import java.awt.*;


public class PanelJugador extends JPanel {
    public PanelJugador(){
        this.setBackground(Color.cyan);
        this.setPreferredSize(GUIPrincipal.tamanoJuego);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Dimension height = getSize();
    	ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/madera.jpg"));  
    	g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
    	setOpaque(false);

    }
}
