package exceptions;

public class VideoAlreadyExistException extends Exception {

    static final long serialVersionUID = 0L;


    public VideoAlreadyExistException( )
    {
        super();
    }

    public VideoAlreadyExistException( String message )
    {
        super(message);
    }
}
