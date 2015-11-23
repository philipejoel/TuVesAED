/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */
package dataStructures;  

public interface OrderedDictionary<K extends Comparable<K>, V> 
    extends Dictionary<K,V>
{                                                                   

    // Returns the entry with the smallest key in the dictionary.
    Entry<K,V> minEntry( ) throws EmptyDictionaryException;

    // Returns the entry with the largest key in the dictionary.
    Entry<K,V> maxEntry( ) throws EmptyDictionaryException;

    // Returns an iterator of the entries in the dictionary 
    // which preserves the key order relation.
    Iterator<Entry<K,V>> iterator( );  

} 
