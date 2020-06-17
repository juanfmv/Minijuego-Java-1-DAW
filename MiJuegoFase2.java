package juego;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;
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

public class MiJuegoFase2 extends JFrame {
	
	/** Componentes de la ventana */
	private JPanel contentPane;	
	Timer reloj;						//Timer del juego
	Link player;						//Objeto de player
	Broncas broncas1, broncas2;			//Objetos de broncas
	Topo topo1, topo2;					//Objetos de topo
	Ghost ghost;						//Objeto de ghost
	Vida vida;							//Objeto de vida
	Escudo escudo;						//Objeto de escudo
	Arma arma;							//Objeto de arma
	JLabel mensajeSalud;				//Mensaje de salud
	JLabel mensajeEscudo;				//Mensaje de escudo
	JLabel mensajeArma;					//Mensaje de arma
	JLabel mensajeEnemigos;				//Mensaje de enemigos en pantalla
	int contaEnemigos = 5;				//N�mero de enemigos (si llega a 0 se acaba el nivel)
	int contTiempo;

	/**
	 * Constructor
	 */
	public MiJuegoFase2(Clip sonido) {
		setResizable(false);
		setTitle("Mini Juego Fase 2/2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		
		//Creaci�n del jugador
		player = new Link(panel, 100, 0, 0);
		
		//Creaci�n de los enemigos
		broncas1 = new Broncas(panel,500,150);
		broncas2 = new Broncas(panel,140,350);
		topo1 = new Topo(panel,400,80);
		topo2 = new Topo(panel,200,400);
		ghost = new Ghost(panel,300,300);
		
		//Creaci�n de los objetos del mapa
		vida = new Vida(panel,100,400);
		escudo = new Escudo(panel,450,100);
		arma = new Arma(panel,350,350);
		
		//A�adimos el fondo de pantalla
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MiJuegoFase2.class.getResource("/juego/imagenes/FondoCueva.jpg")));
		panel.add(lblNewLabel_3);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		//Establecemos los mensajes en pantalla
		mensajeSalud = new JLabel("Salud: "+player.getSalud());	
		mensajeEscudo = new JLabel("Escudo: "+player.getEscudo());
		mensajeArma = new JLabel("Arma: "+player.getArma());	
		mensajeEnemigos = new JLabel("Enemigos: "+contaEnemigos);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(mensajeSalud)
							.addComponent(mensajeEscudo, Alignment.TRAILING))
						.addComponent(mensajeArma, Alignment.TRAILING))
					.addGap(17))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(mensajeEnemigos)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(mensajeSalud)
					.addGap(11)
					.addComponent(mensajeEscudo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mensajeArma)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mensajeEnemigos)
					.addContainerGap(421, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		addKeyListener(new KeyAdapter() {
			
		/**
		 * M�todo que establece las acciones al pulsar distintas teclas	
		 */			
			@Override
			public void keyPressed(KeyEvent e) {
				//Muestra en consola las coordenadas del jugador
				System.out.println("x --> "+player.CoordX()+", y --> "+player.CoordY());
				//System.out.println(panel.getWidth());
				//System.out.println(panel.getHeight());
					
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					if (player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/Izquierda.png");
						if (player.getArma() == 1) {
							player.setDireccion("src/juego/imagenes/IzquierdaconArma.png");
						}
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					//Le restamos 200 a la condici�n de movimiento para evitar que el personaje desaparezca debido
					//a la anchura del escenario
					if(player.CoordX()<(panel.getWidth()-100)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/Derecha.png");
						if (player.getArma() == 1) {
							player.setDireccion("src/juego/imagenes/DerechaconArma.png");
						}
					}				
					break;
					
				case KeyEvent.VK_UP:
					if (player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");
						if (player.getArma() == 1) {
							player.setDireccion("src/juego/imagenes/ArribaconArma.png");
						}
					}
					break;
					
				case KeyEvent.VK_DOWN:
					//Le restamos 200 a la condici�n de movimiento para evitar que el personaje desaparezca debido
					//a la anchura del escenario
					if(player.CoordY()<(panel.getWidth()-200)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");
						if (player.getArma() == 1) {
							player.setDireccion("src/juego/imagenes/AbajoconArma.png");
						}
					}	
					break;
				}
			}
		});
		
		/*****************************************************************************/
		//Parte del codigo que cada 100 milisegundo movera a los enemigos		
		reloj = new Timer(100, new ActionListener(){	

			/**
			 * M�todo que establece los objetos en pantalla
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				contTiempo = (contTiempo + reloj.getDelay())%5000;
				//Actualizamos las posiciones de los personajes
				player.getPanel().update(panel.getGraphics());
				broncas1.getPanel().update(panel.getGraphics());	
				broncas2.getPanel().update(panel.getGraphics());	
				topo1.getPanel().update(panel.getGraphics());
				topo2.getPanel().update(panel.getGraphics());	
				ghost.getPanel().update(panel.getGraphics());
					
				//Actualizamos al personaje player
				ImageIcon MiImagen = new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);
				
				//Actualizamos al personaje Broncas
				broncas1.movimientoBroncas();
				ImageIcon ImagenBroncas = new ImageIcon(broncas1.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas1.CoordX(), broncas1.CoordY(), panel);
				
				broncas2.movimientoBroncas();
				ImageIcon ImagenBroncas2 = new ImageIcon(broncas2.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas2.getImage(), broncas2.CoordX(), broncas2.CoordY(), panel);
				
				//Actualizamos al personaje Topo
				topo1.movimientoTopo();
				ImageIcon ImagenTopo = new ImageIcon(topo1.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topo1.CoordX(), topo1.CoordY(), panel);
				
				topo2.movimientoTopo();
				ImageIcon ImagenTopo2 = new ImageIcon(topo2.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo2.getImage(), topo2.CoordX(), topo2.CoordY(), panel);
				
				
				//Actualizamos al personaje Fantasma
				if (contTiempo==0) {
					ghost.setVisible();
					Random r = new Random();
					int valorX = r.nextInt(650);
					int valorY = r.nextInt(460);
					ghost.setCoordX(valorX);
					ghost.setCoordY(valorY);
				}
							
				//A�adimos la posicion de Vida
				vida.posicionVida();
				ImageIcon ImagenVida = new ImageIcon(vida.getPosicion());
				panel.getGraphics().drawImage(ImagenVida.getImage(), vida.CoordX(), vida.CoordY(), panel);
				
				//A�adimos la posicion de Arma
				arma.posicionArma();
				ImageIcon ImagenArma = new ImageIcon(arma.getPosicion());
				panel.getGraphics().drawImage(ImagenArma.getImage(), arma.CoordX(), arma.CoordY(), panel);
				
				//A�adimos la posicion de Escudo
				escudo.posicionEscudo();
				ImageIcon ImagenEscudo = new ImageIcon(escudo.getPosicion());
				panel.getGraphics().drawImage(ImagenEscudo.getImage(), escudo.CoordX(), escudo.CoordY(), panel);
				
				//Linea para evitar parpadeos
				panel.getGraphics().drawImage(null, 10, 80, null);		
				
				/*********************** Comienzo de colisiones *****************************************/				
				//Colisi�n con los personajes
				colisionesEnemigos(broncas1);
				colisionesEnemigos(topo1);
				colisionesEnemigos(broncas2);
				colisionesEnemigos(topo2);
				if (ghost.getVisible()==1) {
					ghost.movimientoFantasma();						
					ImageIcon ImagenFantasma = new ImageIcon(ghost.getDireccion());					
					panel.getGraphics().drawImage(ImagenFantasma.getImage(), ghost.CoordX(),ghost.CoordY(), panel);
					colisionesEnemigos(ghost);
				}
				//Colisi�n con los objetos
				colisionesCosas(vida);
				colisionesCosas(escudo);
				colisionesCosas(arma);
				/****************************************************************/
				
				//Si todos los enemigos desaparecen, se acaba el juego
				if (contaEnemigos == 0) {
					//Detenemos el reloj y la m�sica
					reloj.stop();
					sonido.stop();
					JOptionPane.showMessageDialog(null, "�Enhorabuena! Has ganado la partida.","Fin del juego",JOptionPane.PLAIN_MESSAGE);
					//Cerramos la ventana actual y abrimos la ventana de inicio
					dispose();
					Principal inicio = new Principal();
					inicio.setVisible(true);
				}
				
				//Si el jugador pierde toda la vida, se acaba el juego
				if(player.getSalud() <= 0) {
					//Detenemos el reloj y la m�sica
					reloj.stop();
					sonido.stop();
					JOptionPane.showMessageDialog(null, "�Has perdido! Intentalo de nuevo.","Fin del juego",JOptionPane.PLAIN_MESSAGE);
					//Cerramos la ventana actual y abrimos la ventana de inicio
					dispose();
					Principal inicio = new Principal();
					inicio.setVisible(true);
				}
				
			}
			/**
			 * M�todo que recibe un objeto que representa una cosa/objeto (vida, escudo o arma) y se activa 
			 * cuando el jugador y un objeto colisionan.
			 * Modifica los par�metros del jugador dependiendo de qu� objeto ha cogido en la pantalla.
			 * @param p Objeto de Cosas
			 */
			private void colisionesCosas(Cosas c) {
				int hiddenBox = 70;		//Variable creada para regular el tama�o de la caja oculta
				if ((player.CoordX() >= c.CoordX()-hiddenBox && player.CoordX() <= c.CoordX()+hiddenBox) && 
						((player.CoordY() >= c.CoordY()-hiddenBox && player.CoordY() <= c.CoordY()+hiddenBox))) {
					
					if (c == vida) {
						System.out.println("�Player ha conseguido salud extra!");
						//El jugador aumenta la cantidad de salud en +50 y el objeto desaparece
						player.setSalud(player.getSalud()+50);
						vida.setCoordX(-255);
						vida.setCoordY(-255);
						mensajeSalud.setText("Salud: "+player.getSalud());	
						
					}else if(c == escudo) {
						System.out.println("�Player ha conseguido un escudo!");
						//El jugador aumenta la cantidad de escudo (que act�a como una segunda capa de salud) en +50 y el objeto desaparece
						player.setEscudo(player.getEscudo()+50);					
						escudo.setCoordX(-255);
						escudo.setCoordY(-255);
						mensajeEscudo.setText("Escudo: "+player.getEscudo());
						
					}else if(c == arma) {
						System.out.println("�Player ha conseguido un arma!");
						//El jugador aumenta la cantidad de arma y el objeto desaparece
						player.setArma(player.getArma()+1);
						arma.setCoordX(-255);
						arma.setCoordY(-255);
						mensajeArma.setText("Arma: "+player.getArma());		
					}				
				}
			}
			
			/**
			 * M�todo que recibe un objeto que representa un enemigo y se activa cuando el jugador y un enemigo colisionan.
			 * Modifica los par�metros del jugador o las coordenadas del enemigo dependiendo de si el jugador ha recogido un arma o no.
			 * @param p Objeto de Personaje
			 */
			private void colisionesEnemigos(Personaje p) {
				int hiddenBox = 70;		//Variable creada para regular el tama�o de la caja oculta
				if ((player.CoordX() >= p.CoordX()-hiddenBox && player.CoordX() <= p.CoordX()+hiddenBox) && 
						((player.CoordY() >= p.CoordY()-hiddenBox && player.CoordY() <= p.CoordY()+hiddenBox))) {
					
					if (p == broncas1 || p == broncas2) {
						System.out.println("�Player est� tocando a broncas!");
					}else if(p == topo1 || p == topo2) {
						System.out.println("�Player est� tocando a topo!");
					}else if (p == ghost) {
						System.out.println("�Player est� tocando a ghost!");
					}
						
					//Si el jugador tiene un arma, el enemigo desaparece
					 if (player.getArma() == 1){
						 //Cambiamos las coordenadas para que el enemigo salga de la pantalla y reducimos el contador de enemigos
						 p.setCoordX(-255);
						 p.setCoordY(-255);
						 contaEnemigos--;
						 mensajeEnemigos.setText("Enemigos: "+contaEnemigos);
						 //Si el enemigo es ghost, modificamos contTiempo para que no vuelva a aparecer
						 if (p == ghost) {
							 contTiempo = 1;
						 }
					 }else {
						 //Si el jugador no tiene un arma, perder� escudo, o vida si no tiene escudo
						 if (player.getEscudo() <= 0) {
								player.setSalud(player.getSalud()-2);
								mensajeSalud.setText("Salud: "+player.getSalud());
							}else {
								player.setEscudo(player.getEscudo()-2);
								mensajeEscudo.setText("Escudo: "+player.getEscudo());
							}
					}					
				}
			}
		}		
		);
		reloj.start();
	}	
}