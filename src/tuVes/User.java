package tuVes;

import java.util.Iterator;
import java.util.StringTokenizer;

import dataStructures.EmptyHistoryException;

public interface User {
	public void addVideo(Video video);
	public void addVideoToFavourite(Video video);
	public void removeVideoFromFavourite(StringTokenizer idVideo);
	public void addVideoToHistory(Video video);
	//public Iterator<String> historyOfViewedVideosIterator();
	public boolean isFavourite(StringTokenizer idVideo);
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException;
	//public Iterator<String> favouriteVideosIterator();
	public String favouriteVideos();
	public boolean hasFavourite();
	public void removeViewedHistory();
}
