package tuVes;

import java.io.FileNotFoundException;
import java.io.IOException;
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

public interface Player {

	public void insertUser(String nick, String email, String name);
	public void insertVideo(String idVideo, String nick, String URL, long length, String title)
			throws NoSuchUserException, InvalidLengthException ;
	public void disableVideo(String idVideo) 
			throws NoSuchVideoException, DisabledVideoException;
	public void playVideo(String idVide, String nick)
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException ;
	//public Iterator<String> listHistoryIterator(String nick);
	public Iterator<Video> listHistory(String nick)
			throws NoSuchUserException, EmptyHistoryException;
	public void removeHistory(String nick) 
			throws NoSuchUserException;
	public void addVideoToFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, DisabledVideoException, AlreadyFavouriteException;
	public void removeVideoFromFavourites(String idVideo, String nick) 
			throws NoSuchVideoException, NoSuchUserException, NoFavouriteVideoException;
	//public Iterator<String> listFavouritesIterator(String nick);
	public String listFavourites(String nick) 
			throws NoSuchUserException, NoFavouritesException;
	public void addTagToVideo(String idVideo, String tag) 
			throws NoSuchVideoException, DisabledVideoException, AlreadyHasTagException;
	//public Iterator<String> listTagsIterator(String idVideo);
	public String listTags(String idVideo) 
			throws NoSuchVideoException, NoTagsInVideoException;
	public String searchTag(String tag) 
			throws NoSuchTagException;
	public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
	public void save(String fileName)  throws IOException;
	
}
