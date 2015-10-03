package tuVes;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserClass implements User {
	
	public StringTokenizer nick;
	public String name;
	public StringTokenizer email;
	public Video videos;
	public Video favouriteVideos;
	public ArrayList<Video> viewedHistroy;
	
	public UserClass(StringTokenizer nick, StringTokenizer email, String name){
		this.nick = nick;
		this.email = email;
		this.name = name;
	}
	
	@Override
	public void addVideo(Video video) {
		this.videos = video;
	}

	@Override
	public void addVideoToFavourite(Video video) {
		this.favouriteVideos = video;
	}

	@Override
	public void addVideoToHistory(Video video) {
		viewedHistroy.add(video);
	}

	@Override
	public String historyOfViewedVideos() {
		String message = "";
		for(Video video : viewedHistroy){
			message += video.getVideoInfo();
		}
		return message;
	}

	@Override
	public String favouriteVideos() {
		return this.favouriteVideos.getVideoInfo();
	}

}
