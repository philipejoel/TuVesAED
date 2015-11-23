package dataStructures;

public interface ExtendedEntry<K, V> extends Entry<K, V>{
	
	V setValue(V value);
	K setKey(K key);
}
