package TDAMapeo;
import TDALista.*;

/**
 * Clase HashAbiertoMap
 * Implementa Map
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <K>
 * @param <V>
 */
public class HashAbiertoMap<K,V> implements Map<K,V> {
	
	protected int size;
	protected PositionList<Entrada<K,V>>[] entries;
	protected int max;
	protected double fc=0.9;
	
	@SuppressWarnings("unchecked")
	/**
	 * Inicializa un Mapeo vacio, con 11 buckets inicialmente
	 */
	public HashAbiertoMap() {
		size=0;
		max=11;
		entries= (PositionList<Entrada<K,V>>[]) new ListaSimplementeEnlazada[max];
		for(int i=0;i<max;i++)
			entries[i]= new ListaSimplementeEnlazada<Entrada<K,V>>();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public V get(K key)throws InvalidKeyException{
		if(key==null)
			throw new InvalidKeyException("Clave Invalida");
		int n=Math.abs(key.hashCode() % max);
			for(Entrada<K,V> e:entries[n])
				if(e.getKey().equals(key))
					{return e.getValue();}
		return null;
	}
	
	public V put(K key,V value)throws InvalidKeyException{
		if(key==null)
			throw new InvalidKeyException("Clave Nula");
		int n=Math.abs(key.hashCode() % max);
		
		for(Entrada<K,V> e:entries[n])
			if(e.getKey().equals(key))
			{V ret=e.getValue();
			e.setValue(value);
			return ret;}
		if(size/max>fc) {
			trasladar();
			n=Math.abs(key.hashCode() % max);
		}
		
		entries[n].addLast(new Entrada<K,V>(key,value));
		size++;
		return null;
			}
	
@SuppressWarnings("unchecked")
private void trasladar(){
		
		max = max*2;
		PositionList<Entrada<K,V>>[] old = entries;
		entries = (PositionList<Entrada<K,V>>[]) new ListaSimplementeEnlazada[max];
		
		for(int j = 0; j<max; j++)
			entries[j] = new ListaSimplementeEnlazada<Entrada<K,V>>();
		
		for (int i = 0; i<old.length; i++)
			for (Entrada<K,V> ent : old[i]){
				int pos = ent.getKey().hashCode() % max;
				entries[pos].addLast(ent);
			}
}
	
	public V remove(K key)throws InvalidKeyException{
		if(key==null)
			throw new InvalidKeyException("Clave Nula");
		int n=Math.abs(key.hashCode() % max);
		try {
		for(Position<Entrada<K,V>> e:entries[n].positions())
			if(e.element().getKey().equals(key))
			{ V ret=e.element().getValue();
			entries[n].remove(e);
			size--;
			return ret;}
		}catch (InvalidPositionException e) {};
		return null;
			
	}
	
	public Iterable<K> keys(){
		PositionList<K> keys=new ListaSimplementeEnlazada<K>();
		for(int i=0;i<max;i++)
			for(Entrada<K,V> e:entries[i])
				keys.addLast(e.getKey());
		return keys;
}
	
	public Iterable<V> values(){
		PositionList<V> values=new ListaSimplementeEnlazada<V>();
		for(int i=0;i<max;i++)
			for(Entrada<K,V> e:entries[i])
				values.addLast(e.getValue());
		return values;
	}
	
	public Iterable<Entry<K,V>> entries(){
		PositionList<Entry<K,V>> entradas=new ListaSimplementeEnlazada<Entry<K,V>>();
		for(int i=0;i<max;i++)
			for(Entrada<K,V> e:entries[i])
				entradas.addLast(e);
		return entradas;
	}
	

}
