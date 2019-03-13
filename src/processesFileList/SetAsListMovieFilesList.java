package processesFileList;

import java.util.ArrayList;
import java.util.List;

public class SetAsListMovieFilesList {
	
	List<String> filteredList;

	public void method1(List<String> fileListLevel3, String fileExtensions) {
		//jedna lista wszystkich rozszerzeń
		filteredList = new ArrayList<>();
		for(String elem:fileListLevel3) {
			if(elem.matches(fileExtensions)) {filteredList.add(elem);}
		} 
	}

	public List<String> getFilteredList() {
		return filteredList;
	}
}
