package uniandes.dpoo.taller4.modelo.Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uniandes.dpoo.taller4.modelo.Modelo.Tablero;

@SuppressWarnings("serial")
public class VentanaLuces extends JFrame
{
	/**
	 * La cantidad de tarjetas en el tablero a lo ancho y a lo alto
	 */
	private static final int TAMANO = 4;

	/**
	 * El ancho y alto en pixeles de una tarjeta
	 */
	public static final int TAM_TARJETA = 100;

	/**
	 * El mundo de la aplicación
	 */
	private Tablero modelo;

	/**
	 * El panel donde se muestran las tarjetas
	 */
	private PanelLuces pLuces;

	/**
	 * Construye e inicializa una nueva ventana para el juego
	 */
	public VentanaLuces()
	{
		modelo = new Tablero(TAMANO);

		pLuces = new PanelLuces(this, TAMANO);
		add(pLuces);

		pack();
		setTitle("Lights Out!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Centrar la ventana en la pantalla
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Realiza una jugada en una posición.
	 * 
	 * Si el juego termina, le avisa al usuario y le da la posibilidad de volver a
	 * empezar
	 * 
	 * @param fila    La fila para la jugada
	 * @param columna La columna para la jugada
	 */
	public void jugar(int fila, int columna)
	{
		boolean finJuego = modelo.tableroIluminado();
		pLuces.actualizar(modelo.darTablero());

		if (finJuego)
		{
			int jugadas = modelo.darJugadas();

			JOptionPane.showMessageDialog(this, "¡Ganaste en " + jugadas + " jugadas!", "Fin del juego",
					JOptionPane.INFORMATION_MESSAGE);
			int reiniciar = JOptionPane.showConfirmDialog(this, "¿Quieres iniciar un nuevo juego?", "Reiniciar",
					JOptionPane.YES_NO_OPTION);

			if (reiniciar == JOptionPane.YES_OPTION)
			{
				modelo.reiniciarTablero();
				pTarjetas.actualizar(modelo.darTablero());
			}
		}
	}

	/**
	 * Empieza la ejecución de la aplicación
	 * 
	 * @param args
	 */

}
