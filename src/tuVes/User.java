/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;


import dataStructures.Iterator;
import exceptions.EmptyHistoryException;

public interface User {
		
	// Returns true if the video if one of the user's favourite videos. Returns false if it isn't.
	public boolean isFavourite(String idVideo);
	
	// Returns an iterator of the user's viewed videos.
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException;
	
	// Returns information related to the user's favourite videos.
	public String favouriteVideos();
	
	//Returns information about user's videos.
	public String listVideos();
	
	// Returns true if the user viewed at least one video after cleaning the history.
	public boolean hasHistory();
	
	// Returns true if the user has at least one favourite video.
	public boolean hasFavourite();
	
	// Returns the user's nick.
	public String getNick();
	
	// Returns true if the user has any video (inserted by him).
	boolean hasVideo();
	
}
