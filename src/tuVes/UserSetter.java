/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

public interface UserSetter extends User{
	// Adds a video to the user's videos.
	public void addVideo(Video video);
	
	// Adds a video to the user's favourite videos.
	public void addVideoToFavourite(Video video);
	
	// Removes a video from the user's favourite videos.
	public void removeVideoFromFavourite(String idVideo);
	
	// Adds a video to the user's veiwed videos.
	public void addVideoToHistory(Video video);
	
	// Removes all videos from the user's viewed videos.
	public void removeViewedHistory();
}
