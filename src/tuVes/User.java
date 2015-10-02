package tuVes;

import java.util.Iterator;

public interface User {
	public void addVideoToUser();
	public void addVideoToFavourite();
	public void addVideoToHistory();
	public Iterator<String> historyOfViewedVideosIterator();
	public Iterator<String> favouriteVideosIterator();
}
