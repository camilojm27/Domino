/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.shuffle;

/**
 *
 * @author invitado
 */
public class ControlUnit extends ArrayList{
    private boolean tapa = false;

	private ArrayList<Fichas> fichasDelJuego = new ArrayList<Fichas>();

	Fichas ficha00 = new Fichas(0,0,  tapa); Fichas ficha11 = new Fichas(1,1,  tapa); Fichas ficha22 = new Fichas(2,2,  tapa); Fichas ficha33 = new Fichas(3,3,  tapa); Fichas ficha44 = new Fichas(4,4,  tapa); Fichas ficha55 = new Fichas(5,5,  tapa); Fichas ficha66 = new Fichas(6,6,  tapa);
	Fichas ficha01 = new Fichas(0,1,  tapa); Fichas ficha12 = new Fichas(1,2,  tapa); Fichas ficha23 = new Fichas(2,3,  tapa); Fichas ficha34 = new Fichas(3,4,  tapa); Fichas ficha45 = new Fichas(4,5,  tapa); Fichas ficha56 = new Fichas(5,6,  tapa);
	Fichas ficha02 = new Fichas(0,2,  tapa); Fichas ficha13 = new Fichas(1,3,  tapa); Fichas ficha24 = new Fichas(2,4,  tapa); Fichas ficha35 = new Fichas(3,5,  tapa); Fichas ficha46 = new Fichas(4,6,  tapa);
	Fichas ficha03 = new Fichas(0,3,  tapa); Fichas ficha14 = new Fichas(1,4,  tapa); Fichas ficha25 = new Fichas(2,5,  tapa); Fichas ficha36 = new Fichas(3,6,  tapa);
	Fichas ficha04 = new Fichas(0,4,  tapa); Fichas ficha15 = new Fichas(1,5,  tapa); Fichas ficha26 = new Fichas(2,6,  tapa);
	Fichas ficha05 = new Fichas(0,5,  tapa); Fichas ficha16 = new Fichas(1,6,  tapa);
	Fichas ficha06 = new Fichas(0,6,  tapa);

	public ControlUnit() {
		fichasDelJuego.add(ficha00); fichasDelJuego.add(ficha01); fichasDelJuego.add(ficha02); fichasDelJuego.add(ficha03); fichasDelJuego.add(ficha04); fichasDelJuego.add(ficha05); fichasDelJuego.add(ficha06);
		fichasDelJuego.add(ficha11); fichasDelJuego.add(ficha12); fichasDelJuego.add(ficha13); fichasDelJuego.add(ficha14); fichasDelJuego.add(ficha15); fichasDelJuego.add(ficha16);
		fichasDelJuego.add(ficha22); fichasDelJuego.add(ficha23); fichasDelJuego.add(ficha24); fichasDelJuego.add(ficha25); fichasDelJuego.add(ficha26);
		fichasDelJuego.add(ficha33); fichasDelJuego.add(ficha34); fichasDelJuego.add(ficha35); fichasDelJuego.add(ficha36);
		fichasDelJuego.add(ficha44); fichasDelJuego.add(ficha45); fichasDelJuego.add(ficha46);
		fichasDelJuego.add(ficha55); fichasDelJuego.add(ficha56);
		fichasDelJuego.add(ficha66);
	}

	Fichas fichaPedida;

	Random r = new Random();
	int cualFicha;
	public ArrayList<Fichas> getManoJugador() {
		return manoJugador;
	}

	public ArrayList<Fichas> getRandomFichaDelJuego() {
		ArrayList<Fichas> aux = fichasDelJuego;
		Collections.shuffle(aux);
		return aux;
	}

	private ArrayList<Fichas> manoJugador = new ArrayList<Fichas>();

	public ArrayList<Fichas> getManoComputador() {
		return manoComputador;
	}

	private ArrayList<Fichas> manoComputador = new ArrayList<Fichas>();


	public Fichas dameUnaFicha() {

		cualFicha = r.nextInt(28);
		fichaPedida = fichasDelJuego.get(cualFicha);
		return fichaPedida;
	}

	public void imprimirFicha() {

		/*
		System.out.print(dameUnaFicha().cara1);
		System.out.print("|");
		System.out.println(dameUnaFicha().cara2);
		*/
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

		manoJugador.add(this.dameUnaFicha());
		manoJugador.add(this.dameUnaFicha());
		manoJugador.add(this.dameUnaFicha());
		manoJugador.add(this.dameUnaFicha());
		manoJugador.add(this.dameUnaFicha());
		manoJugador.add(this.dameUnaFicha());


	}

	public void imprimirMano() {
		int contador = 0;
		do {
			this.imprimirFicha();
			contador++;
			}
		while(contador >=6);



		//this.imprimirFicha();

	}







}

