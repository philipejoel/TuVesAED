package tuVes;

import java.util.StringTokenizer;

public interface Video {
	public StringTokenizer getIdVideo();
	public String getTitle();
	public long getLength();
	public String getStatus();
	public void disableVideo();
	public boolean isVideoDisabled();
	public void addTagToVideo(StringTokenizer tag);
	public boolean hasTags();
	public StringTokenizer getTags();
	//public Iterator<String> listTagsIterator();
	public StringTokenizer listTags();
	public String getVideoInfo();
}
