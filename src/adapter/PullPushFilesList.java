package adapter;

import java.util.List;

import processesFileList.FileExtensions;
import processesFileList.GainFilesList;
import processesFileList.JarAppPath;
import processesFileList.SetAsListMovieFilesList;

public class PullPushFilesList {
	
	List<String> fileListLevel3;
	
	public void pullList(){
		JarAppPath jarAppPath =	new JarAppPath();
		String currentJarPath = jarAppPath.getJarAppPath();
		FileExtensions movieFileExtensions = new FileExtensions();
		String fileExtensions = movieFileExtensions.getExtensions();
		GainFilesList gainFilesList = new GainFilesList(fileExtensions, currentJarPath);
		
		//docelowo gainFilesListByExtension()
		fileListLevel3 = gainFilesList.filesLevel3();
	}
	
	public void setAsArray() {
		SetAsListMovieFilesList setAsListMovieFilesList= new SetAsListMovieFilesList();
		setAsListMovieFilesList.method1(fileListLevel3);
		setAsListMovieFilesList.method2();
	}
	
	public void saveMovieArray() {
	//SaveToMovieFilesList.java		
	}
}
