package TDAPila;

@SuppressWarnings("serial")
/**
 * Modela una situacion de Pila Vacia
  * @author Fabio Campetti
 * @author Javier Cifuentes
 */
public class EmptyStackException extends Exception {
	/**
	 * Inicializa un Excepcion de Pila Vacia con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */

	public EmptyStackException(String s) {
		super(s);
	}
}
