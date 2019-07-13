package domino;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIPrincipal extends JFrame {

    private ControlUnit controlUnit = new ControlUnit();
    private ArrayList<Fichas> manoJugador =  controlUnit.getManoJugador();

    private JLabel ficha0, ficha1, ficha2, ficha3, ficha4, ficha5, ficha6;



    public GUIPrincipal(){
        controlUnit.repartirFichas();


        initGUI();

        this.setTitle("Domino!      骨牌    ドミノ");
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
    this.getContentPane().setLayout(new FlowLayout());

        ficha0 = new JLabel(new ImageIcon(manoJugador.get(0).getImagenDomino()) );
        System.out.println(manoJugador.get(0).getImagenDomino());
        add(ficha0);

    }


}