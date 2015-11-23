package dataStructures;                                         

import java.io.Serializable; 

class BSTNode<K,V> implements Serializable
{                                                                   

    static final long serialVersionUID = 0L;


    // Entry stored in the node.
    private ExtendedEntry<K,V> entry;                                      

    // (Pointer to) the left child.
    private BSTNode<K,V> leftChild;

    // (Pointer to) the right child.
    private BSTNode<K,V> rightChild;


    public BSTNode( K key, V value, BSTNode<K,V> left, BSTNode<K,V> right )
    {                                                                
        entry = new ExtendedEntryClass<K,V>(key, value);
        leftChild = left; 
        rightChild = right;                                      
    }


    public BSTNode( K key, V value )
    {    
        this(key, value, null, null);
    }


    public ExtendedEntry<K,V> getEntry( )                           
    {
        return entry;
    }


    public K getKey( )                           
    {
        return entry.getKey();
    }


    public V getValue( )                           
    {
        return entry.getValue();
    }


    public BSTNode<K,V> getLeft( )                                     
    {    
        return leftChild;
    }


    public BSTNode<K,V> getRight( )                                    
    {    
        return rightChild;
    }


    public void setEntry( ExtendedEntry<K,V> newEntry )
    {    
        entry = newEntry;
    }


    public void setEntry( K newKey, V newValue )
    {    
        entry.setKey(newKey);
        entry.setValue(newValue);
    }


    public void setKey( K newKey )
    {    
        entry.setKey(newKey);
    }


    public void setValue( V newValue )
    {    
        entry.setValue(newValue);
    }


    public void setLeft( BSTNode<K,V> newLeft )                     
    {    
        leftChild = newLeft;
    }


    public void setRight( BSTNode<K,V> newRight )                   
    {    
        rightChild = newRight;
    }


    // Returns true iff the node is a leaf.
    public boolean isLeaf( )                                
    {    
        return leftChild == null && rightChild == null;          
    }                                                                  


}
