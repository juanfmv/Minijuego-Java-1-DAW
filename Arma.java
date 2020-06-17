package juego;

import javax.swing.JPanel;

public class Arma extends Cosas {
	/**
	 * Constructor
	 */
	Arma(JPanel MiJ, int x, int y) {
		super(MiJ);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Método que muestra la imagen del arma
	 */
	public void posicionArma() {
		this.setPosicion("src/juego/imagenes/Arma.png");
	}
}
