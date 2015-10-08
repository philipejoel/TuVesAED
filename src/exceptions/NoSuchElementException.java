/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package exceptions;

public class NoSuchElementException extends RuntimeException
{

    static final long serialVersionUID = 0L;


    public NoSuchElementException( )
    {
        super();
    }

    public NoSuchElementException( String message )
    {
        super(message);
    }

}

