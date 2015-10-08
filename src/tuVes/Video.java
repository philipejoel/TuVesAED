package tuVes;

public interface Video {
	public String getIdVideo();
	public String getTitle();
	public long getLength();
	public String getStatus();
	public void disableVideo();
	public boolean isVideoDisabled();
	public void addTagToVideo(String tag);
	public boolean hasTags();
	public String getTags();
	//public Iterator<String> listTagsIterator();
	public String listTags();
	public String getVideoInfo();
}
