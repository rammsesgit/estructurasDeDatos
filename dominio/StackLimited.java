package dominio;

import estructuras.Stack;

/**
 * 
 * @author Isar Ramses Cadena Gaona
 * @version 13/09/2016
 * 
 *          Aplicación que implmenta la interface Stack ademas, administra el
 *          uso de una pila con comandos basicos como lo son push, pop, isEmpy,
 *          top.
 * 
 */

public class StackLimited extends Object implements Stack {

	private Object[] stack;
	private int top;
	private boolean vacio, lleno;

	/**
	 * constructor que recive tamaño y se lo asigna a stack[]
	 * 
	 * @param tamaño
	 */

	public StackLimited(int tamaño) {
		if (tamaño <= 0) {
			stack = new Object[10];
		} else {
			stack = new Object[tamaño];
		}
		top = 0;
	}

	/**
	 * metodo que ingresa un elemento a la pila
	 * 
	 * @param elemento
	 */
	public void push(Object elemento) {
		if (top < stack.length) {
			stack[top] = elemento;
			top++;
		}

	}

	/**
	 * metodo que extrae un elemento de la pila.
	 * 
	 * @return stack
	 */
	public Object pop() {
		if (top > 0) {
			return stack[--top];
		}
		return stack[top];

	}

	/**
	 * metodo que regresa si la pila esta vacia o no.
	 * 
	 * @return vacio
	 */
	public boolean isEmpty() {
		if (top == 0) {
			vacio = true;
		} else {
			vacio = false;
		}
		return vacio;
	}

	/**
	 * metodo que regresa el valor del tope.
	 * 
	 * @return stack
	 */
	public Object top() {
		return stack[top - 1];
	}

	/**
	 * metodo que regresa si la pila esta llena o no.
	 * 
	 * @return lleno
	 */
	public boolean isFull() {
		if (top == stack.length) {
			lleno = true;
		} else {
			lleno = false;
		}
		return lleno;
	}
}