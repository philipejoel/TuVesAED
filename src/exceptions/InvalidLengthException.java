package exceptions;

public class InvalidLengthException extends Exception {


	private static final long serialVersionUID = 1L;

	public InvalidLengthException( )
    {
        super();
    }

    public InvalidLengthException( String message )
    {
        super(message);
    }
}
