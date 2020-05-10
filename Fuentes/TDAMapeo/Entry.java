package TDAMapeo;

/**
 * 
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 * @param <K>
 * @param <V>
 */
public interface Entry<K,V> {
	
	/**
	 * Devuelve la clave de Entry
	 * @return clave 
	 */
	public K getKey();
	
	/**
	 * Devuelve el valor de Entry
	 * @return valor 
	 */
	public V getValue();
	
}
