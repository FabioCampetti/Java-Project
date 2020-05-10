package TDAArbolBinario;

import java.util.Iterator;
import java.lang.Iterable;
import TDALista.*;

public class ArbolBinarioEnlazado<E> implements BinaryTree<E> {

	protected BTNode<E> root;
	protected int size;

	/**
	 * Inicializa un Arbol Binario vacio
	 */
	public ArbolBinarioEnlazado() {
		root=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0 || root==null);
	}
	
	private BTNode<E> checkPosition(Position<E> v)throws InvalidPositionException{
		try {
			if(v==null)throw new InvalidPositionException("Pos nula");
			return(BTNode<E>)v;
		}
		catch(ClassCastException e) {
			throw new InvalidPositionException("Pos Nula");
		}
	}
	
	public boolean isInternal(Position<E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		return (n.getLeft()!=null || n.getRight()!=null);
	}
	
	public boolean isExternal(Position<E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		return(n.getLeft()==null && n.getRight()==null);
	}
	
	public boolean isRoot(Position<E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		return (n==root);
	}
	
	public boolean hasLeft(Position<E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		return (n.getLeft()!=null);
	}
	
	public boolean hasRight(Position<E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		return (n.getRight()!=null);
	}
	
	public Position<E> root()throws EmptyTreeException{
		if(root==null)
			throw new EmptyTreeException("Arbol Vacio");
		return root;
	}
	
	public Position<E> parent(Position<E> v)throws InvalidPositionException,BoundaryViolationException{
		BTNode<E> n=checkPosition(v);
		if(n==root)
			throw new BoundaryViolationException("No tiene Padre");
		return n.getParent();
	}
	
	public Position<E> left(Position<E> v)throws InvalidPositionException,BoundaryViolationException{
		BTNode<E> n=checkPosition(v);
		BTNode<E> left=n.getLeft();
		if(left==null)
			throw new BoundaryViolationException("No tiene hijo izquierdo");
		return left;
	}
	
	public Position<E> right(Position<E> v)throws InvalidPositionException,BoundaryViolationException{
		BTNode<E> n=checkPosition(v);
		BTNode<E> right=n.getRight();
		if(right==null)
			throw new BoundaryViolationException("No tiene hijo derecho");
		return right;
	}
	
	public Iterable<Position<E>> children(Position <E> v)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		PositionList<Position<E>> children=new ListaSimplementeEnlazada<Position<E>>();
		if(n.getLeft()!=null)
			children.addLast(n.getLeft());
		if(n.getRight()!=null)
			children.addLast(n.getRight());
		return children;
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> positions=new ListaSimplementeEnlazada<Position<E>>();
		try {
		if(size!=0)
			preorderPositions(root,positions);
		}catch(InvalidPositionException e) {};
		return positions;
	}
	
	private void preorderPositions(BTNode<E> n, PositionList<Position<E>> l) throws InvalidPositionException{
		l.addLast(n);
			if (n.getLeft()!=null)
				preorderPositions(n.getLeft(), l);
			if (n.getRight()!=null)
				preorderPositions(n.getRight(), l);
	}
	
	public Iterator<E> iterator(){
		Iterable<Position<E>> positions=positions();
		PositionList<E> elements=new ListaSimplementeEnlazada<E>();
		for(Position<E> pos:positions)
			elements.addLast(pos.element());
		return elements.iterator();
	}
	
	public E replace(Position<E> v,E e)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		E aux=n.element();
		n.setElement(e);
		return aux;
	}
	
	public Position<E> addLeft(Position<E> v,E e)throws InvalidPositionException,InvalidOperationException{
		BTNode<E> n=checkPosition(v);
		if(n.getLeft()!=null) 
			throw new InvalidOperationException("Ya Tiene hijo izquierdo");
		BTNode<E> w=new BTNode<E>(e);
		n.setLeft(w);
		w.setParent(n);
		size++;
		return w;
		}
	
	public Position<E> addRight(Position<E> v,E e)throws InvalidPositionException,InvalidOperationException{
		BTNode<E> n=checkPosition(v);
		if(n.getRight()!=null)
			throw new InvalidOperationException("Ya Tiene hijo derecho");
		BTNode<E> w=new BTNode<E>(e);
		n.setRight(w);
		w.setParent(n);
		size++;
		return w;
		}
	
	public E remove(Position<E> v)throws InvalidPositionException,InvalidOperationException{
		BTNode<E> n=checkPosition(v);
		BTNode<E> left=n.getLeft();
		BTNode<E> right=n.getRight();
		if(left!=null && right!=null)
			throw new InvalidOperationException("No se puede remover Nodo con dos hijos");
		BTNode<E> child;
		if(left!=null)
			child=left;
		else
			if(right!=null)
				child=right;
			else
				child=null;
		if(n==root) {
			if(child!=null)
				child.setParent(null);
			root=child;
		}
		else {
			BTNode<E> parent=n.getParent();
			if(n==parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
			if(child!=null)
				child.setParent(parent);
			}
		size--;
		return n.element();
	}
	
	
	public void Attach(Position<E> v,BinaryTree<E>T1,BinaryTree<E> T2)throws InvalidPositionException{
		BTNode<E> n=checkPosition(v);
		BTNode<E> aux;
		try {
		if(n.getLeft()!=null || n.getRight()!=null)
			throw new InvalidPositionException("No se puede juntar con Nodo Interno");
		if(!T1.isEmpty()) {
			aux=new BTNode<E>(T1.root().element());
			aux.setParent(n);
			n.setLeft(aux);
			recursivo(T1,T1.root(),aux);
		}
		if(!T2.isEmpty()) {
			aux=new BTNode<E>(T2.root().element());
			aux.setParent(n);
			n.setRight(aux);
			recursivo(T2,T2.root(),aux);
		}
		}catch(EmptyTreeException e) {};
		size+=(T1.size()+T2.size());
	}
	
	private void recursivo(BinaryTree<E> T,Position<E> pos,BTNode<E> r) {
		BTNode<E>n;
		try {
		if(T.hasLeft(pos)) {
			n=new BTNode<E>(T.left(pos).element());
			n.setParent(r);
			r.setLeft(n);
			recursivo(T,T.left(pos),n);
			}
		if(T.hasRight(pos)) {
			n=new BTNode<E>(T.right(pos).element());
			n.setParent(r);
			r.setRight(n);
			recursivo(T,T.right(pos),n);
		}
		}catch(InvalidPositionException | BoundaryViolationException w) {};
	}
	
	public Position<E> createRoot(E r)throws InvalidOperationException{
		if(!isEmpty())
			throw new InvalidOperationException("Ya tiene Raiz");
		size=1;
		root=new BTNode<E>(r,null,null,null);
		return root;
		
	}
} 