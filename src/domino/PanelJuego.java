package domino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel implements ActionListener {
	private JButton iniciarJuego;
	ControlUnit control = new ControlUnit();
	private static JLabel fichaActivaPanel;
	
    public PanelJuego(){
        this.setBackground(Color.lightGray);
        this.setPreferredSize(GUIPrincipal.tamanoJuego);
        
        
    }
    
    public void changeLayout() {
    	this.setLayout(new GridBagLayout());
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Dimension height = getSize();
    	ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));  
    	g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
    	setOpaque(false);
    	
    	 iniciarJuego = new JButton("Iniciar");
         iniciarJuego.setBounds(300,300, 100,50);
         iniciarJuego.addActionListener(this);    
         iniciarJuego.setVisible(true);
        // add(iniciarJuego);
    }
    
    public void actionPerformed(ActionEvent evento) {
    	
    	if(evento.getSource() == iniciarJuego) {
    		JOptionPane.showMessageDialog(null, "Sup");
    	}
    	
    }
    
    
    	
    
    
    
    
    
}
