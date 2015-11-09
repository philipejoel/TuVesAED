/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import java.io.Serializable;

import dataStructures.ChainedHashTable;
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

public class PlayerClass implements Player, Serializable{

/***
* @users Chained hash table of users added to the system
* @videos Chained hash table of videos added to the system
* @tags Chained hash table of tags added to the system
***/
	private static final long serialVersionUID = 1L;
	private ChainedHashTable<String, UserSetter> users;
	private ChainedHashTable<String, VideoSetter> videos;
	private ChainedHashTable<String, VideoSetter> tags;
	
	public PlayerClass(){
		users = new ChainedHashTable<String, UserSetter>();
		videos = new ChainedHashTable<String, VideoSetter>();
		tags = new ChainedHashTable<String, VideoSetter>();
	}
	
	public void insertUser(String nick, String email, String name) throws UserAlreadyExistException{

		if(users.find(nick.toLowerCase()) != null){
			throw new UserAlreadyExistException(); 
		}
		else{
			UserSetter u = new UserClass(nick, email, name);
			users.insert(nick.toLowerCase(), u);
		}
	}
	
	public void insertVideo(String idVideo, String nick, String url, long length,String title)
			throws NoSuchUserException, InvalidLengthException, VideoAlreadyExistException {

		if(videos.find(idVideo.toLowerCase()) != null)
			throw new VideoAlreadyExistException(); 
		else if (users.find(nick.toLowerCase()) == null)
			throw new NoSuchUserException();
		else if ((length%1 != 0) || (length<=0))
			throw new InvalidLengthException();
		else{
			VideoSetter v = new VideoClass(idVideo, title, url, length);
			videos.insert(idVideo.toLowerCase(), v);
			users.find(nick.toLowerCase()).addVideo(v);
		}
	}
	
	public void disableVideo(String idVideo) 
			throws NoSuchVideoException, DisabledVideoException{

		VideoSetter v = videos.find(idVideo.toLowerCase());
		if (v == null)//SOLVE
			throw new NoSuchVideoException();
		else if (v.isVideoDisabled())
			throw new DisabledVideoException();
		else
			v.disableVideo();
	}
	
	public void playVideo(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException {

		VideoSetter v = videos.find(idVideo.toLowerCase());
		UserSetter u = users.find(nick.toLowerCase());
		if (v == null)//SOLVE
			throw new NoSuchVideoException();
		else if (u == null)//SOLVE
			throw new NoSuchUserException();
		else if (v.isVideoDisabled())
			throw new DisabledVideoException();
		else
			u.addVideoToHistory(v);
	}
	
	public String listUserVideos(String nick) throws NoSuchUserException, UserHasNoVideosException{
		UserSetter u = users.find(nick.toLowerCase());
		if (u == null)
			throw new NoSuchUserException();
		else if (!u.hasVideo())
			throw new UserHasNoVideosException();
		else
			return u.listVideos();
	}
	
	public Iterator<Video> listHistory(String nick)
			throws NoSuchUserException, EmptyHistoryException {

		UserSetter u = users.find(nick.toLowerCase());
		if (u == null)//SOLVE
			throw new NoSuchUserException();
		else if (!u.hasHistory())
			throw new EmptyHistoryException();
		else
			return u.viewedVideosIterator();
	}
	
	public void removeHistory(String nick)
			throws NoSuchUserException{

		UserSetter u = users.find(nick.toLowerCase());
		if (u == null)//SOLVE
			throw new NoSuchUserException();
		else
			u.removeViewedHistory();
	}
	
	public void addVideoToFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException, AlreadyFavouriteException{

		UserSetter u = users.find(nick.toLowerCase());
		VideoSetter v = videos.find(idVideo.toLowerCase());
		if (v == null)
			throw new NoSuchVideoException();
		else if (u == null)
			throw new NoSuchUserException();
		else if (v.isVideoDisabled())
			throw new DisabledVideoException();
		else if (u.isFavourite(idVideo))
			throw new AlreadyFavouriteException();
		else
			u.addVideoToFavourite(v);

	}
	
	public void removeVideoFromFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException {

		UserSetter u = users.find(nick.toLowerCase());
		VideoSetter v = videos.find(idVideo.toLowerCase());
		if (v == null)
			throw new NoSuchVideoException();
		else if (u == null)
			throw new NoSuchUserException();
		else if (!u.isFavourite(idVideo))
			throw new NoFavouriteVideoException();
		else
			u.removeVideoFromFavourite(idVideo);
	}
	
	public String listFavourites(String nick) 
			throws NoSuchUserException, NoFavouritesException{

		UserSetter u = users.find(nick.toLowerCase());
		if (u == null)
			throw new NoSuchUserException();
		else if (!u.hasFavourite())
			throw new NoFavouritesException();
		else
			return u.favouriteVideos();
	}
	
	public void addTagToVideo(String idVideo, String tag) 
			throws NoSuchVideoException, DisabledVideoException, AlreadyHasTagException {

		VideoSetter v = videos.find(idVideo.toLowerCase());
		if(v == null)
			throw new NoSuchVideoException();
		else if(v.isVideoDisabled())
			throw new DisabledVideoException();
		else if (v.equals(tags.find(tag.toLowerCase())))
			throw new AlreadyHasTagException();
		else{
			v.addTagToVideo(tag);
			tags.insert(tag.toLowerCase(), v);
		}
	}
	
	public Iterator<String> listTags(String idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException{

		VideoSetter v = videos.find(idVideo.toLowerCase());
		if (v == null)
			throw new NoSuchVideoException();
		else if (!v.hasAnyTag())
			throw new NoTagsInVideoException();
		else
			return v.getTags();
	}
	
	public String searchTag(String tag) 
		throws NoSuchTagException{
		
		Video v = tags.find(tag.toLowerCase());
		if (v == null)
			throw new NoSuchTagException();
		else
			return v.getVideoInfo();	
	}
}
