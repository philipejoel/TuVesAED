package tuVes;


public interface User {
	public void addVideoToUser();
	public void addVideoToFavourite();
	public void addVideoToHistory();
	//public Iterator<String> historyOfViewedVideosIterator();
	public String historyOfViewedVideos();
	//public Iterator<String> favouriteVideosIterator();
	public String favouriteVideos();
}
