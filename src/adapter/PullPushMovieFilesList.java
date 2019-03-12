package adapter;

import processesFileList.FileExtensions;
import processesFileList.GainFilesList;
import processesFileList.JarAppPath;

public class PullPushMovieFilesList {
	
	public void pullList(){
		JarAppPath jarAppPath =	new JarAppPath();
		String currentJarPath = jarAppPath.getJarAppPath();
		FileExtensions movieFileExtensions = new FileExtensions();
		String fileExtensions = movieFileExtensions.getExtensions();
		new GainFilesList(fileExtensions, currentJarPath);	
	}
	
	public void setAsArray() {
	//SetAsListMovieFilesList.java
	}
	
	public void saveMovieArray() {
	//SaveToMovieFilesList.java		
	}
}
