package tuVes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack; //Change to dataStructures.Stack later

import exceptions.EmptyHistoryException;


public class UserClass implements User, Serializable{
	

	private static final long serialVersionUID = 1L;
	private String nick;
	private String name;
	private String email;
	private Video video;
	private Video favouriteVideo;
	private Stack<Video> viewedHistroy;
	
	public UserClass(String nick, String email, String name){
		this.nick = nick;
		this.email = email;
		this.name = name;
		this.viewedHistroy = new Stack<>();
		this.favouriteVideo = null;
	}
	
	@Override
	public void addVideo(Video video) {
		this.video = video;
	}
	@Override
	public void addVideoToFavourite(Video video) {
		this.favouriteVideo = video;
	}
	@Override
	public void addVideoToHistory(Video video) {
		viewedHistroy.push(video);
	}
	@Override
	public boolean isFavourite(String idVideo){
		if (favouriteVideo == null)
			return false;
		else
			return favouriteVideo.getIdVideo().equals(idVideo);
	}
	@Override
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException {
		if(viewedHistroy.isEmpty())
			throw new EmptyHistoryException();
		else
			return viewedHistroy.iterator();	
	}
	@Override
	public String favouriteVideos() {
		return this.favouriteVideo.getVideoInfo();
	}
	@Override
	public void removeViewedHistory() {
		this.viewedHistroy.clear();
	}
	@Override
	public boolean hasHistory(){
		return !viewedHistroy.isEmpty();
	}
	@Override
	public boolean hasFavourite(){
		return (favouriteVideo != null);
	}
	@Override
	public void removeVideoFromFavourite(String idVideo) {
		favouriteVideo = null;
	}
	@Override
	public String getNick() {
		return this.nick;
	}
}
