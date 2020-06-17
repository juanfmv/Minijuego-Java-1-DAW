package juego;
import javax.swing.JPanel;


public class Cosas {
	//Atributos
	protected int x;
	protected int y;
	private String Posicion;
	private JPanel MiJP;
	/**
	 * Constructor
	 */
	Cosas(JPanel MiJ){
		this.x = 0;
		this.y = 0;
		this.MiJP = MiJ;
	}
	
	/**
	* M�todo que devuelve la coordenada x del objeto
	* @return x
	*/	
	public int CoordX() {
		return this.x;
	}
	
	/**
	* M�todo que devuelve la coordenada y del objeto
	* @return y
	*/
	public int CoordY() {
		return this.y;
	}
	
	/**
	* M�todo que modifica la coordenada x del objeto
	* @param x
	*/		
	public void setCoordX(int x) {
		this.x = x;
	}
	
	/**
	* M�todo que modifica la coordenada y del objeto
	* @param y
	*/
	public void setCoordY(int y) {
		this.y = y;
	}
	
	/**
	* M�todo que devuelve el JPanel del objeto
	* @return MiJP
	*/
	public JPanel getPanel() {
		return this.MiJP;
	}
	
	/**
	* M�todo que devuelve la posicion del objeto
	* @return posicion
	*/
	public String getPosicion() {
		return this.Posicion;
	}
	
	/**
	* M�todo que modifica la posicion del objeto
	* @return posicion
	*/
	public void setPosicion(String Posicion){
		this.Posicion = Posicion;
	}
	
}