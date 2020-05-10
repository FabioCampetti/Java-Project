package Logica;

@SuppressWarnings("serial")
/**
 * Modela una situacion de Variable con Operandos
  * @author Fabio Campetti
 * @author Javier Cifuentes
 */
public class VariableException extends Exception {

	/**
	 * Inicializa un Excepcion de Variable con Operandos con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public VariableException(String msg) {
		super(msg);
	}
}
