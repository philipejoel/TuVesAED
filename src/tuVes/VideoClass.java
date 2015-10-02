package tuVes;

import java.util.StringTokenizer;

public class VideoClass implements Video {

	private StringTokenizer idVideo;
	private String title;
	private StringTokenizer tag;
	private StringTokenizer url;
	private boolean isDisabled;
	private long length;
	
	
	public VideoClass(StringTokenizer idVideo, String title, StringTokenizer url, long length){
		this.idVideo = idVideo;
		this.title = title;
		this.url = url;
		this.isDisabled = false;
		tag = null;
		this.length = length;
	}
	
	public StringTokenizer getIdVideo(){
		return idVideo;
	}
	
	public String getTitle(){
		return title;
	}
	
	public long getLength(){
		return length;
	}
	
	public String getStatus(){
		return isDisabled? "inactivo" : "activo";
	}
	
	public void disableVideo() {
		isDisabled = true;
	}

	public boolean isVideoDisabled() {
		return isDisabled;
	}

	public void addTagToVideo(StringTokenizer tag) {
		this.tag = tag;
	}

	public StringTokenizer listTags() {
		return tag;
	}
	
	public String getVideoInfo(){
		return (getIdVideo() + " " + getTitle() +  " " +
	getLength() +  " " + getStatus());
	}


}
