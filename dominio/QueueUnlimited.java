package dominio;

import estructuras.Queue;

/**
 * @author Isar Ramses Cadena Gaona
 * @version v1.0_28/10/2016
 * 
 *          Clase que implementa la interface Queue, además, proporciona
 *          funciones basicas de una cola ilimitada como lo son; insert,
 *          extract, isEmpty e isFull.
 */
public class QueueUnlimited implements Queue {
	// Declaración de las variables que seran usadas por la clase.
	private Object[] queue;
	private Object[] temporal;
	private int rear;

	/**
	 * Constructor de la clase que crea objetos QueueUnlimited por defecto.
	 * 
	 * @param SinParametros
	 * @return Sin valores de retorno.
	 */
	public QueueUnlimited() {
		queue = new Object[0];
		rear = 0;
	}

	/**
	 * Método que indica si la cola está vacia.
	 * 
	 * @return true si la cola está vacia.
	 */
	public boolean isEmpty() {
		return queue.length == 0;
	}

	/**
	 * Método que inserta un elemento en la cola.
	 * 
	 * @param element
	 * @return Sin valores de retorno.
	 */
	public void insert(Object element) {
		temporal = new Object[queue.length + 1];
		for (int i = 0; i < queue.length; i++)
			temporal[i] = queue[i];
		temporal[rear] = element;
		queue = temporal;
		rear++;
	}

	/**
	 * Método que extrae un elemento de la cola y lo muestra.
	 * 
	 * @param SinParametros.
	 * @return auxiliar, que es el elemento que se extrajo.
	 */
	public Object extract() throws Exception {
		if (!isEmpty()) {
			Object auxiliar = queue[0];
			temporal = new Object[queue.length - 1];
			for (int i = 0; i < temporal.length; i++)
				temporal[i] = queue[i + 1];
			rear--;
			queue = temporal;
			return auxiliar;
		} else {
			throw new Exception("La cola está vacía.");
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