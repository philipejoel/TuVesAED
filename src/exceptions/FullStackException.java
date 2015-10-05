package exceptions;

public class FullStackException extends RuntimeException
{

    static final long serialVersionUID = 0L;


    public FullStackException( )
    {
        super();
    }

    public FullStackException( String message )
    {
        super(message);
    }

}

