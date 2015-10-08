/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import java.io.FileNotFoundException;
import java.io.IOException;
import dataStructures.Iterator;

import exceptions.AlreadyFavouriteException;
import exceptions.AlreadyHasTagException;
import exceptions.DisabledVideoException;
import exceptions.EmptyHistoryException;
import exceptions.InvalidLengthException;
import exceptions.NoFavouriteVideoException;
import exceptions.NoFavouritesException;
import exceptions.NoSuchTagException;
import exceptions.NoSuchUserException;
import exceptions.NoSuchVideoException;
import exceptions.NoTagsInVideoException;

public interface Player {

	// Inserts a user in the system.
	public void insertUser(String nick, String email, String name);
	
	// Inserts a video in the system.
	public void insertVideo(String idVideo, String nick, String URL, long length, String title)
			throws NoSuchUserException, InvalidLengthException ;
	
	// Disables a video.
	public void disableVideo(String idVideo) 
			throws NoSuchVideoException, DisabledVideoException;
	
	// Plays a video.
	public void playVideo(String idVide, String nick)
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException ;
	
	// Returns an iterator of viewed videos.
	public Iterator<Video> listHistory(String nick)
			throws NoSuchUserException, EmptyHistoryException;
	
	// Cleans the viewed videos history.
	public void removeHistory(String nick) 
			throws NoSuchUserException;
	
	// Adds a video to the favourites.
	public void addVideoToFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException, AlreadyFavouriteException;
	
	// Removes a video from the favourites.
	public void removeVideoFromFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException;
	
	// Returns the information related an user's favourite videos.
	public String listFavourites(String nick) 
			throws NoSuchUserException, NoFavouritesException;
	// Adds a tag to a video.
	public void addTagToVideo(String idVideo, String tag) 
			throws NoSuchVideoException, DisabledVideoException, AlreadyHasTagException;
	
	// Returns the information related to a video's tags.
	public String listTags(String idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException;
	
	// Returns the information related to a video to which the tag was assigned.
	public String searchTag(String tag) 
			throws NoSuchTagException;
	
	// Loads the system from a file.
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
	
	// Saves the system to a file.
	public void save(String fileName)  throws IOException;
	
}
