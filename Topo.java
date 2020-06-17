package juego;
import javax.swing.JPanel;

public class Topo extends Personaje{
	
	//Atributos
	private String Sentido;
	
	/**
	 * Constructor
	 */
	Topo(JPanel MiJ, int x, int y) {
		super(MiJ); //Primero llamamos al constructor padre
		this.x = x;
		this.y = y;
		this.Sentido = "NORTE";
	}
	/**
	 * Método que modifica el movimiento y apariencia del topo
	 */
	public void movimientoTopo() {
		if(this.y<0) {
			this.Sentido="SUR";
			this.y=this.y+10;
			this.setDireccion("src/juego/imagenes/TopoAbajo.png");
		}
		
		//Le restamos 200 a la condicion de movimiento para evitar que el personaje desaparezca debido
		//a la anchura del escenario.
		else if(this.y>this.getPanel().getWidth()-200){
			this.Sentido="NORTE";
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/TopoArriba.png");
		}
		
		else if(this.Sentido.equals("SUR")){
			this.y=this.y+10;
			this.setDireccion("src/juego/imagenes/TopoAbajo.png");
		}
		
		else if(this.Sentido.equals("NORTE")){
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/TopoArriba.png");
		}
	}
}