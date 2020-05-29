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

	public int getSalud() {
		return salud;
	}

	public void setSalud(int s) {
		this.salud = s;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int e) {
		this.escudo = e;
	}

	public int getArma() {
		return arma;
	}

	public void setArma(int a) {
		this.arma = a;
	}
	
	
}
