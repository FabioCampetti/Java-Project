package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Modela un Iterador para una lista
 * Implementa Iterator
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <E>
 */
public class ListaIterator<E> implements Iterator<E> {
	
	protected PositionList<E> L;
	protected Position<E> cursor;
	
	/**
	 * Crea un Iterador para los elementos de la lista parametrizada, en orden del primero al ultimo
	 * @param lista lista que contiene los elementos a iterar
	 */
	public ListaIterator(PositionList<E> lista){
		L=lista;
		try{
		cursor=(L.isEmpty()? null:L.first());
		}catch(EmptyListException  o){};
	}
	
	/**
	 * Devuelve el elemento siguiete a iterar o nulo en caso contrario
	 */
	public E next(){
		
		if(cursor==null)
			throw new NoSuchElementException("No hay siguiente.");
		else{
			E toReturn=cursor.element();
			try{
				cursor=(cursor==L.last()? null:L.next(cursor));
				return toReturn;
				}
			catch(EmptyListException o){return null;}
			catch(InvalidPositionException p){return null;}
			catch(BoundaryViolationException v){return null;}
		
		}
	
	}
	
	/**
	 * Devuele si hay mas elementos a iterar
	 */
	public boolean hasNext(){
		return cursor!=null;
	}

}