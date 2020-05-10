package TDAPila;

/**
 * Clase Nodo
 * @author Fabio Campetti
 * @author Javier Cifuentes
 * @param <E>
 */
public class Nodo<E> {
private E elemento;
private Nodo<E> siguiente;

/**
 * Inicializa un Nodo con rotulo y referencia al siguiente nula
 */
public Nodo(){
	elemento=null;
	siguiente=null;
}

/**
 * Inicializa un Nodo con rotulo parametrizado y referencia al siguiente nula
 * @param elem rotulo del nodo
 */
public Nodo(E elem) {
	elemento=elem;
	siguiente=null;
}

/**
 * Inicializa un Nodo con rotulo y siguiente parametrizados
 * @param elem rotulo del nodo
 * @param Nodo sig referencia al siguiente
 */
public Nodo(E elem,Nodo<E> sig) {
	elemento=elem;
	siguiente=sig;
}

/**
 * Devuleve el rotulo del Nodo
 * @return rotulo
 */
public E getElemento() {
	return elemento;
}

/**
 * Modifica el rotulo del nodo parametrizado
 * @param elemento rotulo nuevo
 */
public void setElemento(E elemento) {
	this.elemento=elemento;
}

/**
 * Devuelve la referencia al nodo siguiente
 * @return referencia al nodo siguiente
 */
public Nodo<E> getSiguiente(){
	return siguiente;
}

/**
 * Modifica la referencia al nodo siguiente
 * @param siguiente referencia al nodo siguiente
 */
public void setSiguiente(Nodo<E> siguiente) {
	this.siguiente=siguiente;
}
}
