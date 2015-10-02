package tuVes;

import java.util.StringTokenizer;

public class VideoClass implements Video {

	private StringTokenizer idVideo;
	private String title;
	private StringTokenizer tag;
	private StringTokenizer url;
	private boolean isDisabled;
	
	
	public VideoClass(StringTokenizer idVideo, String title, StringTokenizer url){
		this.idVideo = idVideo;
		this.title = title;
		this.url = url;
		this.isDisabled = false;
		tag = null;
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

}
