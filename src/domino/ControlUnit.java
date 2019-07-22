/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static java.util.Collections.shuffle;

/**
 *
 * @author invitado
 */
public class ControlUnit extends ArrayList{
	Fichas fichaPedida;
	Random r = new Random();
	int cualFicha;
    private boolean tapa = false;
    private ArrayList<Fichas> manoJugador = new ArrayList<Fichas>();
    private ArrayList<Fichas> manoComputador = new ArrayList<Fichas>();
	private ArrayList<Fichas> fichasDelJuego = new ArrayList<Fichas>();



	private ArrayList<JLabel> fichasPanelJuego = new ArrayList<JLabel>();



	private int conteo = 0;
	int numero = 28;
	int fichasSobrantes;
	JLabel fichaActiva;
	JLabel fichaActivaPc;

	Fichas ficha00 = new Fichas(0,0,  tapa); Fichas ficha11 = new Fichas(1,1,  tapa); Fichas ficha22 = new Fichas(2,2,  tapa); Fichas ficha33 = new Fichas(3,3,  tapa); Fichas ficha44 = new Fichas(4,4,  tapa); Fichas ficha55 = new Fichas(5,5,  tapa); Fichas ficha66 = new Fichas(6,6,  tapa);
	Fichas ficha01 = new Fichas(0,1,  tapa); Fichas ficha12 = new Fichas(1,2,  tapa); Fichas ficha23 = new Fichas(2,3,  tapa); Fichas ficha34 = new Fichas(3,4,  tapa); Fichas ficha45 = new Fichas(4,5,  tapa); Fichas ficha56 = new Fichas(5,6,  tapa);
	Fichas ficha02 = new Fichas(0,2,  tapa); Fichas ficha13 = new Fichas(1,3,  tapa); Fichas ficha24 = new Fichas(2,4,  tapa); Fichas ficha35 = new Fichas(3,5,  tapa); Fichas ficha46 = new Fichas(4,6,  tapa);
	Fichas ficha03 = new Fichas(0,3,  tapa); Fichas ficha14 = new Fichas(1,4,  tapa); Fichas ficha25 = new Fichas(2,5,  tapa); Fichas ficha36 = new Fichas(3,6,  tapa);
	Fichas ficha04 = new Fichas(0,4,  tapa); Fichas ficha15 = new Fichas(1,5,  tapa); Fichas ficha26 = new Fichas(2,6,  tapa);
	Fichas ficha05 = new Fichas(0,5,  tapa); Fichas ficha16 = new Fichas(1,6,  tapa);
	Fichas ficha06 = new Fichas(0,6,  tapa);
	private int fichaCorrecta;

	public ControlUnit() {
		fichasDelJuego.add(ficha00); fichasDelJuego.add(ficha01); fichasDelJuego.add(ficha02); fichasDelJuego.add(ficha03); fichasDelJuego.add(ficha04); fichasDelJuego.add(ficha05); fichasDelJuego.add(ficha06);
		fichasDelJuego.add(ficha11); fichasDelJuego.add(ficha12); fichasDelJuego.add(ficha13); fichasDelJuego.add(ficha14); fichasDelJuego.add(ficha15); fichasDelJuego.add(ficha16);
		fichasDelJuego.add(ficha22); fichasDelJuego.add(ficha23); fichasDelJuego.add(ficha24); fichasDelJuego.add(ficha25); fichasDelJuego.add(ficha26);
		fichasDelJuego.add(ficha33); fichasDelJuego.add(ficha34); fichasDelJuego.add(ficha35); fichasDelJuego.add(ficha36);
		fichasDelJuego.add(ficha44); fichasDelJuego.add(ficha45); fichasDelJuego.add(ficha46);
		fichasDelJuego.add(ficha55); fichasDelJuego.add(ficha56);
		fichasDelJuego.add(ficha66);
	}

	
	public ArrayList<Fichas> getManoJugador() {
		return manoJugador;
	}

	public ArrayList<Fichas> getManoComputador() {
		return manoComputador;
	}
	
	public ArrayList<Fichas> getRandomFichaDelJuego() {
		ArrayList<Fichas> aux = fichasDelJuego;
		Collections.shuffle(aux);
		return aux;
	}

	public int getConteo() {
		return conteo;
	}

	public void setConteo() {
		this.conteo = conteo+1;
	}

	
	public Fichas dameUnaFicha() {
		

		cualFicha = r.nextInt(numero);
		fichaPedida = fichasDelJuego.get(cualFicha);
		fichasDelJuego.remove(cualFicha);
		numero--;
		return fichaPedida;
	}

	public void imprimirFicha() {
		int contador = 0;
		do {

			System.out.print(manoJugador.get(contador).getCara1());
			System.out.print("|");
			System.out.println(manoJugador.get(contador).getCara2());
			contador++;
		   }
		while(contador >=6);


	}

	public void repartirFichas() {
		for(int i = 0; i < 7; i++) {
			manoJugador.add(this.dameUnaFicha());
		}
		
		for(int i = 0; i < 7; i++) {
			manoComputador.add(this.dameUnaFicha());
		}
		
		for(int i = 6; i > 0; i--) {
			this.verificarFicha(i);
			this.verificarFichasJugador(i);
		}
		
	}

	public void imprimirMano() {
		//JOptionPane.showMessageDialog(null,manoJugador.get(j).getCara1()+"|"+manoJugador.get(j).getCara2()+"\n"
		//+ "///\n" + manoComputador.get(j).getCara1()+"|"+manoComputador.get(j).getCara2());
		for(int j = 0; j <  manoJugador.size(); j++) {
			System.out.print(manoJugador.get(j).getCara1());
			System.out.print("|");
			System.out.println(manoJugador.get(j).getCara2());
		}
		
		System.out.println ("///");
		
		for(int j = 0; j <  manoComputador.size(); j++) {
			System.out.print(manoComputador.get(j).getCara1());
			System.out.print("|");
			System.out.println(manoComputador.get(j).getCara2());
			
		}
		System.out.println("          ");
	}
	
