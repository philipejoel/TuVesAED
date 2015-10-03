package tuVes;

import java.util.Iterator;

import dataStructures.EmptyHistoryException;

public interface User {
	public void addVideo(Video video);
	public void addVideoToFavourite(Video video);
	public void addVideoToHistory(Video video);
	//public Iterator<String> historyOfViewedVideosIterator();
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException;
	//public Iterator<String> favouriteVideosIterator();
	public String favouriteVideos();
}
