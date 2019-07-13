package domino;
//https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
import javax.swing.JPanel;
import java.awt.*;

public class PanelLateral extends JPanel  {

    private String username = "Camilo y Santiago", computador = "IA-2019-1";
    private int puntaje=0, fichasPorPedir;
    private boolean gano, perdio, rendirse;
    public PanelLateral(){
        this.setBackground(Color.orange);
        this.setPreferredSize(new Dimension(300,1000));

    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Computer
        g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        g.setColor(Color.MAGENTA);
        g.drawString(computador, 20, 20);


        //Fichas Sobrantes
        g.setColor(Color.black);
        g.drawString(String.valueOf(puntaje), 50, 200);


        //Username
        g.setColor(Color.MAGENTA);
        g.drawString(username, 20, 420);
    }

}
