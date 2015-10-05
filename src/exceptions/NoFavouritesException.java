package exceptions;

public class NoFavouritesException extends Exception {


	private static final long serialVersionUID = 1L;

	public NoFavouritesException( )
    {
        super();
    }

    public NoFavouritesException( String message )
    {
        super(message);
    }
}
