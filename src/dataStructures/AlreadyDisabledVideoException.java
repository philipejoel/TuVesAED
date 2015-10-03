package dataStructures;

public class AlreadyDisabledVideoException extends Exception {
    

	private static final long serialVersionUID = 1L;

	public AlreadyDisabledVideoException( )
    {
        super();
    }

    public AlreadyDisabledVideoException( String message )
    {
        super(message);
    }
}
