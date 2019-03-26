package processesFileList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetAsListMovieFilesList {
	
	private List<String> filteredList = new ArrayList<>();


	public void movieFilesListSorted(List<String> movieFilesList, Set<String> fileExtensions) {

		/* Uruchomienie dopiero po umieszczeniu w folderze z filmami
		 * for(String extension:fileExtensions) { for(String file:movieFilesList) {
		 * if(extension.matches(file)) { filteredList.add(file);
		 * movieFilesList.remove(file); } } }
		 */
		for(String file:movieFilesList) {
			if(file.matches(".*java.*")) {
				filteredList.add(file);
				movieFilesList.remove(file);
			}
		} 
	}
	
	public List<String> getFilteredList() {
		return filteredList;
	}
	
}
