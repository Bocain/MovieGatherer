package processesFileList;

import java.util.List;

public class SaveToMovieFilesList {
	
	public void updateContentOfMovieFilesList(List<String> filteredList) {
		String[][] contentRows = new String[filteredList.size()][];
		for(int i=0; i<filteredList.size(); i++) {
			String[] rowIter = new String[1];
			rowIter[0] = filteredList.get(i);
			contentRows[i] = rowIter;}
		anyData.MovieFilesList.CONTENT_ROWS = contentRows;
	}

}
