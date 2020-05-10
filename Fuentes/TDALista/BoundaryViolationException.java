package TDALista;

/**
 * Modela una situacion de Violacion de rango
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	/**
	 * Inicializa un Excepcion de Violacion de rango con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public BoundaryViolationException(String msg) {
		super(msg);
	}

}
