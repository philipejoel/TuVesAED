package exceptions;

public class UserHasNoVideosException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public UserHasNoVideosException( )
    {
        super();
    }

    public UserHasNoVideosException( String message )
    {
        super(message);
    }
}
