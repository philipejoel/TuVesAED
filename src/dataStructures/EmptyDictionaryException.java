/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */
package dataStructures;

public class EmptyDictionaryException extends Exception {
	

	private static final long serialVersionUID = 1L;

	
	public EmptyDictionaryException( ){
		
		super();
	}
	
	public EmptyDictionaryException( String message ){
		
		super(message);
	}

}
