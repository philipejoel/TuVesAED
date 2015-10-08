package tuVes;

import java.util.Iterator;
import exceptions.EmptyHistoryException;

public interface User {
	public void addVideo(Video video);
	public void addVideoToFavourite(Video video);
	public void removeVideoFromFavourite(String idVideo);
	public void addVideoToHistory(Video video);
	public boolean isFavourite(String idVideo);
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException;
	public String favouriteVideos();
	public void removeViewedHistory();
	public boolean hasHistory();
	public boolean hasFavourite();
	public String getNick();
	
}
