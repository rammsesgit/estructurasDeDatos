package estructuras;

/**
 * 
 * @author Isar Ramses Cadena Gaona
 *
 */
public interface Queue {

	/**
	 * Indica si la pila está vacia.
	 * 
	 * @param Sin
	 *            parametros.
	 * @return true si la pila está vacia, false en caso contrario.
	 */
	public abstract boolean isEmpty();

	/**
	 * Indica si la pila está llena.
	 * 
	 * @param Sin
	 *            parametros.
	 * @return true si la pila está llena, false en caso contrario.
	 */
	public abstract boolean isFull();

	/**
	 * Inserta un elemento en la pila.
	 * 
	 * @param element
	 * @return Sin valores de retorno.
	 */
	public abstract void insert(Object element) throws Exception;

	/**
	 * Extrae el elemento del fondo de la cola y lo muestra. Tiene
	 * compartamiento FIFO.
	 * 
	 * @param Sin
	 *            parametros.
	 * @return Object, que es el elemento del fondo de la cola.
	 */
	public abstract Object extract();
}//Interface
