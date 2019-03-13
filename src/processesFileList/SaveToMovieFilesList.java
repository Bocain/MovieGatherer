package processesFileList;

import java.util.List;

public class SaveToMovieFilesList {
	
	public void method2(SetAsListMovieFilesList setAsListMovieFilesList) {
		List<String> filteredList = setAsListMovieFilesList.getFilteredList();
		String[][] kl = new String[filteredList.size()][];
		for(int i=0; i<filteredList.size(); i++) {
			String[] s1 = new String[1];
			s1[0] = filteredList.get(i);
			kl[i] = s1;}
		//System.out.println(Arrays.deepToString(kl));
		anyData.MovieFilesList.CONTENT_ROWS = kl;
	}

}
