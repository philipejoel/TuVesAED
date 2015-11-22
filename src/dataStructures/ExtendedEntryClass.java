package dataStructures;

public class ExtendedEntryClass<K, V> extends EntryClass<K, V> implements ExtendedEntry<K, V> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtendedEntryClass(K key, V value){
		super(key, value);
	}
	
	public V setValue(V value){
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	public K setKey(K key){
		K oldKey = this.key;
		this.key = key;
		return oldKey;
	}
}
