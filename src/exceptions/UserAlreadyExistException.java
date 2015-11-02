package exceptions;

public class UserAlreadyExistException extends Exception {

    static final long serialVersionUID = 0L;


    public UserAlreadyExistException( )
    {
        super();
    }

    public UserAlreadyExistException( String message )
    {
        super(message);
    }
}
