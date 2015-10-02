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
		// TODO Auto-generated method stub
		this.videos = video;
	}

	@Override
	public void addVideoToFavourite(Video video) {
		// TODO Auto-generated method stub
		this.favouriteVideos = video;
	}

	@Override
	public void addVideoToHistory(Video video) {
		// TODO Auto-generated method stub
		viewedHistroy.add(video);
	}

	@Override
	public String historyOfViewedVideos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String favouriteVideos() {
		// TODO Auto-generated method stub
		return this.favouriteVideos.getVideoInfo();
	}

}
