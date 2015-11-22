package dataStructures;

public class BSTKeyOrderIterator<K,V> implements Iterator<Entry<K,V>> {


	private static final long serialVersionUID = 1L;
	private Stack<BSTNode<K,V>> BSTStack;
	private BSTNode<K, V> root;
	
	public BSTKeyOrderIterator(BSTNode<K,V> root) {
		BSTStack = new StackInList<BSTNode<K,V>>();
		this.root = root;
		rewind();
	}
	
	

	public boolean hasNext() {
		return !BSTStack.isEmpty();
	}

	public Entry<K, V> next() throws NoSuchElementException {
		BSTNode<K, V> nodeToReturn = BSTStack.pop();
		if(nodeToReturn.getRight() != null){
			appendAllLeft(nodeToReturn.getRight());
		}
		return nodeToReturn.getEntry();
	}

	public void rewind() {
		appendAllLeft(root);
	}
	
	public void appendAllLeft(BSTNode<K, V> node){
		while (node != null){
			BSTStack.push(node);
			node = node.getLeft();
		}
	}

}
