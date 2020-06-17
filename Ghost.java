package juego;

import javax.swing.JPanel;

public class Ghost extends Personaje {
	private String sentido;
	private int visible;	//0 ser� invisible y 1 visible.
	/**
	 * Constructor
	 */
	Ghost(JPanel MiJ, int x, int y){
		super(MiJ);	//Primero llamamos al constructor padre
		this.x=x;
		this.y=y;
		this.sentido="ESTE";
		visible=0;
		this.setDireccion("src/juego/imagenes/Fantasma.png");
	}
	
	/**
	 * M�todo que indica la imagen del fantasma
	 */
	public void movimientoFantasma() {
		this.setDireccion("src/juego/imagenes/Fantasma.png");
	}
	
	/**
	 * M�todo que devuelve el sentido del fantasma
	 * @return sentido
	 */
	public String getSentido() {
		return sentido;
	}

	/**
	 * M�todo que modifica el sentido del fantasma
	 * @param sentido
	 */
	public void setSentido(String sentido) {
		this.sentido = sentido;
	} 

	/**
	 * M�todo que devuelve el valor visible del fantasma
	 * @param visible
	 */
	public int getVisible() {
		return visible;
	}
	/**
	 * M�todo que modifica el valor visible del fantasma
	 */
	public void setVisible() {
		if (visible==0) {
			visible=1;
		}
		else {
			visible=0;
		}
	} 
}
