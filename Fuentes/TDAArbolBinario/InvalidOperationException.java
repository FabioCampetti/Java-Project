package TDAArbolBinario;

/**
 * Modela una situacion de Operacion Invalida
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class InvalidOperationException extends Exception {
	/**
	 * Inicializa un Excepcion de Operacion Invalida con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public InvalidOperationException(String msg) {
		super(msg);
	}

}
