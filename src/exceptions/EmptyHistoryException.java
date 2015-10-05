package exceptions;

public class EmptyHistoryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmptyHistoryException( )
    {
        super();
    }

    public EmptyHistoryException( String message )
    {
        super(message);
    }
}
