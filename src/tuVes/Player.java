package tuVes;

import java.util.StringTokenizer;

public interface Player {

	public void insertUser(StringTokenizer nick, StringTokenizer email, String name);
	public void insertVideo(StringTokenizer idVideo, StringTokenizer nick, StringTokenizer URL, long length, String title);
	public void disableVideo(StringTokenizer idVideo);
	public void playVideo(StringTokenizer idVide, StringTokenizer nick);
	//public Iterator<String> listHistoryIterator(StringTokenizer nick);
	public String listHistory();
	public void removeHistory(StringTokenizer nick);
	public void addVideoToFavourites(StringTokenizer idVideo, StringTokenizer nick);
	public void removeVideoFromFavourites(StringTokenizer idVideo, StringTokenizer nick);
	//public Iterator<String> listFavouritesIterator(StringTokenizer nick);
	public String listFavourites();
	public void addTagToVideo(StringTokenizer idVideo, StringTokenizer tag);
	//public Iterator<String> listTagsIterator(StringTokenizer idVideo);
	public String listTags();
	public void searchTag(StringTokenizer tag);
	public void load();
	public void save();
	
}
