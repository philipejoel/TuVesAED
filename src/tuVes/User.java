/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;


import dataStructures.Iterator;
import exceptions.EmptyHistoryException;

public interface User {
	
	// Adds a video to the user's videos.
	public void addVideo(Video video);
	
	// Adds a video to the user's favourite videos.
	public void addVideoToFavourite(Video video);
	
	// Removes a video from the user's favourite videos.
	public void removeVideoFromFavourite(String idVideo);
	
	// Adds a video to the user's veiwed videos.
	public void addVideoToHistory(Video video);
	
	// Returns true if the video if one of the user's favourite videos. Returns false if it isn't.
	public boolean isFavourite(String idVideo);
	
	// Returns an iterator of the user's viewed videos.
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException;
	
	// Returns information related to the user's favourite videos (only one in the first phase).
	public String favouriteVideos();
	
	// Removes all videos from the user's viewed videos.
	public void removeViewedHistory();
	
	// Returns true if the user viewed at least one video after cleaning the history.
	public boolean hasHistory();
	
	// Returns true if the user has at least one favourite video.
	public boolean hasFavourite();
	
	// Returns the user's nick.
	public String getNick();
	
}
