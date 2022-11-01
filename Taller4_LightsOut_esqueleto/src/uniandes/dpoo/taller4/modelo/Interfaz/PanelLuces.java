package uniandes.dpoo.taller4.modelo.Interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


@SuppressWarnings("serial")
public class PanelLuces extends JPanel implements MouseInputListener
{
	/**
	 * La imagen que se debe mostrar cuando la tarjeta está volteada
	 */
	private final ImageIcon fondo = cargarImagen("data/luz.png", VentanaLuces.TAM_TARJETA);

	/**
	 * Un mapa que sirve para no tener que cargar una y otra vez las mismas imágenes
	 */
	private static Map<String, ImageIcon> cacheImagenes = new HashMap<>();

	/**
	 * La matriz de botones donde se muestran las tarjetas
	 */
	private JButton[][] botones;

	/**
	 * La ventana que contiene a este padre
	 */
	private VentanaLuces padre;

	/**
	 * Construye un panel para mostrar el tablero de memory
	 * 
	 * @param padre La ventana que contiene al panel
	 * @param tam   El lado del cuadrado de tarjetas
	 */
	public PanelLuces(VentanaLuces padre, int tam)
	{
		this.padre = padre;

		setLayout(new GridLayout(tam, tam));
		

		for (int i = 0; i < tam; i++)
		{
			for (int j = 0; j < tam; j++)
			{
				botones[i][j] = new JButton(fondo);
				botones[i][j].setActionCommand("" + i + "_" + j);
				botones[i][j].addActionListener(this);
				add(botones[i][j]);
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
;

		}


	/**
	 * Actualiza el estado del tablero de juego que se le muestra al usuario
	 * 
	 * @param tablero El tablero de juego con las tarjetas que deben mostrarse
	 */
	public void repaint()
		
	{	boolean[][] luces =
		int tam = luces.length;
		for (int i = 0; i < tam; i++)
		{
			for (int j = 0; j < tam; j++)
			{
				boolean t = tablero[i][j];
				if (t)
				{
					ImageIcon imagenTarjeta = cacheImagenes.get(t.darImagen());
				}
				else
				{
					botones[i][j].setIcon(fondo);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		cantidades[casilla[0]][casilla[1]]++;
		principal.jugar(casilla[0], casilla[1]);
		this.ultima_fila = casilla[0];
		this.ultima_columna = casilla[1];
		repaint();
	}
	private int[] convertirCoordenadasACasilla(int x, int y) {
		int ladoTablero = tablero.length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}