package juego;
import javax.swing.JPanel;


public class Personaje {
	//Atributos
	protected int x;
	protected int y;
	private String Direccion;
	private JPanel MiJP;
	/**
	 * Constructor
	 */
	Personaje(JPanel MiJ){
		this.x = 0;
		this.y = 0;
		this.MiJP = MiJ;
	}
	
	/**
	* M�todo que devuelve la coordenada x del personaje
	* @return x
	*/
	public int CoordX() {
		return this.x;
	}
	
	/**
	* M�todo que devuelve la coordenada y del personaje
	* @return y
	*/
	public int CoordY() {
		return this.y;
	}
	
	/**
	* M�todo que devuelve la direccion del personaje
	* @return direccion
	*/
	public String getDireccion() {
		return this.Direccion;
	}
	
	/**
	* M�todo que modifica la direccion del personaje
	* @param direccion
	*/
	public void setDireccion(String Direccion){
		this.Direccion = Direccion;
	}
	
	/**
	* M�todo que modifica la coordenada x del personaje
	* @param x
	*/
	public void setCoordX(int x) {
		this.x = x;
	}
	
	/**
	* M�todo que modifica la coordenada y del personaje
	* @param y
	*/
	public void setCoordY(int y) {
		this.y = y;
	}
	
	/**
	* M�todo que devuelve el JPanel del personaje
	* @return MiJP
	*/
	public JPanel getPanel() {
		return this.MiJP;
	}	
}
