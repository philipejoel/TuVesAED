/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import java.io.Serializable;

import dataStructures.AVLTree;
import dataStructures.Entry;
import dataStructures.IterableStack;
import dataStructures.Iterator;
import dataStructures.OrderedDictionary;
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
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String email;
	private OrderedDictionary<String, Video> videos;
	private OrderedDictionary<String, Video> favouriteVideos;
	private IterableStack<Video> viewedHistroy;
	
	public UserClass(String nick, String email, String name){
		this.nick = nick;
		this.email = email;
		this.name = name;
		this.viewedHistroy = new StackInList<>();
		this.videos = new AVLTree<>();
		this.favouriteVideos = new AVLTree<>();
		}
	
	public void addVideo(Video video) {
		this.videos.insert(video.getIdVideo().toLowerCase(), video); //Ask about efficiency 
	}
	
	public void addVideoToFavourite(Video video) {
		this.favouriteVideos.insert(video.getIdVideo().toLowerCase(), video);
	}
	
	public void addVideoToHistory(Video video) {
		viewedHistroy.push(video);
	}
	
	public boolean isFavourite(String idVideo){
		return favouriteVideos.find(idVideo.toLowerCase()) != null;
	}
	
	public Iterator<Video> viewedVideosIterator() 
			throws EmptyHistoryException {
		if(viewedHistroy.isEmpty())
			throw new EmptyHistoryException();
		else
			return viewedHistroy.iterator();	
	}
		
	public Iterator<Entry<String, Video>> getFavouriteVideosIterator(){
		return favouriteVideos.iterator();
	}

	public Iterator<Entry<String, Video>> getVideosIterator(){
		return videos.iterator();
	}
	
	public void removeViewedHistory() {
		this.viewedHistroy.clear();
	}
	
	public boolean hasHistory(){
		return !viewedHistroy.isEmpty();
	}
	
	public boolean hasFavourite(){
		return !favouriteVideos.isEmpty();
	}
	
	public void removeVideoFromFavourite(String idVideo) {
		favouriteVideos.remove(idVideo.toLowerCase());
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public boolean hasVideo(){
		return !videos.isEmpty();
	}
}
