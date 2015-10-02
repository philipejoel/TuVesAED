package tuVes;

import java.util.Iterator;

public interface Video {
	public void disableVideo();
	public boolean isVideoDisabled();
	public void addTagToVideo();
	public Iterator<String> listTagsIterator();
}
