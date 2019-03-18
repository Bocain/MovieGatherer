package anyData;

import java.util.HashMap;
import java.util.Map;

public class FileExtensionAssociatedProgram {
	
	private Map<String, String> extensions = new HashMap<>();
	
	public void setExtensionsAndProgramPath(String extensions, String associatedProgramPath) {
		this.extensions.put(extensions, associatedProgramPath);
	}
	
	public String getAssociatedProgramPath(String extensions) {	
		return this.extensions.get(extensions);
	}
	
	public String getExtensions() {
		
		//docelowo
		//public String getExtensions() {return this.extensions.keySet();}

		//tymczasowo
		return ".*java.*";
	}

}
