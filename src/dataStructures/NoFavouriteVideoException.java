package dataStructures;

public class NoFavouriteVideoException extends Exception {
    static final long serialVersionUID = 0L;


    public NoFavouriteVideoException( )
    {
        super();
    }

    public NoFavouriteVideoException( String message )
    {
        super(message);
    }

}
