package exceptions;

public class AlreadyFavouriteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AlreadyFavouriteException( )
    {
        super();
    }

    public AlreadyFavouriteException( String message )
    {
        super(message);
    }
}
