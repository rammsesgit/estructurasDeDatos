package aplicacion;

import javax.swing.JOptionPane;
import estructuras.Queue;
import dominio.CircularQueue;

/**
 * @author Isar Ramses Cadena Gaona
 * @version 2.0_30/10/2016
 *
 *          Clase aplicación que brinda una interfaz grafica para que el usuario
 *          pueda interactuar con Colas circulares, haciendo uso de sus
 *          funciones básicas como lo son; insert, extract, isEmpty, isFull,
 *          front.
 */
public class AplicacionCircularQueue {
	public static void main(String[] args) {
		// Declaración y creación de la cola.
		Queue cola = new CircularQueue();
		// Arreglo de String que contiene las opciones del menú
		String[] opcionesDelMenu = { "Insertar", "Extraer", "Conocer el elemento del frente", "Saber si está llena",
				"Saber si está vacía", "Terminar" };
		// Cadena donde se almacena la opcion elegida por el usuario.
		String menu = "";

		// Ciclo do que se repite mientras no se elija "Terminar" en el menú.
		do {
			try {
				// Ventana que contiene el menú para el usuario.
				menu = (String) JOptionPane.showInputDialog(null, "Seleccione una acción:", "Opciones para el usuario",
						JOptionPane.DEFAULT_OPTION, null, opcionesDelMenu, opcionesDelMenu[0]);

				// Condicional de selección (switch) que realiza una acción
				// según la opción elegida por el usuario.
				switch (menu) {
				case "Insertar":
					cola.insert(JOptionPane.showInputDialog("Escriba el elemeto a insertar"));
					break;
				case "Extraer":
					JOptionPane.showMessageDialog(null, cola.extract());
					break;
				case "Conocer el elemento del frente":
					JOptionPane.showMessageDialog(null, cola.front());
					break;
				case "Saber si está llena":
					if (((CircularQueue) cola).isFull()) {
						JOptionPane.showMessageDialog(null, "La cola está llena.");
					} else {
						JOptionPane.showMessageDialog(null, "La cola no está llena.");
					}
					break;
				case "Saber si está vacia":
					if (cola.isEmpty()) {
						JOptionPane.showMessageDialog(null, "La cola está vacía.");
					} else {
						JOptionPane.showMessageDialog(null, "La cola no está vacía.");
					}
					break;
				}// switch
			} catch (NullPointerException npe) {
				// Termina la ejecución.
				menu = "Terminar";

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} while (!menu.equals(opcionesDelMenu[5]));

	}// main
}// class