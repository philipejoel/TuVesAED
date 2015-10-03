package tuVes;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class PlayerClass implements Player {

	private Map<StringTokenizer, User> usersByNick;
	private Map<StringTokenizer, Video> videosById;
	
	
	public PlayerClass(){
		usersByNick = new HashMap<StringTokenizer/*nick*/, User>();
		videosById = new HashMap<StringTokenizer/*idVideo*/, Video>();
	}
	
	
	
	public void insertUser(StringTokenizer nick, StringTokenizer email, String name) {
		User u = new UserClass(nick, email, name);
		usersByNick.put(nick, u);
	}

	public void insertVideo(StringTokenizer idVideo, StringTokenizer nick, StringTokenizer url, long length,String title) {
		Video v = new VideoClass(idVideo, title, url, length);
		videosById.put(idVideo, v);

	}

	@Override
	public void disableVideo(StringTokenizer idVideo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playVideo(StringTokenizer idVide, StringTokenizer nick) {
		// TODO Auto-generated method stub

	}

	@Override
	public String listHistory() {
		// TODO Auto-generated method stub
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
