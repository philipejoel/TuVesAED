/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package dataStructures;

public class InvalidPositionException extends RuntimeException
{

    static final long serialVersionUID = 0L;


    public InvalidPositionException( )
    {
        super();
    }

    public InvalidPositionException( String message )
    {
        super(message);
    }

}

