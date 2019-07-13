package domino;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIPrincipal extends JFrame {
    public static final Dimension tamañoJuego = new Dimension(100, 100);
    private ControlUnit controlUnit = new ControlUnit();
    private ArrayList<Fichas> manoJugador = controlUnit.getManoJugador();

    private JLabel ficha0, ficha1, ficha2, ficha3, ficha4, ficha5, ficha6;
    private PanelLateral panelLateral = new PanelLateral();
    private PanelJuego panelJuego = new PanelJuego();
    private PanelPC panelPC = new PanelPC();
    private PanelJugador panelJugador = new PanelJugador();


    public GUIPrincipal() {
        controlUnit.repartirFichas();


        initGUI();

        this.setTitle("Domino!      骨牌    ドミノ");
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        this.getContentPane().setLayout(new BorderLayout());


        //ficha0 = new JLabel(manoJugador.get(0).getImagenDomino());
        System.out.println(manoJugador.get(0).getImagenDomino());

        add(panelJugador, BorderLayout.SOUTH);
        add(panelJuego,BorderLayout.CENTER);
        add(panelPC, BorderLayout.NORTH);
        add(panelLateral, BorderLayout.AFTER_LINE_ENDS);

    }


}