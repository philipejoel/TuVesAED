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
* @user - user added to the system
* @video - video added to the system
* @tag - tag assigned to video by user
* 
* @users Chained hash table of users added to the system
* @videos Chained hash table of videos added to the system
* @tags Chained hash table of tags added to the system
***/
	private static final long serialVersionUID = 1L;
//  Phase 1 code
//		private String tag = "";
//		private UserSetter user;
//		private VideoSetter video;
//---------------------------------
	private ChainedHashTable<String, UserSetter> users;
	private ChainedHashTable<String, VideoSetter> videos;
	private ChainedHashTable<String, VideoSetter> tags;
	
	public PlayerClass(){
//  Phase 1 code
//		tag = "";
//		user = null;
//		video = null;
//---------------------------------

		users = new ChainedHashTable<String, UserSetter>();
		videos = new ChainedHashTable<String, VideoSetter>();
		tags = new ChainedHashTable<String, VideoSetter>();
	}
	
	public void insertUser(String nick, String email, String name) throws UserAlreadyExistException{
//  Phase 1 code
//		UserSetter u = new UserClass(nick, email, name);
//		user = (UserSetter) u;
//---------------------------------
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
//  Phase 1 code
//		if (user == null || !user.getNick().equals(nick))//SOLVE
//			throw new NoSuchUserException();
//		else if ((length%1 != 0) || (length<=0))
//			throw new InvalidLengthException();
//		else{
//			VideoSetter v = new VideoClass(idVideo, title, url, length);
//			video = v;
//			user.addVideo(v);
//---------------------------------
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
//  Phase 1 code
//		if (video == null || !video.getIdVideo().equals(idVideo))//SOLVE
//			throw new NoSuchVideoException();
//		else if (video.isVideoDisabled())
//			throw new DisabledVideoException();
//		else
//			video.disableVideo();
//---------------------------------
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
//  Phase 1 code
//		if (video == null || !video.getIdVideo().equals(idVideo))//SOLVE
//			throw new NoSuchVideoException();
//		else if (user == null || !user.getNick().equals(nick))//SOLVE
//			throw new NoSuchUserException();
//		else if (video.isVideoDisabled())
//			throw new DisabledVideoException();
//		else
//			user.addVideoToHistory(video);
//-----------------------------------------
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
//  Phase 1 code
//		if (user == null || !user.getNick().equals(nick))//SOLVE
//			throw new NoSuchUserException();
//		else if (!user.hasHistory())
//			throw new EmptyHistoryException();
//		else
//			return user.viewedVideosIterator();
//-----------------------------------------
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
//  Phase 1 code
//		if (user == null || !user.getNick().equals(nick))//SOLVE
//			throw new NoSuchUserException();
//		else
//			user.removeViewedHistory();
//-----------------------------------------
		UserSetter u = users.find(nick.toLowerCase());
		if (u == null)//SOLVE
			throw new NoSuchUserException();
		else
			u.removeViewedHistory();
	}
	
	public void addVideoToFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException, AlreadyFavouriteException{
//  Phase 1 code
//		if (video == null || !video.getIdVideo().equals(idVideo))
//			throw new NoSuchVideoException();
//		else if (user == null || !user.getNick().equals(nick))
//			throw new NoSuchUserException();
//		else if (video.isVideoDisabled())
//			throw new DisabledVideoException();
//		else if (user.isFavourite(idVideo))
//			throw new AlreadyFavouriteException();
//		else
//			user.addVideoToFavourite(video);
//-----------------------------------------
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
//	Phase 1 code
//		if (video == null || !video.getIdVideo().equals(idVideo))
//			throw new NoSuchVideoException();
//		else if (user == null || !user.getNick().equals(nick))
//			throw new NoSuchUserException();
//		else if (!user.isFavourite(idVideo))
//			throw new NoFavouriteVideoException();
//		else
//			user.removeVideoFromFavourite(idVideo);
//------------------------------------------------
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
//	Phase 1 code
//		if (user == null || !user.getNick().equals(nick))
//			throw new NoSuchUserException();
//		else if (!user.hasFavourite())
//			throw new NoFavouritesException();
//		else
//			return user.favouriteVideos();
//------------------------------------------------
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
//	Phase 1 code
//		if(video == null || !video.getIdVideo().equals(idVideo))
//			throw new NoSuchVideoException();
//		else if(video.isVideoDisabled())
//			throw new DisabledVideoException();
//		else if(video.hasTags())
//			throw new AlreadyHasTagException();
//		else{
//			this.tag = tag;
//			video.addTagToVideo(tag);	
//		}
// -----------------------------------		
		VideoSetter v = videos.find(idVideo.toLowerCase());
		if(v == null)
			throw new NoSuchVideoException();
		else if(v.isVideoDisabled())
			throw new DisabledVideoException();
		else if(v.hasTag(tag))
			throw new AlreadyHasTagException();
		else{
			v.addTagToVideo(tag);
			tags.insert(tag.toLowerCase(), v);
		}
	}
	
	public Iterator<String> listTags(String idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException{
//	Phase 1 code
//		if (video == null || !video.getIdVideo().equals(idVideo))
//			throw new NoSuchVideoException();
//		else if (!video.hasTags())
//			throw new NoTagsInVideoException();
//		else
//			return video.getTag();
//------------------------------------------------
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
//	Phase 1 code
//		if (!this.tag.equals(tag))
//			throw new NoSuchTagException();
//		else
//			if(video.getTag().equals(tag)){
//				return video.getVideoInfo();
//			}
//		return null;
//------------------------------------------------
		Video v = tags.find(tag.toLowerCase());
		if (v == null)
			throw new NoSuchTagException();
		else
			return v.getVideoInfo();	
	}
}
