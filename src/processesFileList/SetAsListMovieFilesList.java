package processesFileList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetAsListMovieFilesList {
	
	List<String> filteredList = new ArrayList<>();

	public void movieFilesList(List<String> movieFilesList, Set fileExtensions) {

		for(Object filExten:fileExtensions) {
			for(String elem:movieFilesList) {
				if(elem.matches(fileExtensions)) {
					filteredList.add(elem);
					movieFilesList.remove(elem);
				}
			} 
		}
	}

	public List<String> getFilteredList() {
		return filteredList;
	}
}
