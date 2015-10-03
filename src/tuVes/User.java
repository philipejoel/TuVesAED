package tuVes;

import java.util.Iterator;

public interface User {
	public void addVideo(Video video);
	public void addVideoToFavourite(Video video);
	public void addVideoToHistory(Video video);
	//public Iterator<String> historyOfViewedVideosIterator();
	public Iterator<Video> viewedVideosIterator();
	//public Iterator<String> favouriteVideosIterator();
	public String favouriteVideos();
}
