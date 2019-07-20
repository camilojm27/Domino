package domino;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPC extends JPanel {
    public PanelPC(){
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
