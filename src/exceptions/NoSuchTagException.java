/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package exceptions;

public class NoSuchTagException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchTagException( )
    {
        super();
    }

    public NoSuchTagException( String message )
    {
        super(message);
    }
}
