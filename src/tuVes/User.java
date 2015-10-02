package tuVes;


public interface User {
	public void addVideo(Video video);
	public void addVideoToFavourite(Video video);
	public void addVideoToHistory(Video video);
	//public Iterator<String> historyOfViewedVideosIterator();
	public String historyOfViewedVideos();
	//public Iterator<String> favouriteVideosIterator();
	public String favouriteVideos();
}
