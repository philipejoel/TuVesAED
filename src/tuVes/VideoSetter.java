/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

public interface VideoSetter extends Video{
	
	//Disable a video
	public void disableVideo();
	
	//Assign tag to video
	public void addTagToVideo(String tag);

}
