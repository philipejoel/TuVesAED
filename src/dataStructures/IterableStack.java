/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package dataStructures;


public interface IterableStack<E> extends Stack<E> {
    // Remove all elements from the stack.
   	void clear();
   	
    Iterator<E> iterator();
}
