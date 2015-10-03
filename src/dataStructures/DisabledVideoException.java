package dataStructures;

public class DisabledVideoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DisabledVideoException( )
    {
        super();
    }

    public DisabledVideoException( String message )
    {
        super(message);
    }
}
