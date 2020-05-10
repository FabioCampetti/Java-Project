package Logica;
/**
 * Modela una situacion de Division pos Cero
  * @author Fabio Campetti
 * @author Javier Cifuentes
 */

@SuppressWarnings("serial")
public class CeroException extends Exception {
	
	/**
	 * Inicializa un Excepcion de Division por Cero con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public CeroException(String msg) {
		super(msg);
	}

}
