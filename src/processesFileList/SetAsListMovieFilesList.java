package processesFileList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetAsListMovieFilesList {
	
	List<String> filteredList = new ArrayList<>();
	private Map<String, String> extensions = new HashMap<>();//tymczasowo do extensions
	
	public void movieFilesList(List<String> movieFilesList, String fileExtensionssss) {
		Set<String> fileExtensions = this.extensions.keySet();//tymczasowo keys, docelowo fileExtensions będzie jako Set<String>
		for(String fileExtension:fileExtensions) {
			for(String file:movieFilesList) {
				if(file.matches(fileExtension)) {
					filteredList.add(file);
					movieFilesList.remove(file);
				}
			} 
		}
	}

	public List<String> getFilteredList() {
		return filteredList;
	}
}
