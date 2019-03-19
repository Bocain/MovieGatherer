package launch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<String> filteredList = new ArrayList<>();
		List<String> movieFilesList;
		Set fileExtensions;		
		//stwórz rekurencyjny alogrytm
		//public void movieFilesList(List<String> movieFilesList, Set fileExtensions) {
		
		

			for(Object filExten:fileExtensions) {
				for(String elem:movieFilesList) {
					if(elem.matches(fileExtensions)) {
						filteredList.add(elem);
						movieFilesList.remove(elem);
					}
				} 
			}
			System.out.println(filteredList);
			
			
		//}

	}

}
