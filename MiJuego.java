package juego;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

/*******************************************/
//Librerias para el tiempo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/*******************************************/

public class MiJuego extends JFrame {

	private JPanel contentPane;
	
	Link player; //Crearemos el objeto

	/**
	 * Create the frame.
	 */
	public MiJuego() {
		setResizable(false);
		setTitle("Mini Juego");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		
		//Creación del jugador
		player = new Link(panel, 100, 0, 0);
		
		//Creación de nuestro primer enemigo en la posición 
		//x=80 y=130 (se mueve horizontalmente)
		Broncas broncas = new Broncas(panel,80,130);
		//Creación de nuestro segundo enemigo en la posicion 
		//x=200 y=40 (se mueve verticamente)
		Topo topo = new Topo(panel,200,40);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/FondoPradera.jpg")));
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Salud: "+player.getSalud());	
		JLabel lblNewLabel_1 = new JLabel("Escudo: "+player.getEscudo());
		JLabel lblNewLabel_2 = new JLabel("Arma: "+player.getArma());
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1, Alignment.TRAILING))
						.addComponent(lblNewLabel_2, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		addKeyListener(new KeyAdapter() {
			
		/**
		 * Método que establece las acciones al pulsar distintas teclas	
		 */			
			@Override
			public void keyPressed(KeyEvent e) {

				System.out.println("x --> "+player.CoordX()+", y --> "+player.CoordY());
				System.out.println(panel.getWidth());
				System.out.println(panel.getHeight());
					
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					if (player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/Izquierda.png");
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					//Le restamos 200 a la condición de movimiento para evitar que el personaje desaparezca debido
					//a la anchura del escenario
					if(player.CoordX()<(panel.getWidth()-100)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/Derecha.png");
					}				
					break;
					
				case KeyEvent.VK_UP:
					if (player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");
					}
					break;
					
				case KeyEvent.VK_DOWN:
					//Le restamos 200 a la condición de movimiento para evitar que el personaje desaparezca debido
					//a la anchura del escenario
					if(player.CoordY()<(panel.getWidth()-200)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");
					}	
					break;
				}
			}
		});
		
		/*****************************************************************************/
		//Parte del codigo que cada 100 milisegundo movera a los enemigos
		Timer reloj = new Timer(100, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Actualizamos las posiciones de los personajes
				player.getPanel().update(panel.getGraphics());
				broncas.getPanel().update(panel.getGraphics());				
				topo.getPanel().update(panel.getGraphics());
					
				//Actualizamos al personaje player
				ImageIcon MiImagen = new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);
				
				//Actualizamos al personaje Broncas
				broncas.movimientoBroncas();
				ImageIcon ImagenBroncas = new ImageIcon(broncas.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
				
				//Actualizamos al personaje Topo
				topo.movimientoTopo();
				ImageIcon ImagenTopo = new ImageIcon(topo.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topo.CoordX(), topo.CoordY(), panel);
				
				//Linea para evitar parpadeos
				panel.getGraphics().drawImage(null, 10, 80, null);				
				
			}
		});
		reloj.start();
	}
}
