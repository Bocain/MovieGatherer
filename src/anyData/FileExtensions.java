package anyData;

public class FileExtensions {
	
	//Będzie jako String[] extensions;
	private String extensions = ".*java.*";
	
	public void setExtensions(String extensions) {
		// "mkv mp4"
		this.extensions = extensions;
	}
	
	public String getExtensions() {
		return extensions;
	}

}
