package domino;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelJuego extends JPanel implements ActionListener {
    private JButton iniciarJuego;
    ControlUnit control = new ControlUnit();
    private static JLabel fichaActivaPanel;


    public PanelJuego() {
        this.setBackground(Color.lightGray);
        this.setPreferredSize(GUIPrincipal.tamanoJuego);


        bi = null;

    }

    BufferedImage bi;

    public class RotateJLabel extends JPanel {


        {
            try {
                bi = ImageIO.read(new File(fichaActivaPanel.getIcon().toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.PI / 4, bi.getWidth() / 2, bi.getHeight() / 2);
            g2.drawImage(bi, 0, 0, null);


        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(), bi.getHeight());
    }


    public void changeLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension height = getSize();
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);

        iniciarJuego = new JButton("Iniciar");
        iniciarJuego.setBounds(300, 300, 100, 50);
        iniciarJuego.addActionListener(this);
        iniciarJuego.setVisible(true);
        // add(iniciarJuego);

    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == iniciarJuego) {
            JOptionPane.showMessageDialog(null, "Sup");
        }

    }


}
