package aplicacion;

import javax.swing.JOptionPane;
import estructuras.Stack;
import dominio.StackUnlimited;

/**
 * @author Isar Ramses Cadena Gaona, Heberto Barrera Salas, Jorge Alberto Huerta
 *         Rocha.
 * 
 *         Clase aplicación que convierte expresiones de notación infija a
 *         postfija.
 */
public class InfijaAPostfija {
	// Declaración de la pila, es static pues será usada por metodos de clase
	public static Stack operadoresYParentesis = new StackUnlimited();

	/**
	 * Método main que brinda una interfaz grafica para el usuario
	 * 
	 * @param args
	 * @return sin valores de retorno
	 */
	public static void main(String[] args) {
		// Variable de estado, (usada cuando el usuario desea convertir otra
		// expresión)
		int repetir;

		// Ciclo donde el usuario puede elegir convertir de nuevo
		do {
			// El usuario ingresa la expresión infija como una variable
			// indefinida.
			conversion(JOptionPane.showInputDialog("Ingrese la expresión infija"));

			// Se le pregunta al usuario si desea convertir otra vez
			repetir = JOptionPane.showConfirmDialog(null, "¿Quiere convertir otra expresión?", "Opciones",
					JOptionPane.YES_NO_OPTION);
		} while (repetir == 0);
	}// Main

	/**
	 * Método que convierte expreciones infijas a postfijas
	 * 
	 * @param infija
	 * @return sin valores de retorno
	 */
	public static void conversion(String infija) {
		// Declaración de la variable posicion, al comienzo de la cadena
		// "infija"
		int posicion = 0;

		// Cadena "salida" que se irá construyendo a lo largo del proceso de
		// conversión.
		String salida = "";

		do {
			try {
				// Si es el fin de la cadena entonces...
				if (posicion == infija.length()) {
					// Saca los posibles elementos que contenga la pila
					while (!operadoresYParentesis.isEmpty()) {
						salida += operadoresYParentesis.pop();
					}

					// Término de la ejecución.
					JOptionPane.showMessageDialog(null, "Expresión infija original: " + infija
							+ "\nÉsta es su expresión convertida a postfija: " + salida);
					break;
				} else if (infija.charAt(posicion) == '(') {
					// Si encuentra '(' lo mete a la pila.
					operadoresYParentesis.push(infija.charAt(posicion));

					// Incrementa posicion para el siguiente carácter de
					// la cadena infija.
					posicion++;
				} else if (infija.charAt(posicion) == ')') {
					// Si encuentra ')' saca de la pila hasta encontrar '('.
					// (en el diagrama no se especifica si los elementos que
					// se saquen se adieran a pila, pero eso hicimos)
					do {
						if ((char) operadoresYParentesis.top() == '(') {
							operadoresYParentesis.pop();
						} else {
							salida += operadoresYParentesis.pop();
						}
					} while ((char) operadoresYParentesis.pop() != '(');

					// Incrementa posicion para el siguiente carácter de la
					// cadena infija.
					posicion++;
				} else if (infija.charAt(posicion) == '*' || infija.charAt(posicion) == '/'
						|| infija.charAt(posicion) == '%' || infija.charAt(posicion) == '-'
						|| infija.charAt(posicion) == '+') {
					// Si encotró operador.

					if (!operadoresYParentesis.isEmpty()) {
						// Determina la precedencia del operador y la
						// precedencia del elemento tope de la pila.
						try {
							while (precedencia(infija.charAt(posicion))
									&& ((char) operadoresYParentesis.top() != '(')) {
								// Si la precedencia del operador es de <=
								// precedencia del elemento tope entonces
								// saca el elemento de la pila y lo pone en
								// "salida".
								salida += operadoresYParentesis.pop();
							}
						} catch (Exception e) {
							if (!operadoresYParentesis.isEmpty()) {
								// Estas instruccioes se ejecutan cuando el
								// ciclo while manda una excepción.
								operadoresYParentesis.push(infija.charAt(posicion));
								posicion++;
								break;
							}
						}

					}
					// Si la precedencia del operador NO es <= que la
					// del elemento tope entonces mete el operador en la
					// pila.
					operadoresYParentesis.push(infija.charAt(posicion));

					// Incrementa posicion para el siguiente carácter de
					// la cadena infija.
					posicion++;
				} else {
					// Si no encontró operador entonces mueve el caracter a
					// "salida".
					salida += infija.charAt(posicion);

					// Incrementa posicion para el siguiente carácter de la
					// cadena infija.
					posicion++;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (posicion != (infija.length() + 1));

	}

	/**
	 * Metodo que indica si el operador es de menor o igual procedencia que el
	 * elemento tope de la pila
	 * 
	 * @param operador
	 * @return bandera
	 * @throws Exception
	 */
	public static boolean precedencia(char operador) throws Exception {
		boolean bandera = true;
		char tope = (char) operadoresYParentesis.top();
		// Si el operador es de mayor precedencia que el elemento tope, regresa
		// false.
		if ((operador == '*' || operador == '/' || operador == '%') && (tope == '+' || tope == '-')) {
			return false;
		}
		return bandera;
	}

}// Class
