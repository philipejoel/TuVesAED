/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package exceptions;

public class NoTagsInVideoException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoTagsInVideoException( )
    {
        super();
    }

    public NoTagsInVideoException( String message )
    {
        super(message);
    }
}
