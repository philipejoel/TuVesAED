package dataStructures;

public class NoSuchVideoException extends Exception {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchVideoException( )
    {
        super();
    }

    public NoSuchVideoException( String message )
    {
        super(message);
    }
}
