/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import dataStructures.Entry;
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
import exceptions.UserAlreadyExistException;
import exceptions.UserHasNoVideosException;
import exceptions.VideoAlreadyExistException;

public interface Player {

	// Inserts a user in the system.
	public void insertUser(String nick, String email, String name) 
			throws UserAlreadyExistException;
	
	// Inserts a video in the system.
	public void insertVideo(String idVideo, String nick, String URL, long length, String title)
			throws NoSuchUserException, InvalidLengthException, VideoAlreadyExistException ;
	
	// Disables a video.
	public void disableVideo(String idVideo) 
			throws NoSuchVideoException, DisabledVideoException;
	
	// Plays a video.
	public void playVideo(String idVide, String nick)
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException;
	
	/*public String listUserVideos(String nick) 
	 * throws NoSuchUserException, UserHasNoVideosException;*/
	
	public Iterator<Entry<String, Video>> getUserVideosIterator(String nick) 
			throws NoSuchUserException, UserHasNoVideosException;
	
	// Returns an iterator of viewed videos.
	public Iterator<Video> listHistoryIterator(String nick)
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
	public Iterator<Entry<String, Video>> listFavouritesIterator(String nick) 
			throws NoSuchUserException, NoFavouritesException;
	// Adds a tag to a video.
	public void addTagToVideo(String idVideo, String tag) 
			throws NoSuchVideoException, DisabledVideoException, AlreadyHasTagException;
	
	// Returns the information related to a video's tags.
	public Iterator<String> listTagsIterator(String idVideo)
			throws NoSuchVideoException, NoTagsInVideoException;
	
	// Returns the information related to a video to which the tag was assigned.
	public Iterator<Entry<String, Video>> getTagVideosIterator(String tag)
			throws NoSuchTagException;
	
}
