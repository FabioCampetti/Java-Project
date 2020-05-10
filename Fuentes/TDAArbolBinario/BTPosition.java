package TDAArbolBinario;
import TDALista.*;

/**
 * Interface BTPosition
 * Extiende interface Position
  * @author Fabio Campetti
 * @author Javier Cifuentes
 * @param <E>
 */
public interface BTPosition<E> extends Position<E> {
	
	/**
	 * Modifica el rotulo
	 * @param e nuevo rotulo
	 */
	public void setElement(E e);
	
	/**
	 * Modifica la referencia al padre
	 * @param e nuevo padre
	 */
	public void setParent(BTPosition<E> e);
	
	/**
	 * Modifica la referencia al hijo izquierdo
	 * @param e nuevo hijo izquierdo
	 */
	public void setLeft(BTPosition<E> e);
	
	/**
	 * Modifica la referencia al hijo derecho
	 * @param e nuevo hijo derecho
	 */
	public void setRight(BTPosition<E> e);
	
	public E element();
	
	/**
	 * Retorna la referencia al padre
	 * @return BTPosition padre
	 */
	public BTPosition<E> getParent();
	
	/**
	 * Retorna la referencia al hijo izquierdo
	 * @return BTPosition hijo izquierdo
	 */
	public BTPosition<E> getLeft();
	
	/**
	 * Retorna la referencia al hijo derecho
	 * @return BTPosition hijo derecho
	 */
	public BTPosition<E> getRight();

}
