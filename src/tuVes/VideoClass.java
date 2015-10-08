package tuVes;

import java.io.Serializable;

public class VideoClass implements Video, Serializable{


	private static final long serialVersionUID = 1L;
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
	
	@Override
	public String getIdVideo(){
		return idVideo;
	}
	@Override
	public String getTitle(){
		return title;
	}
	@Override
	public long getLength(){
		return length;
	}
	@Override
	public String getStatus(){
		return isDisabled? "inativo" : "ativo";
	}
	@Override
	public void disableVideo() {
		isDisabled = true;
	}
	@Override
	public boolean isVideoDisabled() {
		return isDisabled;
	}
	@Override
	public void addTagToVideo(String tag) {
		this.tag = tag;
	}
	@Override
	public boolean hasTags(){
		return (tag != null);
	}	
	@Override
	public String getTags(){
		return tag;
	}
	@Override
	public String listTags() {
		return tag;
	}	
	@Override
	public String getVideoInfo(){
		return (getIdVideo() + " " + getTitle() +  " " +
				getLength() +  " " + getStatus());
	}

}
