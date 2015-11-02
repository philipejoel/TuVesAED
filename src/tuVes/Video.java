/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import dataStructures.Iterator;

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
	public  Iterator<String> getTags();
	
	//Returns video information in form: "IdVideo Title Length Status"
	public String getVideoInfo();
	
	
	//Returns boolean value true if video is disabled
	//and false if video is enabled
	public boolean isVideoDisabled();
	
	
	//Returns boolean value true if video is has any Tag
	//and false if video has not.
	public boolean hasAnyTag();
	
	//Returns boolean value true if video is has specific Tag passed as a variable
	//and false if video has not.
	public boolean hasTag(String tag);
	
}
