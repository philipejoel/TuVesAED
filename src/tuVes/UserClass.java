/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import java.io.Serializable;

import dataStructures.IterableStack;
import dataStructures.Iterator;
import dataStructures.StackInList;
import exceptions.EmptyHistoryException;


public class UserClass implements UserSetter, Serializable{
	
/***
* @nick - User nick
* @name - User name
* @email - User email
* @video - Video added by user
* @favouriteVideo - User favourite video
* @viewedHistroy - History of viewed videos by user
***/
	private static final long serialVersionUID = 1L;
	private String nick;
	private String name;
	private String email;
	private Video video;
	private Video favouriteVideo;
	private IterableStack<Video> viewedHistroy;
	
	public UserClass(String nick, String email, String name){
		this.nick = nick;
		this.email = email;
		this.name = name;
		this.viewedHistroy = new StackInList<>();
		this.favouriteVideo = null;
	}
	
	public void addVideo(Video video) {
		this.video = video;
	}
	
	public void addVideoToFavourite(Video video) {
		this.favouriteVideo = video;
	}
	
	public void addVideoToHistory(Video video) {
		viewedHistroy.push(video);
	}
	
	public boolean isFavourite(String idVideo){
		if (favouriteVideo == null)
			return false;
		else
			return favouriteVideo.getIdVideo().equals(idVideo);
	}
	
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException {
		if(viewedHistroy.isEmpty())
			throw new EmptyHistoryException();
		else
			return viewedHistroy.iterator();
			//return (Iterator<Video>) viewedHistroy.iterator();	
	}
	
	public String favouriteVideos() {
		return this.favouriteVideo.getVideoInfo();
	}

	public String listVideos() {
		return this.video.getVideoInfo();
	}
	
	public void removeViewedHistory() {
		this.viewedHistroy.clear();
	}
	
	public boolean hasHistory(){
		return !viewedHistroy.isEmpty();
	}
	
	public boolean hasFavourite(){
		return (favouriteVideo != null);
	}
	
	public void removeVideoFromFavourite(String idVideo) {
		favouriteVideo = null;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public boolean hasVideo(){
		return (video != null);
	}
}
