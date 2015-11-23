package dataStructures;

import exceptions.EmptyQueueException;

public class QueueInList<E> implements IterableQueue<E>
{ 

    static final long serialVersionUID = 0L;


    // Memory of the queue: a list.
    protected List<E> list;                     


    public QueueInList(){
    	list = new DoublyLinkedList<E>();
    }


    // Returns true iff the queue contains no elements.
    public boolean isEmpty( ) 
    {
        return list.isEmpty();
    }


    // Returns the number of elements in the queue.
    public int size( )        
    {
        return list.size();
    }

                                             
    // Inserts the specified element at the rear of the queue.
    public void enqueue( E element )
    {    
        list.addLast(element);
    }


    // Removes and returns the element at the front of the queue.
    public E dequeue( ) throws EmptyQueueException   
    {
        if ( list.isEmpty() )
            throw new EmptyQueueException("Queue is empty.");

        return list.removeFirst();
    }

    public Iterator<E> iterator(){
    	return list.iterator();
    }
}
