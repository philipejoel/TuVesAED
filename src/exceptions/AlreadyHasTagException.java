package exceptions;

public class AlreadyHasTagException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyHasTagException( )
    {
        super();
    }

    public AlreadyHasTagException( String message )
    {
        super(message);
    }
}
