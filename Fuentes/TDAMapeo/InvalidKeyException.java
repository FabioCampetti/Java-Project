package TDAMapeo;

/**
 * Modela una situacion de Clave Invalida
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class InvalidKeyException extends Exception {
	/**
	 * Inicializa un Excepcion de Clave Invalida con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */

	public InvalidKeyException(String msg) {
		super(msg);
	}
}
