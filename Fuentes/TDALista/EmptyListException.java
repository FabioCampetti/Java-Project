package TDALista;

/**
 * Modela una situacion de Lista Vacia
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception{
	
	/**
	 * Inicializa un Excepcion de Lista Vacia con la descripcion parametrizada
	 * @param msg descripcion de la excepcion
	 */
	public EmptyListException (String msg){
		super(msg);
	}
}
