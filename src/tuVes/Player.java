package tuVes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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
	public void removeVideoFromFavourites(StringTokenizer idVideo, StringTokenizer nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException;
	//public Iterator<String> listFavouritesIterator(StringTokenizer nick);
	public String listFavourites(StringTokenizer nick) 
			throws NoSuchUserException, NoFavouritesException;
	public void addTagToVideo(StringTokenizer idVideo, StringTokenizer tag) 
			throws NoSuchVideoException, DisabledVideoException;
	//public Iterator<String> listTagsIterator(StringTokenizer idVideo);
	public StringTokenizer listTags(StringTokenizer idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException;
	public String searchTag(StringTokenizer tag) 
			throws NoSuchTagException;
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
	public void save(String fileName)  throws IOException;
	
}
