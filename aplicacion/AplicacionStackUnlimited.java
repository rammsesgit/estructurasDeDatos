package aplicacion;

import javax.swing.JOptionPane;

import dominio.StackUnlimited;

public class AplicacionStackUnlimited {
	public static void main(String[] Args) {
		// Declracion de variables
		String[] menu = { "Ingresar elemento", "Desechar último elemento", "Conocer el último elemento" };
		StackUnlimited nStack = new StackUnlimited();
		int usuario;
		// Interfaz grafica para el usuario
		do {
			String eleccion = (String) JOptionPane.showInputDialog(null, "¿Que desea hacer?",
					"Opciones para el usuario", JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
			try {
				switch (eleccion) {
				case "Ingresar elemento":
					// Excepcion si ingresa una letra o numero que no sea entero
					// positivo
					try {
						nStack.push(Integer.parseInt(JOptionPane.showInputDialog("¿Que elemento desea ingresar?")));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error. Solo se admiten numeros enteros positivos");
						break;
					}
					break;
				case "Desechar último elemento":
					if (!nStack.isEmpty()) {
						JOptionPane.showMessageDialog(null, "El elemento desechado es " + nStack.pop());
					} else {
						JOptionPane.showMessageDialog(null, "La pila ya está vacia");
					}
					break;
				case "Conocer el último elemento":
					try {
						JOptionPane.showMessageDialog(null, "El último elemento es: " + nStack.top());
					} catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "La pila está vacia");
					}
					break;
				}// switch
			} catch (Exception e) {
				// continuar
			} // Try catch
			usuario = JOptionPane.showConfirmDialog(null, "¿Realizar otra acción?", " ", JOptionPane.YES_NO_OPTION);
		} while (usuario == 0);
	}// Main
}// Clase