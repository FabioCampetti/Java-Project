package TDAArbolBinario;

/**
 * Clase BTNode
 * Implementa BTPosition
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <E>
 */
public class BTNode<E> implements BTPosition<E> {
	
	private E elemento;
	private BTNode<E> left,right,parent;
	
	/**
	 * Inicializa un nodo de Arbol Binario con rotulo y referencia a su nodo padre, derecho e izquierdo
	 * @param element rotulo del nodo
	 * @param parent referencia al nodo padre
	 * @param left referencia al nodo izquierdo
	 * @param right referencia al nodo derecho
	 */
	public BTNode(E element,BTNode<E> parent,BTNode<E> left,BTNode<E> right) {
		elemento=element;
		this.parent=parent;
		this.left=left;
		this.right=right;
	}
	
	/**
	 * Inicializa un nodo de Arbol Bianrio con rotulo y referencia a nodo padre, dercho e izquierdo nulas
	 * @param element rotulo del nodo
	 */
	public BTNode(E element) {
		elemento=element;
		parent=null;
		left=null;
		right=null;
	}
	
	public void setParent(BTPosition<E> e) {
		BTNode<E> n=(BTNode<E>) e;
		parent=n;
	}
	
	public void setLeft(BTPosition<E> e) {
		BTNode<E> n=(BTNode<E>)e;
		left=n;
	}
	
	public void setRight(BTPosition<E> e) {
		BTNode<E> n=(BTNode<E>)e;
		right=n;
	}

	public void setElement(E e) {
		elemento=e;
	}
	
	public E element() {
		return elemento;
	}
	
	public BTNode<E> getParent(){
		return parent;
	}
	
	public BTNode<E> getLeft(){
		return left;
	}
	
	public BTNode<E> getRight(){
		return right;
	}
	
}
