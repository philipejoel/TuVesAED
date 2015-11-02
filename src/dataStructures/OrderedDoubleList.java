package dataStructures;

public class OrderedDoubleList <K extends Comparable <K>, V> implements OrderedDictionary<K, V>{
	

	private static final long serialVersionUID = 1L;
	private DListNode <ExtendedEntry <K, V>> head;
	private DListNode <ExtendedEntry <K, V>> tail;
	private int currentSize;
	
	
    public OrderedDoubleList( )
    {
        head = null;
        tail = null;
        currentSize = 0;
    }

    // Returns true iff the list contains no elements.
	public boolean isEmpty(){
		return currentSize == 0;
	}

	
	public int size(){
		return currentSize;
	}

	public V find(K key) {
		DListNode<ExtendedEntry <K, V>> node = head;
		
        while (node != null && (node.getElement()).getKey().compareTo(key) != 0)
			node.getNext();

        if (node != null)
        	return (node.getElement()).getValue();
        else
        	return null;
	}

	
	public V insert(K key, V value) {
		if(this.isEmpty()){
			DListNode<ExtendedEntry <K, V>> newNode = getNewNode(key, value);
			head = newNode;
			tail = newNode;
			currentSize++;
		}else{
			DListNode<ExtendedEntry <K, V>> node = head;
	        while (node != null && node.getElement().getKey().compareTo(key) < 0)
	        	node = node.getNext();
        
	        if (node != null){
	        	if (node.getElement().getKey().equals(key))
	        		return node.getElement().setValue(value);
	        	else/*if it's bigger*/{
	        		DListNode<ExtendedEntry <K, V>> newNode = getNewNode(key, value);
	        		addFrontNode(node, newNode);
	        		newNode.setNext(node);
        			node.setPrevious(newNode);
	        	}
	        }
	        else/*if it's null*/{
	        	DListNode<ExtendedEntry <K, V>> newNode = getNewNode(key, value);
	        	addFrontNode(node, newNode);
	        }
		}	
		return null;
	}
	
	protected DListNode<ExtendedEntry <K, V>> getNewNode(K key, V value){
		ExtendedEntry<K, V> entry = new ExtendedEntryClass<K, V>(key, value);
		DListNode<ExtendedEntry <K, V>> newNode = new DListNode<ExtendedEntry <K, V>>(entry);
		return newNode;
	}
	
	protected void addFrontNode(DListNode<ExtendedEntry <K, V>> node, DListNode<ExtendedEntry <K, V>> newNode){
    	DListNode<ExtendedEntry <K, V>> nodePrev = node.getPrevious();
    	nodePrev.setNext(newNode);
		newNode.setPrevious(nodePrev);
		currentSize++;
	}

	@Override
	public V remove(K key) {
		DListNode<ExtendedEntry <K, V>> node = findNode(key);

		if(node == null)
			return null;
		else if(node == head){
			DListNode<ExtendedEntry <K, V>> nextNode = node.getNext();
			nextNode.setPrevious(null);
			head = nextNode;
			currentSize--;
			return node.getElement().getValue();
		}else if(node == tail){
			DListNode<ExtendedEntry <K, V>> prevNode = node.getPrevious();
			prevNode.setNext(null);
			tail = prevNode;
			currentSize--;
			return node.getElement().getValue();
		}else{
			DListNode<ExtendedEntry <K, V>> prevNode = node.getPrevious();
			DListNode<ExtendedEntry <K, V>> nextNode = node.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrevious(prevNode);
			currentSize--;
			return node.getElement().getValue();
		}
	}
	

	@Override
	public ExtendedEntry<K, V> minEntry() throws EmptyDictionaryException {
		return head.getElement();
	}

	@Override
	public ExtendedEntry<K, V> maxEntry() throws EmptyDictionaryException {
		return tail.getElement();
	}
	
	// Returns the node with the first occurrence of the specified element
    // in the list, if the list contains the element.
    // Otherwise, returns null.
	protected DListNode<ExtendedEntry <K, V>> findNode (K key){
		
		DListNode<ExtendedEntry <K, V>> node = head;
		
		while (node != null & node.getElement().getKey().compareTo(key) != 0){
			node.getNext();
		}
			return node;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		DoublyLLIterator<Entry<K, V>> iterator;
		iterator = new DoublyLLIterator(head, tail);
		return iterator;
		
		//return new DoublyLLIterator((E)head, (E)tail);
	}
	
	
	
//	public V insert2(K key, V value) {
//						
//		if(this.isEmpty()){
//			ExtendedEntry<K, V> entry = new ExtendedEntryClass<K, V>(key, value);
//			DListNode<ExtendedEntry <K, V>> newNode = new DListNode<ExtendedEntry <K, V>>(entry);
//			head = newNode;
//			tail = newNode;
//			currentSize++;
//		}else{
//			DListNode<ExtendedEntry <K, V>> node = head;
//			
//			while (node.getElement().getKey().compareTo(key) < 0 && node != null)
//				node = node.getNext(); // key of node is bigger or equal to our new node
//			
//			if (node.getElement().getKey().equals(key))
//        		return node.getElement().setValue(value);
//			else if(node == null)
//				this.addLast(key, value);
//			else
//				this.addBefore(key, value, node);
//			
//		}
//		
//		return null;
//	}
//
//	private void addBefore(K key, V value, DListNode<ExtendedEntry<K, V>> nextNode) {
//		if(nextNode == head){
//			ExtendedEntry<K, V> entry = new ExtendedEntryClass<K, V>(key, value);
//			DListNode<ExtendedEntry <K, V>> newNode = new DListNode<ExtendedEntry <K, V>>(entry,null, head);
//			head.setPrevious(newNode);
//			head = newNode;
//	        currentSize++;
//		}else{
//			DListNode<ExtendedEntry<K, V>> prevNode = nextNode.getPrevious();
//			ExtendedEntry<K, V> entry = new ExtendedEntryClass<K, V>(key, value);
//			DListNode<ExtendedEntry <K, V>> newNode = new DListNode<ExtendedEntry <K, V>>(entry, prevNode, nextNode);
//			prevNode.setNext(newNode);
//			nextNode.setPrevious(newNode);
//			currentSize++;
//		}
//	}
//
//	private void addLast(K key, V value) {
//		ExtendedEntry<K, V> entry = new ExtendedEntryClass<K, V>(key, value);
//		DListNode<ExtendedEntry <K, V>> newNode = new DListNode<ExtendedEntry <K, V>>(entry,tail, null);
//		tail.setNext(newNode);
//		tail = newNode;
//        currentSize++;
//	}

	
}
