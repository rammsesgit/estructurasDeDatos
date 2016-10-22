package estructuras;

/**
 * @author Isar Ramses Cadena Gaona
 *
 *         (100% abstracto y publico)
 */
public interface Stack {

	/**
	 * inserta un elemento en la pila
	 * 
	 * @param elemento
	 *            elemento a insertar
	 * @return sin valores de retorno
	 */
	public abstract void push(Object elemento);

	/**
	 * extrae un elemento de la pila, tiene comportamiento LIFO: Ultimo que
	 * entra, Primero que sale
	 * 
	 * @param sin
	 *            valores de parametro
	 * @return el ultimo
	 */
	abstract Object pop() throws Exception;

	/**
	 * regresa el ultimo elemento insertado en la pila, sin eliminarlo de la
	 * misma
	 * 
	 * @param sin
	 *            valores de parametro
	 * @return
	 */
	Object top() throws Exception;

	/**
	 * indica si la pila esta vacia
	 * 
	 * @param sin valores de parametro
	 * @return true si la pila está vacia, false si es lo contrario
	 */
	abstract boolean isEmpty();

}// Interface