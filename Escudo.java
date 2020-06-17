package juego;

import javax.swing.JPanel;

public class Escudo extends Cosas {
	/**
	 * Constructor
	 */
	Escudo(JPanel MiJ, int x, int y) {
		super(MiJ);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Método que muestra la imagen del escudo
	 */
	public void posicionEscudo() {
		this.setPosicion("src/juego/imagenes/Escudo.png");
	}
}
