package dominio;

import estructuras.Stack;

/**
 * @author Isar Ramses Cadena Gaona
 * @version v1_20/09/2016
 * 
 *          Clase que implmenta la interface Stack ademas, brinda funciones
 *          basicas de una pila como lo son push y pop.
 */
public class StackUnlimited extends Object implements Stack {
	// Declaracion devariables
	private Object[] stack;
	private Object[] auxiliar;
	private Object ultimo;

	/**
	 * Constructor con valores
	 * 
	 * por defecto
	 * 
	 * @param tamaño
	 */
	public StackUnlimited() {
		stack = new Object[0];
	}

	/**
	 * 
	 * Metodo push que ingresa un elemento en la pila
	 * 
	 * @param elemento
	 */
	public void push(Object elemento) {
		auxiliar = new Object[stack.length + 1];
		for (int i = 0; i < stack.length; i++)
			auxiliar[i] = stack[i];
		auxiliar[auxiliar.length - 1] = elemento;
		stack = auxiliar;
	}

	/**
	 * Metodo pop que elimina el ultimo elemento que se ingreso en la pila
	 */
	public Object pop() throws Exception {
		if (stack.length >= 1) {
			ultimo = stack[stack.length - 1];
			auxiliar = new Object[stack.length - 1];
			for (int i = 0; i < auxiliar.length; i++)
				auxiliar[i] = stack[i];
			stack = auxiliar;
		}
		return ultimo;
	}

	/**
	 * Metodo que regresa el ultimo elemento de la pila
	 * 
	 * @return ultimo
	 */
	public Object top() {
		ultimo = stack[stack.length - 1];
		return ultimo;
	}

	/**
	 * Metodo que resesa si la pila esta vacia o no.
	 */
	public boolean isEmpty() {
		return stack.length == 0;
	}
}
