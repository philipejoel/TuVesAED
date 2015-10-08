package tuVes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

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

public class PlayerClass implements Player, Serializable{


	private static final long serialVersionUID = 1L;
	private User user;
	private Video video;
	private String tag;
	
	public PlayerClass(){
		user = null;
		video = null;
		tag = "";
	}
	
	
	public void insertUser(String nick, String email, String name){
		/*if (usersByNick.containsKey(nick))
			throw new UserAlreadyExistsException();*/    //not needed yet
		User u = new UserClass(nick, email, name);
		user = u;
		
	}
	public void insertVideo(String idVideo, String nick, String url, long length,String title)
			throws NoSuchUserException, InvalidLengthException {
		if (user == null || !user.getNick().equals(nick))//SOLVE
			throw new NoSuchUserException();
		else if ((length%1 != 0) || (length<=0))
			throw new InvalidLengthException();
		else{
			Video v = new VideoClass(idVideo, title, url, length);
			video = v;
			user.addVideo(v);
		}
	}
	public void disableVideo(String idVideo) 
			throws NoSuchVideoException, DisabledVideoException{
		if (video == null || !video.getIdVideo().equals(idVideo))//SOLVE
			throw new NoSuchVideoException();
		else if (video.isVideoDisabled())
			throw new DisabledVideoException();
		else
			video.disableVideo();
	}
	public void playVideo(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException {
		if (video == null || !video.getIdVideo().equals(idVideo))//SOLVE
			throw new NoSuchVideoException();
		else if (user == null || !user.getNick().equals(nick))//SOLVE
			throw new NoSuchUserException();
		else if (video.isVideoDisabled())
			throw new DisabledVideoException();
		else
			user.addVideoToHistory(video);
	}
	public Iterator<Video> listHistory(String nick)
			throws NoSuchUserException, EmptyHistoryException {
		if (user == null || !user.getNick().equals(nick))//SOLVE
			throw new NoSuchUserException();
		else if (!user.hasHistory())
			throw new EmptyHistoryException();
		else
			return user.viewedVideosIterator();
	}
	public void removeHistory(String nick)
			throws NoSuchUserException{
		if (user == null || !user.getNick().equals(nick))//SOLVE
			throw new NoSuchUserException();
		else
			user.removeViewedHistory();
	}
	public void addVideoToFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException, AlreadyFavouriteException{
		if (video == null || !video.getIdVideo().equals(idVideo))
			throw new NoSuchVideoException();
		else if (user == null || !user.getNick().equals(nick))
			throw new NoSuchUserException();
		else if (video.isVideoDisabled())
			throw new DisabledVideoException();
		else if (user.isFavourite(idVideo))
			throw new AlreadyFavouriteException();
		else
			user.addVideoToFavourite(video);
	}
	public void removeVideoFromFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException {
		if (video == null || !video.getIdVideo().equals(idVideo))
			throw new NoSuchVideoException();
		else if (user == null || !user.getNick().equals(nick))
			throw new NoSuchUserException();
		else if (!user.isFavourite(idVideo))
			throw new NoFavouriteVideoException();
		else
			user.removeVideoFromFavourite(idVideo);
	}
	public String listFavourites(String nick) 
			throws NoSuchUserException, NoFavouritesException{
		if (user == null || !user.getNick().equals(nick))
			throw new NoSuchUserException();
		else if (!user.hasFavourite())
			throw new NoFavouritesException();
		else
			return user.favouriteVideos();
	}
	public void addTagToVideo(String idVideo, String tag) 
			throws NoSuchVideoException, DisabledVideoException, AlreadyHasTagException {
		if(video == null || !video.getIdVideo().equals(idVideo))
			throw new NoSuchVideoException();
		else if(video.isVideoDisabled())
			throw new DisabledVideoException();
		else if(video.hasTags())
			throw new AlreadyHasTagException();
		else{
			this.tag = tag;
			video.addTagToVideo(tag);	
		}
	}
	public String listTags(String idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException{
		if (video == null || !video.getIdVideo().equals(idVideo))
			throw new NoSuchVideoException();
		else if (!video.hasTags())
			throw new NoTagsInVideoException();
		else
			return video.getTags();
			
	}
	public String searchTag(String tag) 
		throws NoSuchTagException{
		if (!this.tag.equals(tag))
			throw new NoSuchTagException();
		else
			if(video.getTags().equals(tag)){
				return video.getVideoInfo();
			}
		return null;
	}
	
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream file = new ObjectInputStream(new FileInputStream(fileName));
		user = (User) file.readObject();
		video = (Video) file.readObject();
		tag = (String) file.readObject();
		file.close();
	}
	
	public void save(String fileName)  throws IOException{
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
		file.writeObject(user);
		file.writeObject(video);
		file.writeObject(tag);
		file.flush();
		file.close();
	}
}
