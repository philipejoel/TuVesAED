/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package dataStructures;

import java.io.Serializable;

public interface Iterator<E> extends Serializable
{

    // Returns true iff the iteration has more elements. 
    // In other words, returns true if next would return an element 
    // rather than throwing an exception.
    boolean hasNext( );

    // Returns the next element in the iteration.
    E next( ) throws NoSuchElementException;

    // Restarts the iteration.
    // After rewind, if the iteration is not empty,
    // next will return the first element in the iteration.
    void rewind( );

}
