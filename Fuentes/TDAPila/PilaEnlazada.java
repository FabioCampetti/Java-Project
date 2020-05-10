package TDAPila;

/**
 * Clase PilaEnlazada
 * Extiende a Stack
 * @author Fabio Campetti
 * @author Javier Cifuentes
 * @param <E>
 */
public class PilaEnlazada<E> implements Stack<E>{
	protected Nodo<E> head;
	protected int tama�o;
	
	/**
	 *Inicializa la Pila vacia
	 */
	public PilaEnlazada() {
		head=null;
		tama�o=0;
	}
	
	public boolean isEmpty() {
		return head==null || tama�o==0;
	}
	
	public int size() {
		return tama�o;
	}
	
	public void push(E item) {
		Nodo<E> aux=new Nodo<E>();
		aux.setElemento(item);
		aux.setSiguiente(head);
		head=aux;
		tama�o++;
	}
	
	public E pop() throws EmptyStackException {
		E toRet;
		Nodo<E> aux; 
		if(isEmpty())
			throw new EmptyStackException("Pila Vacia");
		else
			{toRet=head.getElemento();
			aux=head;
			head=head.getSiguiente();
			aux.setElemento(null);
			aux.setSiguiente(null);
			tama�o--;
			}
		return toRet;
	}
	
	public E top() throws EmptyStackException{
		E aux;
		if(isEmpty())
			throw new EmptyStackException("Pila Vacia");
		else
			aux=head.getElemento();
		return aux;
	}

}
