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
	public void insert(Object element) {
		queue[rear] = element;
		rear++;
		if (rear == queue.length)
			rear = 0;
	}

	/**
	 * Método que extrae un elemento de la cola y lo muestra.
	 * 
	 * @param SinParametros.
	 * @return auxiliar, que es el elemento que se extrajo.
	 */
	public Object extract() {
		Object auxiliar = queue[front];
		front++;
		if (front == queue.length)
			front = 0;
		return auxiliar;
	}
}// Class
