package aplicacion;

import javax.swing.JOptionPane;
import dominio.CircularQueue;
import dominio.QueueUnlimited;
import estructuras.Queue;

/**
 * Clase Aplicacion que ejecuta el metodo main brindando una interfaz grafica
 * simple para que el usuario pueda manipular una cola.
 * 
 * @author Isar Ramses Cadena Gaona
 * @version v1.0_20/10/2016
 */
public class AplicacionQueue {
	public static void main(String[] args) {
		// Creando el objeto QueueUnlimited.
		Queue cola;
		// Declarando un arreglo de String que contiene las dos posibles
		// opciones sobre que tipo de cola utilzar.
		String[] colas = { "Cola", "Cola circular" };
		// Variable por medio de la cual el usuario determina si usara una cola
		// o una cola circular.
		int tipoQueue = 0;
		// Declarando un arreglo de String que será el menú de opciones para el
		// usuario.
		String[] menu = { "Insertar", "Extraer", "Verificar si la cola está vacia", "Revisar si la cola está llena",
				"Salir" };
		// Cadena "eleccion" que contendra la opción del menú elegida por el
		// usuario.
		String eleccion;

		// Ventana donde el usuario elige que tipo de cola utilizar.
		tipoQueue = JOptionPane.showOptionDialog(null, "Si no seleciona ninguna se usará una cola circular",
				"Seleccione un tipo de cola a usar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				colas, colas[0]);
		// Se crea una cola dependiendo de la que eligió el usuario
		if (tipoQueue == 0) {
			cola = new QueueUnlimited();
		} else {
			cola = new CircularQueue();
		}

		try {
			// Ciclo do que permite que las opciones se muestren por un numero
			// de veces indefinido mientras no se seleccione la opción "Salir" o
			// se haga click sobre Cancelar.
			do {
				// Ventana con cuadro de dialogo donde el usuario puede elegir
				// una acción entre las 5 ofrecidas.
				eleccion = (String) JOptionPane.showInputDialog(null, "¿Que desea hacer?", "Opciones para el usuario",
						JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
				// Switch que admnistra las opciones tomadas por el usuario.
				switch (eleccion) {
				case "Insertar":
					if (!cola.isFull()) {
						cola.insert(JOptionPane.showInputDialog("Digite el elemento que desea insertar"));
					} else {
						JOptionPane.showMessageDialog(null,
								"La cola ya está llena, no se pueden insertar mas objetos.");
					}
					break;
				case "Extraer":
					if (!cola.isEmpty()) {
						JOptionPane.showMessageDialog(null, "El elemnto extraido es: " + cola.extract());
					} else {
						JOptionPane.showMessageDialog(null, "La cola ya está vacia.");
					}
					break;
				case "Verificar si la cola está vacia":
					String vacia = "SI";
					if (!cola.isEmpty())
						vacia = "NO";
					JOptionPane.showMessageDialog(null, "La cola " + vacia + " está vacia.");
					break;
				case "Revisar si la cola está llena":
					String llena = "SI";
					if (!cola.isFull())
						llena = "NO";
					JOptionPane.showMessageDialog(null, "La cola " + llena + " está llena.");
					break;
				}
			} while (!eleccion.equals("Salir"));
		} catch (Exception e) {
			// Se termina la ejecucion.
		} // catch
	}// main
}// Class