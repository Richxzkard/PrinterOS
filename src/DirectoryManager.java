package src;
import java.util.Hashtable;

public class DirectoryManager{
	private Hashtable<String, FileInfo> T = new Hashtable<String, FileInfo>();
	
	public void enter(String fileName, FileInfo File) {
		T.put(fileName.toString(), File);
	}
	
	public FileInfo lookup(String fileName) {
		return T.get(fileName.toString());
	}
}