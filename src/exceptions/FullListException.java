/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package exceptions;

public class FullListException extends RuntimeException
{

    static final long serialVersionUID = 0L;


    public FullListException( )
    {
        super();
    }

    public FullListException( String message )
    {
        super(message);
    }

}

