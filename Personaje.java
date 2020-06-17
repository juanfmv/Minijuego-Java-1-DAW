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
	* Método que devuelve la coordenada x del personaje
	* @return x
	*/
	public int CoordX() {
		return this.x;
	}
	
	/**
	* Método que devuelve la coordenada y del personaje
	* @return y
	*/
	public int CoordY() {
		return this.y;
	}
	
	/**
	* Método que devuelve la direccion del personaje
	* @return direccion
	*/
	public String getDireccion() {
		return this.Direccion;
	}
	
	/**
	* Método que modifica la direccion del personaje
	* @param direccion
	*/
	public void setDireccion(String Direccion){
		this.Direccion = Direccion;
	}
	
	/**
	* Método que modifica la coordenada x del personaje
	* @param x
	*/
	public void setCoordX(int x) {
		this.x = x;
	}
	
	/**
	* Método que modifica la coordenada y del personaje
	* @param y
	*/
	public void setCoordY(int y) {
		this.y = y;
	}
	
	/**
	* Método que devuelve el JPanel del personaje
	* @return MiJP
	*/
	public JPanel getPanel() {
		return this.MiJP;
	}	
}
