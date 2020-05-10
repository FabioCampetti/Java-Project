package TDALista;

/**
 * Modela una situacion de Posicion Invalida
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * Inicializa un Excepcion de Posicion Invalida con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}

}
