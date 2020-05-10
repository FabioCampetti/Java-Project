package TDAMapeo;

/**
 * Clase Entrada
 * Implementa Entry
 * 
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <K>
 * @param <V>
 */
public class Entrada<K,V> implements Entry<K,V> {
	private K key;
	private V value;
	
	/**
	 * Inicilaiza una entrada con clave y valor parametrizados
	 * @param k clave de la entrada
	 * @param v valor de la entrada
	 */
	public Entrada(K k,V v) {
		key=k;
		value=v;
	}
	
	/**
	 * Remplaza el valor de la clave por el parametrizado
	 * @param k clave nueva
	 */
	public void setKey(K k) {
		key=k;
	}
	
	/**
	 * Remplaza el valor de value por el parametrizado
	 * @param v valor nuevo
	 */
	public void setValue(V v) {
		value=v;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
