package estructuras;

/**
 * @author Isar Ramses Cadena Gaona
 * @version 1.0_18/10/2016
 */
public interface Queue {

	/**
	 * Indica si la pila está vacia.
	 * 
	 * @param SinParametros.
	 * @return true si la pila está vacia, false en caso contrario.
	 */
	public abstract boolean isEmpty();

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
	public abstract Object extract() throws Exception;

	/**
	 * Regresa el elemento del frente (front) sin eliminarlo
	 * 
	 * @param sinParametros
	 * @return el primer elemento de la cola
	 */
	public abstract Object front() throws Exception;
}// Interface
