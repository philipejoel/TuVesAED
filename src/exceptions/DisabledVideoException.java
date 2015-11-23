/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package exceptions;

public class DisabledVideoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DisabledVideoException( )
    {
        super();
    }

    public DisabledVideoException( String message )
    {
        super(message);
    }
}
