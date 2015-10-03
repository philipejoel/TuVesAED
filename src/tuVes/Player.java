package tuVes;

import java.util.Iterator;
import java.util.StringTokenizer;

import dataStructures.DisabledVideoException;
import dataStructures.EmptyHistoryException;
import dataStructures.InvalidLengthException;
import dataStructures.NoSuchUserException;
import dataStructures.NoSuchVideoException;

public interface Player {

	public void insertUser(StringTokenizer nick, StringTokenizer email, String name);
	public void insertVideo(StringTokenizer idVideo, StringTokenizer nick, StringTokenizer URL, long length, String title)
			throws NoSuchUserException, InvalidLengthException ;
	public void disableVideo(StringTokenizer idVideo) 
			throws NoSuchVideoException, DisabledVideoException;
	public void playVideo(StringTokenizer idVide, StringTokenizer nick)
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException ;
	//public Iterator<String> listHistoryIterator(StringTokenizer nick);
	public Iterator<Video> listHistory(StringTokenizer nick)
			throws NoSuchUserException, EmptyHistoryException;
	public void removeHistory(StringTokenizer nick) 
			throws NoSuchUserException;
	public void addVideoToFavourites(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException;
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
