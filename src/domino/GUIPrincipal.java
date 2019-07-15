package domino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GUIPrincipal extends JFrame {
    public static final Dimension tamañoJuego = new Dimension(100, 100);
    public final ImageIcon fichaVoid = new ImageIcon("src/imagenes/0-0.jpg");
    private ControlUnit controlUnit = new ControlUnit();
    private ArrayList<Fichas> manoJugador = controlUnit.getManoJugador();
    private ArrayList<Fichas> manoComputador = controlUnit.getManoComputador();
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




    public GUIPrincipal() {
        controlUnit.repartirFichas();

        escuchaInicio = new EscuchaInicio();
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

        for (int i = 0; i < 28; i++){

            //printFichasDelJuego.add(new JLabel(fichasDelJuego.get(i).getImagenDomino()));
            printFichasDelJuego.add(new JLabel(fichaVoid));
            printFichasDelJuego.get(i).addMouseListener(escuchaInicio);
            panelJuego.add(printFichasDelJuego.get(i));

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
        add(panelJuego,BorderLayout.CENTER);
        add(panelPC, BorderLayout.NORTH);
        add(panelLateral, BorderLayout.AFTER_LINE_ENDS);


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


            if (playerValue > pcvalue){
                playerInit = true;
                JOptionPane.showMessageDialog(null, "Sacaste más puntaje, tu inicias!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Sacaste menor puntaje, la maquina inicia");

                for (int i = 0; i < 28; i++){


                    panelJuego.remove(new JLabel(fichaVoid));
                    panelJuego.remove(imagenJugador);

                }
                panelJuego.updateUI();
            }



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


