package domino;
import javax.swing.ImageIcon;
//https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
import javax.swing.JPanel;
import java.awt.*;

public class PanelLateral extends JPanel  {

    private String username = "Camilo y Santiago", computador = "IA-2019-1";
    private int puntaje=0;
    public int fichasPorPedir;
    private boolean gano, perdio, rendirse;
    public PanelLateral(){

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(300,1000));

    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Dimension height = getSize();
      	 
    	//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
    	 
    	ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/GridPaper.jpg")); 
    	 
    	//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
    	 
    	g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
    	 
    	setOpaque(false);

        //Computer
        g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        g.setColor(Color.MAGENTA);
        g.drawString(computador, 20, 20);


        //Fichas Sobrantes
        g.setColor(Color.black);
        g.drawString("Fichas Sobrantes: " + GUIPrincipal.fichasRestantes , 20, 200);
      //  repaint();
        //g.drawString(String.valueOf(puntaje), 180, 200);


        //Username
        g.setColor(Color.MAGENTA);
        g.drawString(username, 20, 420);
        
        

    }
    
   
    
  
    	
    	 
    	
    	

}
