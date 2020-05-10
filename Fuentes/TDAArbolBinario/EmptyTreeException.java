package TDAArbolBinario;

/**
 * Modela una situacion de Arbol Vacio
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class EmptyTreeException extends Exception{
	/**
	 * Inicializa un Excepcion de Arbol Vacio con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public EmptyTreeException(String msg) {
		super(msg);
	}

}
