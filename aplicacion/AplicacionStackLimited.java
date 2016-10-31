package aplicacion;

import javax.swing.JOptionPane;
import estructuras.Stack;
import dominio.StackLimited;

public class AplicacionStackLimited {
	public static void main(String[] args) {
		// Declaracion de variables
		int usuario, tamañoUsuario = 0;
		String[] menu = { "Ingresar elemento", "Desechar último elemento", "Saber si la pila esta vacia",
				"Conocer el último elemento", "Saber si la pila esta llena" };
		// interfaz grafica
		try {
			tamañoUsuario = Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño quiere la pila?"));
		} catch (NumberFormatException e) {
			System.out.println("ingresó un String");
		}
		Stack nStack = new StackLimited(tamañoUsuario);
		do {
			String eleccion = (String) JOptionPane.showInputDialog(null, "¿Que desea hacer?",
					"Opciones para el usuario", JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
			// Excepcion para cuando se cancela el menu
			try {
				switch (eleccion) {
				case "Ingresar elemento":
					// Excepcion si ingresa una letra o numero que no sea entero
					// positivo
					try {
						nStack.push(Integer.parseInt(JOptionPane.showInputDialog("¿Que elemento desea ingresar?")));
					} catch (NumberFormatException e) {
						System.out.println("Error. Solo se admiten numeros enteros positivos");
						break;
					}
					break;
				case "Desechar último elemento":
					nStack.pop();
					break;
				case "Saber si la pila esta vacia":
					JOptionPane.showMessageDialog(null, nStack.isEmpty());
					break;
				case "Conocer el último elemento":
					JOptionPane.showMessageDialog(null, nStack.top());
					break;
				case "Saber si la pila esta llena":
					JOptionPane.showMessageDialog(null, ((StackLimited) nStack).isFull());
					break;
				}
			} catch (Exception e) {
				// continuar
			}
			usuario = JOptionPane.showConfirmDialog(null, "¿Realizar otra acción?", " ", JOptionPane.YES_NO_OPTION);
		} while (usuario == 0);
	}
}
