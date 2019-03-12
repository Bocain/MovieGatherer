package processesFileList;

import java.util.ArrayList;
import java.util.List;

public class SetAsListMovieFilesList {
	
	//wstaw wywołanie metod i popraw w PullPushFilesList.setAsArray()
	
	List<String> filteredList = new ArrayList<>();

	public void method1(List<String> fileListLevel3) {
		for(String elem:fileListLevel3) {
			if(elem.matches(".*java.*")) {filteredList.add(elem);}
		} 
	}

	public void method2() {
		String[][] kl = new String[filteredList.size()][];
		for(int i=0; i<filteredList.size(); i++) {
			String[] s1 = new String[1];
			s1[0] = filteredList.get(i);
			kl[i] = s1;}
		//System.out.println(Arrays.deepToString(kl));
		anyData.MovieFilesList.CONTENT_ROWS = kl;
	}
}
