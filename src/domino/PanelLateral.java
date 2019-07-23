package domino;

import javax.swing.*;
//https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLateral extends JPanel  {

    private String username = "Camilo y Santiago", computador = "IA-2019-1";
    private int puntaje=0;

    private boolean gano, perdio, rendirse;
    private ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/GridPaper.jpg"));
    private ImageIcon IA = new ImageIcon(getClass().getResource("/imagenes/IA-PC.jpg"));
    private  JPanel lateralPane = this;
    private  ImageIcon plusButton;
    private EscuchaRestantes escuchaRestantes = new EscuchaRestantes();

    public PanelLateral(){

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(300,1000));
        plusButton = new ImageIcon("src/imagenes/plus2.png");
        lateralPane.addMouseListener(escuchaRestantes);
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Dimension height = getSize();
      	 
    	//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
    	 

    	 
    	//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
    	 
    	g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        g.drawImage(IA.getImage(), 20, 20, null);
        g.drawImage(plusButton.getImage(), 0 , 20,null);
    	setOpaque(false);

        //Computer
        g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        g.setColor(Color.MAGENTA);
        g.drawString(computador, 20, 20);


        //Fichas Sobrantes
        g.setColor(Color.black);

        g.drawString("Fichas Sobrantes: " + ControlUnit.fichasRestantes , 50, 230);


      //  repaint();
        //g.drawString(String.valueOf(puntaje), 180, 200);


        //Username
        g.setColor(Color.MAGENTA);




    }

    private class EscuchaRestantes implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

            JOptionPane.showMessageDialog(null, "Se ha agregado una nueva ficha a tu mazo");
            ControlUnit.fichasRestantes -=1;

            lateralPane.updateUI();


        }

        @Override
        public void mousePressed(MouseEvent e) {

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
    }
    
   
    
  
    	
    	 
    	
    	

}
