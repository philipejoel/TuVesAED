package exceptions;

public class EmptyQueueException extends Exception {
    
	static final long serialVersionUID = 0L;

    public EmptyQueueException( )
    {
        super();
    }

    public EmptyQueueException( String message )
    {
        super(message);
    }
}
