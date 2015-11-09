/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package dataStructures;

public class OrderedDoubleList <K extends Comparable <K>, V> implements OrderedDictionary<K, V>{
	

	private static final long serialVersionUID = 1L;
	private DListNode <Entry <K, V>> head;
	private DListNode <Entry <K, V>> tail;
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
		DListNode<Entry <K, V>> node = head;
		
        while (node != null && (node.getElement()).getKey().compareTo(key) != 0)
			node.getNext();

        if (node != null)
        	return (node.getElement()).getValue();
        else
        	return null;
	}

	
	public V insert(K key, V value) {
		if(this.isEmpty()){
			DListNode<Entry <K, V>> newNode = getNewNode(key, value);
			head = newNode;
			tail = newNode;
			currentSize++;
		}else{
			DListNode<Entry <K, V>> node = head;
	        while (node != null && node.getElement().getKey().compareTo(key) < 0)
	        	node = node.getNext();
        
	        if (node != null){
	        	if (node.getElement().getKey().equals(key)){
	        		DListNode<Entry <K, V>> updatedNode = getNewNode(key, value);
	        		V oldValue = node.getElement().getValue();
	        		node = updatedNode;
	        		return oldValue;
	        	}
	        	else/*if it's bigger - we need to add our node in front of else node*/{
	        		DListNode<Entry <K, V>> newNode = getNewNode(key, value);
	        		addFrontNode(node, newNode);
	        	}
	        }
	        else/*if it's null - we need to add our node after last node*/{
	        	DListNode<Entry <K, V>> newNode = getNewNode(key, value);
	        	addLastNode(newNode);
	        }
		}	
		return null;
	}
	
	protected DListNode<Entry <K, V>> getNewNode(K key, V value){
		Entry<K, V> entry = new EntryClass<K, V>(key, value);
		DListNode<Entry <K, V>> newNode = new DListNode<Entry <K, V>>(entry);
		return newNode;
	}
	
	//	method to add New node in front of other node, 
	//  this methos is used to append new node in chain before node with higher key
	protected void addFrontNode(DListNode<Entry <K, V>> node, DListNode<Entry <K, V>> newNode){
		if(node == head){
			newNode.setNext(node);
			node.setPrevious(newNode);
			head = newNode;
			currentSize++;
		}else{
	    	DListNode<Entry <K, V>> nodePrev = node.getPrevious();
	    	nodePrev.setNext(newNode);
	    	newNode.setNext(node);
			newNode.setPrevious(nodePrev);
			node.setPrevious(newNode);
			currentSize++;
		}
	}
	//	method to add New node in at the end of the dictionary, 
	// this methos is used to append new node in chain when rest nodes have lower value
	protected void addLastNode(DListNode<Entry <K, V>> newNode){
		newNode.setPrevious(tail);
		tail.setNext(newNode);
		tail = newNode;
		currentSize++;
	}
	
	@Override
	public V remove(K key) {
		DListNode<Entry <K, V>> node = findNode(key);

		if(node == null)
			return null;
		else if(node == head){
			DListNode<Entry <K, V>> nextNode = node.getNext();
			nextNode.setPrevious(null);
			head = nextNode;
			currentSize--;
			return node.getElement().getValue();
		}else if(node == tail){
			DListNode<Entry <K, V>> prevNode = node.getPrevious();
			prevNode.setNext(null);
			tail = prevNode;
			currentSize--;
			return node.getElement().getValue();
		}else{
			DListNode<Entry <K, V>> prevNode = node.getPrevious();
			DListNode<Entry <K, V>> nextNode = node.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrevious(prevNode);
			currentSize--;
			return node.getElement().getValue();
		}
	}
	

	@Override
	public Entry<K, V> minEntry() throws EmptyDictionaryException {
		return head.getElement();
	}

	@Override
	public Entry<K, V> maxEntry() throws EmptyDictionaryException {
		return tail.getElement();
	}
	
	// Returns the node with the first occurrence of the specified element
    // in the list, if the list contains the element.
    // Otherwise, returns null.
	protected DListNode<Entry <K, V>> findNode (K key){
		
		DListNode<Entry <K, V>> node = head;
		
		while (node != null & node.getElement().getKey().compareTo(key) != 0){
			node.getNext();
		}
			return node;
	}

	public Iterator<Entry<K, V>> iterator() {
		return (Iterator<Entry<K, V>>)(new DoublyLLIterator<>(head, tail));
	}
	
}
