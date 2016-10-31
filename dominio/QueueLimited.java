package dominio;

import estructuras.Queue;

/**
 * @author Isar Ramses Cadena Gaona
 * @version v1.0_20/10/2016 v1.1_24/10/2016
 * 
 *          Clase que implementa la interface Queue, además, proporciona
 *          funciones basicas de una cola como lo son; insert, extract, isEmpty
 *          e isFull.
 */
public class QueueLimited extends Object implements Queue {
	// Declaración de las variables que seran usadas por la clase.
	private Object[] queue;
	private int rear;

	/**
	 * Constructor de la clase que crea objetos QueueLimited por defecto.
	 * 
	 * @param SinParametros
	 * @return Sin valores de retorno.
	 */
	public QueueLimited() {
		queue = new Object[10];
		rear = 0;
	}

	/**
	 * Método que indica si la cola está vacia.
	 * 
	 * @return true si la cola está vacia.
	 */
	public boolean isEmpty() {
		return rear == 0;
	}

	/**
	 * Método que indica si la cola está llena.
	 * 
	 * @return true si la cola está llena.
	 */
	public boolean isFull() {
		return rear == queue.length - 1;
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
			rear++;
		} else {
			throw new Exception("La cola está llena.");
		}
	}

	/**
	 * Método que extrae un elemento de la cola y lo muestra.
	 * 
	 * @param SinParametros.
	 * @return auxiliar, que es el elemento que se extrajo.
	 */
	public Object extract() throws Exception {
		Object auxiliar = queue[0];
		if (!isEmpty()) {
			for (int i = 0; i < queue.length - 1; i++)
				queue[i] = queue[i + 1];
			rear--;
			return auxiliar;
		} else {
			throw new Exception("La cola está vacia.");
		}
	}

	/**
	 * Regresa el elemento del frente (front) sin eliminarlo
	 * 
	 * @param sinParametros
	 * @return el primer elemento de la cola
	 */
	public Object front() throws Exception {
		if (!isEmpty()) {
			return queue[0];
		} else {
			throw new Exception("La cola está vacia");
		}
	}
}// Class