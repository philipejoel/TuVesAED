package exceptions;

public class NoTagsInVideoException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoTagsInVideoException( )
    {
        super();
    }

    public NoTagsInVideoException( String message )
    {
        super(message);
    }
}
