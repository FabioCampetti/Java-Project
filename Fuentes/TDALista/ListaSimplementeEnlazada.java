package TDALista;

import java.util.Iterator;

/**
 * Clase ListaSimplementeEnlazada
 * Implementa PositionList
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <E>
 */
public class ListaSimplementeEnlazada <E> implements PositionList<E>{

	protected Nodo<E> cabeza;
	protected int longitud;
	
	/**
	 * Inicializa la Lista vacia
	 */
	
	public ListaSimplementeEnlazada() {
		cabeza=null;
		longitud=0;
	}
	
	public int size() {
		return longitud;
	}
	
	public boolean isEmpty() {
		return cabeza==null;
	}
	
	public void addFirst(E e)
	{
		cabeza =new Nodo<E>(e ,cabeza);
		longitud++;
	}
	
	public void addLast(E e) {
		if(isEmpty())addFirst(e);
		else
		{
			Nodo<E> p=cabeza;
			while(p.getSiguiente()!=null)
				p=p.getSiguiente();
			p.setSiguiente(new Nodo<E>(e));
			longitud++;
		}
		}
	
	public Position<E> first() throws EmptyListException{
		if(cabeza==null)
			throw new EmptyListException("Lista Vacia");
		return (Position<E>)cabeza;
	}
	
	public Position<E> last() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("Lista Vacia");
		else
		{
			Nodo<E> p=cabeza;
			while(p.getSiguiente()!= null)
				p=p.getSiguiente();
			return (Position<E>)p;
		}
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		
		Nodo<E> n=checkPosition(p);
		if(n.getSiguiente()==null)
			throw new BoundaryViolationException("Posicion Invalida");
		return n.getSiguiente();
	}
	
	private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try {
			if(p==null)throw new InvalidPositionException("Pos nula");
			return(Nodo<E>)p;
		}
		catch(ClassCastException e) {
			throw new InvalidPositionException("Pos Nula");
		}
	}

	public void addAfter(Position<E> p,E e) throws InvalidPositionException{
		Nodo<E> n=checkPosition(p);
		Nodo<E> nuevo=new Nodo<E>(e);
		nuevo.setSiguiente(n.getSiguiente());
		n.setSiguiente(nuevo);
		longitud++;
	}
	
	public void addBefore(Position<E> p,E e)throws InvalidPositionException{
		Nodo<E> n=checkPosition(p);
		try {
		if(p==first())addFirst(e);
		else {
			Nodo<E> anterior=(Nodo<E>)prev(p);
			Nodo<E> nuevo= new Nodo<E>(e,n);
			anterior.setSiguiente(nuevo);
			longitud++;
		}
		}catch(EmptyListException t) {
			throw new InvalidPositionException("Pos nula");
	}catch(BoundaryViolationException w) {
		throw new InvalidPositionException("Pos nula");
	}
	}
	
	public Position<E> prev(Position<E> p)throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> n=checkPosition(p);
		if(n==cabeza)
			throw new BoundaryViolationException("Lista::prev():"+"Posicion primera");
		Nodo<E> aux=cabeza;
		while(aux.getSiguiente()!=n && aux.getSiguiente()!=null)
			aux=aux.getSiguiente();
		if(aux.getSiguiente()==null)
			throw new InvalidPositionException("Lista::prev():"+"Posicion no pertenece a la lista");
		return aux;
	}
	
	public E remove(Position<E> p)throws InvalidPositionException{
		Nodo<E> n=checkPosition(p);
		E toRet;
		if(isEmpty())
			throw new InvalidPositionException("Lista Vacia");
		if(n!=cabeza){
			Nodo<E> anterior=cabeza;
			while(anterior.getSiguiente()!=n && anterior!=null )
				anterior=anterior.getSiguiente();
			if(anterior==null)
				throw new InvalidPositionException("Posicion Invalida");
			anterior.setSiguiente(n.getSiguiente());
			}
		else
			cabeza=cabeza.getSiguiente();// era unico elemento		
		toRet=n.element();
		n.setSiguiente(null);
		n.setElemento(null);
		longitud--;
		return toRet;
		}

	public E set(Position<E> p,E e)throws InvalidPositionException{
		Nodo<E> n=checkPosition(p);
		Nodo<E> puntero=cabeza;
		while(puntero!=n && puntero!=null)
			puntero=puntero.getSiguiente();
			if(puntero==null)
				throw new InvalidPositionException("Posicion Invalida");
		E aux=n.element();
		n.setElemento(e);
		return aux;
				
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l= new ListaSimplementeEnlazada<Position<E>>();
		if(!isEmpty()){				
			Nodo<E> n= cabeza;
			while(n!=null){
				l.addLast(n);
				n=n.getSiguiente();
			}
		}
		return l;
		}
	
	public Iterator<E> iterator(){
		return new ListaIterator<E>(this);
	}
	}
