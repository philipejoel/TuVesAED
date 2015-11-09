/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

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
