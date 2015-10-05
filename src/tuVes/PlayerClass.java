package tuVes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import exceptions.DisabledVideoException;
import exceptions.EmptyHistoryException;
import exceptions.InvalidLengthException;
import exceptions.NoFavouriteVideoException;
import exceptions.NoFavouritesException;
import exceptions.NoSuchTagException;
import exceptions.NoSuchUserException;
import exceptions.NoSuchVideoException;
import exceptions.NoTagsInVideoException;

public class PlayerClass implements Player {

	private Map<StringTokenizer, User> usersByNick;
	private Map<StringTokenizer, Video> videosById;
	private StringTokenizer tag;
	
	//update save and load after tag's problem solved
	
	
	public PlayerClass(){
		usersByNick = new HashMap<StringTokenizer/*nick*/, User>();
		videosById = new HashMap<StringTokenizer/*idVideo*/, Video>();
		tag = null;
	}
	
	
	public void insertUser(StringTokenizer nick, StringTokenizer email, String name){
		/*if (usersByNick.containsKey(nick))
			throw new UserAlreadyExistsException();*/    //not needed yet
		User u = new UserClass(nick, email, name);
		usersByNick.put(nick, u);
	}
	public void insertVideo(StringTokenizer idVideo, StringTokenizer nick, StringTokenizer url, long length,String title)
			throws NoSuchUserException, InvalidLengthException {
		if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if ((length%1 != 0) || (length<=0))
			throw new InvalidLengthException();
		else{
			Video v = new VideoClass(idVideo, title, url, length);
			videosById.put(idVideo, v);
			usersByNick.get(nick).addVideo(v);
		}
	}
	public void disableVideo(StringTokenizer idVideo) 
			throws NoSuchVideoException, DisabledVideoException{
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (videosById.get(idVideo).isVideoDisabled())
			throw new DisabledVideoException();
		else
			videosById.get(idVideo).disableVideo();
	}
	public void playVideo(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException {
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (videosById.get(idVideo).isVideoDisabled())
			throw new DisabledVideoException();
		else
			usersByNick.get(nick).addVideoToHistory(videosById.get(idVideo));
	}
	public Iterator<Video> listHistory(StringTokenizer nick)
			throws NoSuchUserException, EmptyHistoryException {
		if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (!usersByNick.get(nick).hasHistory())
			throw new EmptyHistoryException();
		else
			return usersByNick.get(nick).viewedVideosIterator();
	}
	@Override
	public void removeHistory(StringTokenizer nick)
			throws NoSuchUserException{
		if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else
			usersByNick.get(nick).removeViewedHistory();
	}
	@Override
	public void addVideoToFavourites(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException{
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (videosById.get(idVideo).isVideoDisabled())
			throw new DisabledVideoException();
		else
			usersByNick.get(nick).addVideoToFavourite(videosById.get(idVideo));
	}
	@Override
	public void removeVideoFromFavourites(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException {
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (!usersByNick.get(nick).isFavourite(idVideo))
			throw new NoFavouriteVideoException();
		else
			usersByNick.get(nick).removeVideoFromFavourite(idVideo);
	}
	@Override
	public String listFavourites(StringTokenizer nick) 
			throws NoSuchUserException, NoFavouritesException{
		if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (!usersByNick.get(nick).hasFavourite())
			throw new NoFavouritesException();
		else
			return usersByNick.get(nick).favouriteVideos();
	}
	public void addTagToVideo(StringTokenizer idVideo, StringTokenizer tag) 
			throws NoSuchVideoException, DisabledVideoException {
		if(!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if(videosById.get(idVideo).isVideoDisabled())
			throw new DisabledVideoException();
		else{
			this.tag = tag;
			videosById.get(idVideo).addTagToVideo(tag);	
		}
	}
	public StringTokenizer listTags(StringTokenizer idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException{
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (!videosById.get(idVideo).hasTags())
			throw new NoTagsInVideoException();
		else
			return videosById.get(idVideo).getTags();
			
	}
	public String searchTag(StringTokenizer tag) 
		throws NoSuchTagException{
		if (!this.tag.equals(tag))
			throw new NoSuchTagException();
		else
			for (Video video : videosById.values()){
				if(video.getTags().equals(tag)){
					return video.getVideoInfo();
				}
			}
		return null;
	}
	@SuppressWarnings("unchecked")
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream file = new ObjectInputStream(new FileInputStream(fileName));
		usersByNick = (Map<StringTokenizer, User>) file.readObject();
		videosById = (Map<StringTokenizer, Video>) file.readObject();
		file.close();
	}
	public void save(String fileName)  throws IOException{
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
		file.writeObject(usersByNick);
		file.writeObject(videosById);
		file.flush();
		file.close();
	}
}
