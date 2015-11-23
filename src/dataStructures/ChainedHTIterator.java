/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */
package dataStructures;

public class ChainedHTIterator<K,V> implements TwoWayIterator<Entry <K,V>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Dictionary<K,V>[] table;
	protected int currentIndex; //Current index of HashTable Array
	protected TwoWayIterator<Entry<K, V>> currentDicIterator;
	
	public ChainedHTIterator(Dictionary<K,V>[] table) {
		this.table = table;
		this.rewind();
	}
	// Finds and returns the next
	private TwoWayIterator<Entry<K,V>> findNextNotNull(){
		for(int i = currentIndex+1; i < table.length; i++){
			if(!table[i].isEmpty()){
				currentIndex = i;
				return (TwoWayIterator<Entry<K, V>>) table[i].iterator();
			}
		}
		return null;
	}
	
	private TwoWayIterator<Entry<K,V>> findPrevNotNull(){
		for(int i = currentIndex-1; i >= 0; i--){
			if(!table[i].isEmpty()){
				currentIndex = i;
				TwoWayIterator<Entry<K, V>> tab = (TwoWayIterator<Entry<K, V>>) table[i].iterator();
				tab.fullForward();
				return tab;
			}
		}
		return null;
	}
		
	public boolean hasNext() {
		if(currentDicIterator != null && currentDicIterator.hasNext())
			return true;
		else{
			for(int i = currentIndex+1; i < table.length; i++){
				if(!table[i].isEmpty())
					return true;
			}
			return false;
		}
	}
	
	public Entry<K, V> next() throws NoSuchElementException {
		if(currentDicIterator.hasNext()){
			return currentDicIterator.next();
		}else{
			 currentDicIterator = findNextNotNull();
			 if(currentDicIterator != null){
				 return currentDicIterator.next();
			 }else{
				 System.out.println("I'm HERE");
				 throw new NoSuchElementException();
			 }
		}
	}
	
	public void rewind() {
		//currentIteration = 0;
		//currentDictionaryPosition = 0;
		//his.dictionaryIterator = table[currentIteration].iterator();
		currentIndex = 0;
		currentDicIterator = findNextNotNull();
	}
	
	public boolean hasPrevious() {
		if(currentDicIterator.hasPrevious())
			return true;
		else{
			for(int i = currentIndex-1; i >= 0; i--){
				if(table[i] != null)
					return true;
			}
			return false;
		}
	}
	
	public Entry<K, V> previous() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(currentDicIterator.hasPrevious()){
			return currentDicIterator.previous();
		}else{
			 currentDicIterator = findPrevNotNull();
			 if(currentDicIterator != null){
				 return currentDicIterator.previous();
			 }else{
				 throw new NoSuchElementException();
			 }
		}
	}
	
	public void fullForward() {
		currentIndex = table.length;
		currentDicIterator = findPrevNotNull();
	}

}
