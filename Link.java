package juego;
import javax.swing.JPanel;

public class Link extends Personaje {
	//Atributos
	private int salud;
	private int escudo;
	private int arma;
	
	/**
	 * Constructor
	 */
	Link(JPanel MiJ, int s, int e, int a){
		super(MiJ); //Primero llamamos al constructor padre
		this.salud = s;
		this.escudo = e;
		this.arma = a;
	}
	
	/**
	* Devuelve el valor de salud del jugador
	* @return salud
	*/
	public int getSalud() {
		return salud;
	}
	
	/**
	* Modifica el valor de salud del jugador
	* @param s
	*/
	public void setSalud(int s) {
		this.salud = s;
	}
	
	/**
	* Devuelve el valor de escudo del jugador
	* @return escudo
	*/
	public int getEscudo() {
		return escudo;
	}
	
	/**
	* Modifica el valor de escudo del jugador
	* @param e
	*/
	public void setEscudo(int e) {
		this.escudo = e;
	}
	
	/**
	* Devuelve el valor de arma del jugador
	* @return arma
	*/
	public int getArma() {
		return arma;
	}
	
	/**
	* Modifica el valor de arma del jugador
	* @param a
	*/
	public void setArma(int a) {
		this.arma = a;
	}
}
