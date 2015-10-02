package tuVes;

import java.util.StringTokenizer;

public interface Video {
	public void disableVideo();
	public boolean isVideoDisabled();
	public void addTagToVideo(StringTokenizer tag);
	//public Iterator<String> listTagsIterator();
	public StringTokenizer listTags();
}
