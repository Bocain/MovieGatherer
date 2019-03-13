package adapter;

import java.util.List;

import anyData.FileExtensions;
import processesFileList.GainFilesList;
import processesFileList.JarAppPath;
import processesFileList.SaveToMovieFilesList;
import processesFileList.SetAsListMovieFilesList;

public class PullPushFilesList {
	
	private List<String> movieFilesList;
	private SetAsListMovieFilesList setAsListMovieFilesList;
	
	
	public void pullList(){
		JarAppPath jarAppPath =	new JarAppPath();
		String currentJarPath = jarAppPath.getJarAppPath();
		GainFilesList gainFilesList = new GainFilesList(currentJarPath);
		movieFilesList = gainFilesList.gainFilesListByExtension();
	}
	
	public void filterFilesByExtension() {
		FileExtensions movieFileExtensions = new FileExtensions();
		String fileExtensions = movieFileExtensions.getExtensions();
		setAsListMovieFilesList = new SetAsListMovieFilesList();
		setAsListMovieFilesList.method1(movieFilesList, fileExtensions);
	}
	
	public void saveMovieArray() {
		SaveToMovieFilesList saveToMovieFilesList = new SaveToMovieFilesList();
		saveToMovieFilesList.method2(setAsListMovieFilesList);
	}
}
