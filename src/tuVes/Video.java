/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

public interface Video {
	
	//Returns private variable IdVideo
	public String getIdVideo();
	
	//Returns Title of the video
	public String getTitle();
	
	//Returns length of video
	public long getLength();
	
	//Returns private variable Status which 
	//determinate if video is disabled or not
	public String getStatus();
	
	//Returns Tag assigned to video
	public String getTag();
	
	//Returns video information in form: "IdVideo Title Length Status"
	public String getVideoInfo();
	
	//Disable a video
	public void disableVideo();
	
	//Returns boolean value true if video is disabled
	//and false if video is enabled
	public boolean isVideoDisabled();
	
	//Assign tag to video
	public void addTagToVideo(String tag);
	
	//Returns boolean value true if video is has any Tag
	//and false if video has not.
	public boolean hasTags();
	
}
