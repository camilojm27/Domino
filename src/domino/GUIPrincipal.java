package domino;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUIPrincipal extends JFrame {
    public static final Dimension tamanoJuego = new Dimension(100, 100);

    public final ImageIcon fichaVoid = new ImageIcon("src/imagenes/0-0.jpg");
    private static ControlUnit controlUnit = new ControlUnit();



    private static ArrayList<Fichas> manoJugador = controlUnit.getManoJugador();
    private static ArrayList<Fichas> manoComputador = controlUnit.getManoComputador();
    private ArrayList<Fichas> fichasDelJuego = controlUnit.getRandomFichaDelJuego();
    private ArrayList<JLabel> printFichasDelJuego = new ArrayList<>();
    private boolean cambiar;
    private ArrayList<JLabel> manoPrintJugador = new ArrayList<>();
    private ArrayList<JLabel> manoPrintPC = new ArrayList<>();
    private PanelLateral panelLateral = new PanelLateral();
    private PanelJuego panelJuego = new PanelJuego();
    private PanelPC panelPC = new PanelPC();
    private PanelJugador panelJugador = new PanelJugador();
    private EscuchaInicio escuchaInicio;
    private boolean playerInit; // 1 si es el jugador 0 si es el computador
    private GraphicsEnvironment ge;
    private Window ventanaPrincipal = this;
    public static int fichasRestantes;
    private EscuchaFichas escuchaFichas = new EscuchaFichas();
    private static JLabel fichaActiva;
    private static JLabel fichaActivaPc;
    private boolean gameOver = false;


    public GUIPrincipal() throws IOException {
        controlUnit.repartirFichas();

        escuchaInicio = new EscuchaInicio();
        initGUI();

        this.setTitle("Domino!");
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(ventanaPrincipal);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initGUI() {
        this.getContentPane().setLayout(new BorderLayout());
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        for (int i = 0; i < 28; i++) {

            //printFichasDelJuego.add(new JLabel(fichasDelJuego.get(i).getImagenDomino()));
            printFichasDelJuego.add(new JLabel(fichaVoid));
            printFichasDelJuego.get(i).addMouseListener(escuchaInicio);
            panelJuego.add(printFichasDelJuego.get(i));
            panelJuego.updateUI();

        }

        /*

        for (int i=0; i < manoJugador.size(); i++){
            manoPrintJugador.add(new JLabel(manoJugador.get(i).getImagenDomino()));
            panelJugador.add(manoPrintJugador.get(i));
        }
        for (int i=0; i < manoComputador.size(); i++){
            manoPrintPC.add(new JLabel(manoComputador.get(i).getImagenDomino()));
            panelPC.add(manoPrintPC.get(i));
        }*/


        add(panelJugador, BorderLayout.SOUTH);
        add(panelJuego, BorderLayout.CENTER);
        add(panelPC, BorderLayout.NORTH);
        add(panelLateral, BorderLayout.AFTER_LINE_ENDS);


    }

    private void initGame() {
        escuchaInicio = null;


        printFichasDelJuego = new ArrayList<>();
        controlUnit.imprimirMano();

        for (int i = 0; i < manoJugador.size(); i++) {
            manoPrintJugador.add(new JLabel(manoJugador.get(i).getImagenDomino()));
            panelJugador.add(manoPrintJugador.get(i));
            manoPrintJugador.get(i).addMouseListener(escuchaFichas);
        }

        for (int i = 0; i < manoComputador.size(); i++) {
            manoPrintPC.add(new JLabel(manoComputador.get(i).getImagenDomino()));
            panelPC.add(new JLabel(fichaVoid));
            //manoPrintPC.get(i).addMouseListener(escuchaFichas);
        }

        fichasRestantes = controlUnit.fichasMesa();
        System.out.println(fichasRestantes);
        panelLateral.repaint();

        panelPC.updateUI();
        panelJugador.updateUI();
        panelLateral.updateUI();

    }

    public static JLabel setFichaActivaPc() {
        fichaActivaPc = (new JLabel(manoComputador.get(controlUnit.fichaAdecuada()).getImagenDomino()));
        return fichaActivaPc;
    }

    public static JLabel getFichaActivaPc() {
        return fichaActivaPc;
    }

    public static JLabel getFichaActiva() {
        return fichaActiva;
    }
    public static ArrayList<Fichas> getManoJugador() {
        return manoJugador;
    }

    public static ArrayList<Fichas> getManoComputador() {
        return manoComputador;
    }

    public void playerMover() {

        switch (controlUnit.ponerFichaJugador(fichaActiva)) {
            case -1:

                controlUnit.setConteo();
                panelJuego.add(fichaActiva);
                panelJuego.RotateJLabel
                fichaActiva.removeMouseListener(escuchaFichas);
                controlUnit.removeFicha(manoJugador, fichaActiva);
                controlUnit.imprimirMano();
                panelJuego.updateUI();
                panelJugador.updateUI();

                break;
            case 1:
                controlUnit.setFichasPanelJuego(fichaActiva);
                controlUnit.setConteo();
                panelJuego.add(fichaActiva);
                fichaActiva.removeMouseListener(escuchaFichas);
                controlUnit.removeFicha(manoJugador, fichaActiva);
                controlUnit.imprimirMano();
                panelJuego.updateUI();
                panelJugador.updateUI();
                break;
            case 3:
                controlUnit.setFichasPanelJuego(fichaActiva);
                controlUnit.setConteo();
                panelJuego.add(fichaActiva);
                fichaActiva.removeMouseListener(escuchaFichas);
                controlUnit.removeFicha(manoJugador, fichaActiva);
                controlUnit.imprimirMano();
                panelJuego.updateUI();
                panelJugador.updateUI();
                break;
            case 4:

                controlUnit.setFichasPanelJuego(fichaActiva);
                controlUnit.setConteo();
                panelJuego.add(fichaActiva);
                fichaActiva.removeMouseListener(escuchaFichas);
                controlUnit.removeFicha(manoJugador, fichaActiva);
                controlUnit.imprimirMano();
                panelJuego.updateUI();
                panelJugador.updateUI();
                break;
            case 6:
                controlUnit.setFichasPanelJuego(fichaActiva);
                controlUnit.setConteo();
                panelJuego.add(fichaActiva);
                fichaActiva.removeMouseListener(escuchaFichas);
                controlUnit.removeFicha(manoJugador, fichaActiva);
                controlUnit.imprimirMano();
                panelJuego.updateUI();
                panelJugador.updateUI();
                break;

            default:
                break;

        }


    }

    public void computerMover() {
        controlUnit.ponerFichaPc(fichaActivaPc);
        panelJuego.add(fichaActivaPc);
        controlUnit.removeFicha(manoComputador, fichaActivaPc);
        controlUnit.imprimirMano();


        panelJuego.updateUI();
        panelPC.updateUI();
    }

    private class EscuchaFichas implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

            fichaActiva = (JLabel) arg0.getSource();
            setFichaActivaPc();
            playerMover();
            panelJuego.updateUI();
            panelPC.updateUI();

            //computerMover();
            //controlUnit.pcJugar();
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

    }

    private class EscuchaInicio implements MouseListener {
        private JLabel imagenJugador = new JLabel();
        private int playerValue;
        private int pcvalue;
        private Fichas fichaJugador = controlUnit.dameUnaFicha();
        private Fichas fichaPC = controlUnit.dameUnaFicha();


        @Override
        public void mouseClicked(MouseEvent e) {
            imagenJugador = (JLabel) e.getSource();
            playerValue = fichaJugador.getSum();
            pcvalue = fichaPC.getSum();

            imagenJugador.setIcon(fichaJugador.getImagenDomino());

            if (playerValue > pcvalue) {
                playerInit = true;
                panelJuego.removeAll();
                panelJuego.updateUI();
                initGame();
                JOptionPane.showMessageDialog(null, "Sacaste mas puntaje, tu inicias!");
            } else {
                JOptionPane.showMessageDialog(null, "Sacaste menor puntaje, la maquina inicia");
                panelJuego.removeAll();
                panelJuego.updateUI();
                initGame();

            }

            panelJuego.changeLayout();


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

