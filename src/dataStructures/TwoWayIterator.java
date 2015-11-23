/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package dataStructures;

public interface TwoWayIterator<E> extends Iterator<E>
{

    // Returns true iff the iteration has more elements
    // in the reverse direction.
    // In other words, returns true if previous would return an element 
    // rather than throwing an exception.
    boolean hasPrevious( );

    // Returns the previous element in the iteration.
    E previous( ) throws NoSuchElementException;

    // Restarts the iteration in the reverse direction.
    // After fullForward, if the iteration is not empty,
    // previous will return the last element in the iteration.
    void fullForward( );

}
