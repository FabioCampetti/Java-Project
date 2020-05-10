package TDALista;

/**
 * Clase Nodo
 * Implementa Position
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <E>
 */
public class Nodo<E> implements Position<E>{
	protected E elemento;
	protected Nodo<E> siguiente;
	
	/**
	 * Inicializa un Nodo con un rotulo y referencia a un Nodo siguiente
	 * @param elemento rotulo del nodo
	 * @param siguiente referencia al nodo siguiente
	 */
	public Nodo(E elemento, Nodo<E> siguiente) {
		this.elemento=elemento;
		this.siguiente=siguiente;
	}
	/**
	 * Inicializa un Nodo con un rotulo y referencia al siguiente nula
	 * @param elemento rotulo del nodo
	 */
	public Nodo(E elemento) {
		this(elemento, null);
	}
	
	/**
	 * Modifica el rotulo por el pasado por parametro
	 * @param elemento nuevo rotulo
	 */
	public void setElemento(E elemento) {
		this.elemento=elemento;
	}
	
	/**
	 *  Retorna la referencia al nodo siguiente
	 * @return referencia al nodo siguiente
	 */

	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	
	/**
	 * Moodifica la referencia al nodo siguiente con el pasado por parametro
	 * @param siguiente referencia al nodo siguiente
	 */
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente=siguiente;
	}
	
	public E element() {
		return elemento;
	}
	
}
