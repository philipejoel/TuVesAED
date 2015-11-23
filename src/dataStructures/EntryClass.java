/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */
package dataStructures;

public class EntryClass<K, V> implements Entry<K, V> {


	private static final long serialVersionUID = 1L;
	protected K key;
	protected V value;
	
	public EntryClass (K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	
	public V getValue() {
		return value;
	}
	

}
