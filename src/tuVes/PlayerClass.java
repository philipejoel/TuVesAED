package tuVes;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import dataStructures.AlreadyDisabledVideoException;
import dataStructures.InvalidLengthException;
import dataStructures.NoSuchUserException;
import dataStructures.NoSuchVideoException;

public class PlayerClass implements Player {

	private Map<StringTokenizer, User> usersByNick;
	private Map<StringTokenizer, Video> videosById;
	
	
	
	public PlayerClass(){
		usersByNick = new HashMap<StringTokenizer/*nick*/, User>();
		videosById = new HashMap<StringTokenizer/*idVideo*/, Video>();
	}
	
	

	public void insertUser(StringTokenizer nick, StringTokenizer email, String name){
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
		}
	}

	
	public void disableVideo(StringTokenizer idVideo) 
			throws NoSuchVideoException, AlreadyDisabledVideoException{
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (videosById.get(idVideo).isVideoDisabled())
			throw new AlreadyDisabledVideoException();
		else
			videosById.get(idVideo).disableVideo();
	}

	public void playVideo(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, AlreadyDisabledVideoException {
		if (!videosById.containsKey(idVideo))
			throw new NoSuchVideoException();
		else if (!usersByNick.containsKey(nick))
			throw new NoSuchUserException();
		else if (videosById.get(idVideo).isVideoDisabled())
			throw new AlreadyDisabledVideoException();
		else
			usersByNick.get(nick).addVideoToHistory(videosById.get(idVideo));
	}

	public String listHistory() {
		
		return null;
	}

	@Override
	public void removeHistory(StringTokenizer nick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVideoToFavourites(StringTokenizer idVideo, StringTokenizer nick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVideoFromFavourites(StringTokenizer idVideo, StringTokenizer nick) {
		// TODO Auto-generated method stub

	}

	@Override
	public String listFavourites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTagToVideo(StringTokenizer idVideo, StringTokenizer tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public String listTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchTag(StringTokenizer tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
