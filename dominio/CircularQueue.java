package dominio;

import estructuras.Queue;

/**
 * @author Isar Ramses Cadena Gaona
 * @version v1.0_24/10/2016
 * 
 *          Clase que implementa la interfaz Queue, además, proporciona
 *          funciones basicas de una cola circular como lo son; insert, extract,
 *          isEmpty e isFull.
 */
public class CircularQueue implements Queue {
	// Declaracion de las variables que seran usadas por la clase.
	private Object[] queue;
	private int rear, front;

	/**
	 * Constructor de la clase que crea objetos CircularQueue por defecto.
	 * 
	 * @param SinParametros
	 * @return Sin valores de retorno.
	 */
	public CircularQueue() {
		queue = new Object[10];
		rear = 0;
		front = 0;
	}

	/**
	 * Método que indica si la cola circular está vacia.
	 * 
	 * @return true si la cola está vacia.
	 */
	public boolean isEmpty() {
		return queue[front] == null && front == rear;
	}

	/**
	 * Método que indica si la cola circular está llena.
	 * 
	 * @return true si la cola está llena.
	 */
	public boolean isFull() {
		return queue[front] != null && front == rear;
	}

	/**
	 * Método que inserta un elemento en la cola.
	 * 
	 * @param element
	 * @return Sin valores de retorno.
	 */
	public void insert(Object element) throws Exception {
		if (!isFull()) {
			queue[rear] = element;
			rear = ++rear % queue.length;
		} else {
			throw new Exception("La cola ya está llena");
		}
	}

	/**
	 * Método que extrae un elemento de la cola y lo muestra.
	 * 
	 * @param SinParametros.
	 * @return auxiliar, que es el elemento que se extrajo.
	 */
	public Object extract() throws Exception {
		Object auxiliar = queue[front];
		if (!isEmpty()) {
			front = ++front % queue.length;
			return auxiliar;
		} else {
			throw new Exception("La cola está vacia.");
		}
	}

	/**
	 * Regresa el elemento del frente (front) sin eliminarlo.
	 * 
	 * @param sinParametros
	 * @return el primer elemento de la cola
	 */
	public Object front() throws Exception {
		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new Exception("La cola está vacia");
		}
	}
}// Class
