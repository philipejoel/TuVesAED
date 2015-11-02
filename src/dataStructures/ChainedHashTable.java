package dataStructures;  

public class ChainedHashTable<K extends Comparable<K>, V> 
    extends HashTable<K,V> 
{ 
    static final long serialVersionUID = 0L;


    // The array of dictionaries.
    protected Dictionary<K,V>[] table;


    @SuppressWarnings("unchecked")
    public ChainedHashTable( int capacity )
    {
        int arraySize = HashTable.nextPrime((int) (1.1 * capacity));
        // Compiler gives a warning.
        table = (Dictionary<K,V>[]) new Dictionary[arraySize];
        for ( int i = 0; i < arraySize; i++ )
            //TODO: Original comentado para nao dar erro de compilacao.
            table[i] = new OrderedDoubleList<K,V>();
        maxSize = capacity;
        currentSize = 0;
    }                                      


    public ChainedHashTable( )
    {
        this(DEFAULT_CAPACITY);
    }                                                                


    // Returns the hash value of the specified key.
    protected int hash( K key )
    {
        return Math.abs( key.hashCode() ) % table.length;
    }


    // If there is an entry in the dictionary whose key is the specified key,
    // returns its value; otherwise, returns null.
    public V find( K key )
    {
        return table[ this.hash(key) ].find(key);
    }


    // If there is an entry in the dictionary whose key is the specified key,
    // replaces its value by the specified value and returns the old value;
    // otherwise, inserts the entry (key, value) and returns null.
    public V insert( K key, V value )
    {
        if ( this.isFull() ){
            //TODO: Original comentado para nao dar erro de compilacao.
            this.rehash();
            return null;
        }
        else{
	        //TODO: Left as an exercise.
	    	V val = table[ this.hash(key) ].insert(key, value);
	    	if(val == null)
	    		currentSize++;
	        return val;
        }
    }


    private void rehash() {
		// TODO Auto-generated method stub
    	Dictionary<K,V>[] oldTable = table;
    	this.clearAndIncreaseSize();
    	// reasign variable from table to newTable
    	for(Dictionary<K,V> oldValue : oldTable){
    		if(oldValue != null){
    			Iterator<Entry<K, V>> entry = oldValue.iterator();
    			while (entry.hasNext()){
    		      this.insert(entry.next().getKey(), entry.next().getValue());
    			}
    		}
    	}
    }

    @SuppressWarnings("unchecked")
	private void clearAndIncreaseSize(){
    	maxSize *= 2;
        int arraySize = HashTable.nextPrime((int) (1.1 * maxSize));
        // Compiler gives a warning.
        table = (Dictionary<K,V>[]) new Dictionary[arraySize];
        for ( int i = 0; i < arraySize; i++ )
            //TODO: Original comentado para nao dar erro de compilacao.
            table[i] = new OrderedDoubleList<K,V>();
        currentSize = 0;
    }
    
	// If there is an entry in the dictionary whose key is the specified key,
    // removes it from the dictionary and returns its value;
    // otherwise, returns null.
    public V remove( K key )
    {	V value = table[ this.hash(key) ].remove(key);
    	if(value != null)
    		currentSize--;
        return value;
    }


    // Returns an iterator of the entries in the dictionary.
    public Iterator<Entry<K,V>> iterator( )
    {
    	TwoWayIterator<Entry<K,V>> iterator = new ChainedHTIterator<K, V>(table);
        return iterator;
    } 


}