	public int fichasMesa() {
		return fichasDelJuego.size();
	}
	
	public void verificarFicha(int pos) {
		
		if((manoJugador.get(pos) == manoJugador.get(pos-1)) &  (pos - 1 <= 0)) {
			manoJugador.set(pos-1, this.dameUnaFicha());
			verificarFicha(pos);
		}
		if((manoJugador.get(pos) == manoComputador.get(pos)) &  (pos - 1 <= 0)) {
			manoComputador.set(pos, this.dameUnaFicha());
			verificarFicha(pos);
		}
		if((manoComputador.get(pos) == manoComputador.get(pos-1)) &  (pos - 1 <= 0)) {
			manoComputador.set(pos-1, this.dameUnaFicha());
			verificarFicha(pos);
		}
		
		
	}

	public void verificarFichasJugador(int pos) {
		
		for(int i = 6; i < 0; i--) {
			if(manoJugador.get(pos) == manoJugador.get(pos-1)) {
				manoJugador.set(pos-1, this.dameUnaFicha());
			}
		}
		
		int aux2 = 6;
		for(int aux = aux2; aux < 0; aux--) {
			if(manoJugador.get(aux) == manoJugador.get(aux-1)) {
				manoJugador.set(pos-1, this.dameUnaFicha());
				
			}
		aux2--;
		verificarFichasJugador(pos);
		}
	}
	
	public int ponerFichaJugador(JLabel ficha) {
		fichaActiva = GUIPrincipal.getFichaActiva();
		int cara1 = fichaActiva.getIcon().toString().charAt(13) - 48;
		int cara2 = fichaActiva.getIcon().toString().charAt(15) - 48;

		boolean same = false;


        if ( cara1 ==  cara2){
            same=true;

        }
        if (conteo != 0){

		    if (same && cara1 ==  getFichasPanelJuego().get(0).getIcon().toString().charAt(13) - 48 ){
                JOptionPane.showMessageDialog(null, "Rotar 90 añadir a la izquierda");
            }
		    else if (same && cara1 ==  getFichasPanelJuego().get(0).getIcon().toString().charAt(15) - 48 ){
                JOptionPane.showMessageDialog(null, "Rotar 90 añadir a la derecha");
            }
			else if (cara1 == getFichasPanelJuego().get(0).getIcon().toString().charAt(13) - 48 ){
				//   //Añadir al panel Dejar igual
                //                JOptionPane.showMessageDialog(null, "Añadir al panel Dejar igual");
				JOptionPane.showMessageDialog(null, "Rotar 180 añadir a la izquierda");
				return 1;
			}
			else if (cara2 == getFichasPanelJuego().get(0).getIcon().toString().charAt(13) - 48 ){
			    //No rotación pero añadir a la izquierda
                JOptionPane.showMessageDialog(null, "No rotación pero añadir a la izquierda");
				return 2;
			}
			else if (cara1 == getFichasPanelJuego().get(fichasPanelJuego.size() -1 ).getIcon().toString().charAt(15) - 48 ){
                //Añadir al panel Dejar igual
                JOptionPane.showMessageDialog(null, "Añadir al panel Dejar igual");
				return 3;
			}
			else if (cara2 == getFichasPanelJuego().get(fichasPanelJuego.size() -1 ).getIcon().toString().charAt(15) - 48 ){
                //Rotan 180 dejar igual
                JOptionPane.showMessageDialog(null, "Rotan 180 dejar igual");
				return 4;
			}


		}
		else if (conteo == 0){
			fichasPanelJuego.add(fichaActiva);
			return -1;
		}

/*
		if (cara1 == getFichasPanelJuego().get(0).getCara1() || cara2 == manoJugador.get(0).getCara2() & conteo != 0){
			return true;
		}
		else if (cara1 == manoJugador.get(1).getCara1() || cara2 == manoJugador.get(1).getCara2() & conteo != 0){
			return true;
		}
		else if (conteo == 0){
			setFichasPanelJuego(ficha);
			return true;
		}
		else{
			return false;
		}*/

	//	JOptionPane.showMessageDialog(null,cara1 + "|" + cara2);


		return -100;
	}
	
	public JLabel ponerFichaPc(JLabel ficha) {
		fichaActivaPc = GUIPrincipal.getFichaActiva();
		return fichaActivaPc;
		
	}
	
	public int fichaAdecuada() {
		for(int i = 0; i > manoComputador.size(); i++) {
			if(manoComputador.get(i).getCara1() == fichaActiva.getIcon().toString().charAt(13) - 48
					|| manoComputador.get(i).getCara2() == fichaActiva.getIcon().toString().charAt(15) - 48) 
			{
				this.fichaCorrecta = i;
				System.out.println(i);
			}
		}
		return fichaCorrecta;
		
		
	}
	
	
	public void removeFicha(ArrayList<Fichas> quien, JLabel cualFicha) {
		for(int i=0; i < quien.size(); i++) {
			
			if(cualFicha.getIcon().toString().equals(quien.get(i).getImagenDomino().toString())){
				quien.remove(i);
				
			}
		}
	}


	public ArrayList<JLabel> getFichasPanelJuego() {
		return fichasPanelJuego;
	}

	public void setFichasPanelJuego(JLabel fichaLabel) {
		fichasPanelJuego.add(0, fichaLabel);
	}
}

