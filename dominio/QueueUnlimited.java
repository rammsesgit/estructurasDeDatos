package dominio;

import estructuras.Queue;

/**
 * @author Isar Ramses Cadena Gaona
 * @version v1.0_20/10/2016
 * 
 *          Clase que implementa la interfaz Queue, además, proporciona
 *          funciones basicas de una cola como lo son; insert, extract, isEmpty e isFull.
 */
public class QueueUnlimited extends Object implements Queue {
	// Declaracion de las variables que seran usadas por la clase.
	private Object[] queue;
	private int rear;

	/**
	 * Constructor de la clase que crea objetos QueueUnlimited por defecto.
	 * 
	 * @param SinParametros
	 * @return Sin valores de retorno.
	 */
	public QueueUnlimited() {
		queue = new Object[10];
		rear = 0;
	}

	/**
	 * Método que indica si la cola está vacia.
	 * 
	 * @return true si la cola está llena.
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
		queue[rear] = element;
		rear++;
	}

	/**
	 * Método que extrae un elemento de la cola y lo muestra.
	 * 
	 * @param SinParametros.
	 * @return auxiliar, que es el elemento que se extrajo.
	 */
	public Object extract() {
		Object auxiliar = queue[0];
		Object[] temporal = new Object[queue.length];
		for (int i = 0; i < queue.length - 1; i++) {
			temporal[i] = queue[i + 1];
			queue[i] = temporal[i];
		}
		rear--;
		return auxiliar;
	}
}//Class
