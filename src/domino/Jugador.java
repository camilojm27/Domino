/*
 * @Autores: Santiago Martinez Mesa - 1823107
 * 			 Camilo Mezu Mina -	1824313
 */
package domino;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Jugador.
 */
public class Jugador {
	
	/** The lector. */
	Scanner lector = new Scanner(System.in);
	
	/** The dinero. */
	private int dinero = 50000;
	
	/** The apuesta. */
	private int apuesta = 0;
	
	private String userName;
	private String nombre;
	
	/** The plantarse. */
	private boolean plantarse;
	
	/** The apuesta valida. */
	boolean apuestaValida = false;

	
	/**
	 * Plantarse.
	 *
	 * @return true, if successful
	 */
	boolean plantarse() {

		boolean estoyPlantado = true;
		return estoyPlantado;
	}
	
	/**
	 * Realizar apuesta.
	 */
	public void realizarApuesta() {
		System.out.println("Bienvenido, tienes " + Integer.toString(dinero) + " , para entrar al juego debes poner entre 3000$ y 50000$");
		System.out.print("Tu apuesta sera de: ");
		apuesta = lector.nextInt();
		if(apuesta < 3000 || apuesta > 50000) {
			System.out.println("Realiza una apuesta valida");
			realizarApuesta();
		} else 
		apuestaValida = true;
		dinero = dinero - apuesta;
		
	}
	
	/**
	 * Ganar.
	 */
	public void ganar() {
		dinero = dinero + (apuesta*2);
	}
	
	public String ingresarUsername() {
		nombre = lector.next();
		return userName;
	}

}
