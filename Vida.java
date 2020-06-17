package juego;

import javax.swing.JPanel;

public class Vida extends Cosas {
	/**
	 * Constructor
	 */
	Vida(JPanel MiJ, int x, int y) {
		super(MiJ);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Método que muestra la imagen de la vida
	 */
	public void posicionVida() {
		this.setPosicion("src/juego/imagenes/Vida.png");
	}
}
