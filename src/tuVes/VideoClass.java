/**
 * @author FilipeAlmeida (45047) <fjf.almeida@campus.fct.unl.pt>
 * @author PrzemyslawFalowski (46978) <p.falowski@campus.fct.unl.pt>
 */

package tuVes;

import java.io.Serializable;

public class VideoClass implements VideoSetter, Serializable{


	private static final long serialVersionUID = 1L;

/***
* @idVideo - id of video
* @title - title of video
* @tag - tag assigned to video by user
* @url - link to video
* @isDisabled - boolean value which determinate if video is disabled
* @length - duration of video
***/
	private String idVideo;
	private String title;
	private String tag;
	private String url;
	private boolean isDisabled;
	private long length;
	
	public VideoClass(String idVideo, String title, String url, long length){
		this.idVideo = idVideo;
		this.title = title;
		this.url = url;
		this.isDisabled = false;
		this.tag = null;
		this.length = length;
	}
	
	public String getIdVideo(){
		return idVideo;
	}
	
	public String getTitle(){
		return title;
	}
	
	public long getLength(){
		return length;
	}
	
	public String getStatus(){
		return isDisabled? "inativo" : "ativo";
	}
	
	public void disableVideo() {
		isDisabled = true;
	}
	
	public boolean isVideoDisabled() {
		return isDisabled;
	}
	
	public void addTagToVideo(String tag) {
		this.tag = tag;
	}
	
	public boolean hasTags(){
		return (tag != null);
	}	
	
	public String getTag(){
		return tag;
	}
	
	public String getVideoInfo(){
		return (getIdVideo() + " " + getTitle() +  " " +
				getLength() +  " " + getStatus());
	}

}
