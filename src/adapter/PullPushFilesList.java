package adapter;

import java.util.List;

import anyData.FileExtensionAssociatedProgram;
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
		//uzyskaj roszerzenia ("mkv i mp4") oraz powiazane scieżki programów z xml
		FileExtensionAssociatedProgram movieFileExtensionsAssociatedProgram = new FileExtensionAssociatedProgram();
		//uzyskane dane z xml wstaw do FileExtensionAssociatedProgram.setExtensionsAndProgramPath
		String fileExtensions = movieFileExtensionsAssociatedProgram.getExtensions();
		setAsListMovieFilesList = new SetAsListMovieFilesList();
		setAsListMovieFilesList.movieFilesList(movieFilesList, fileExtensions);
	}
	
	public void saveMovieArray() {
		SaveToMovieFilesList saveToMovieFilesList = new SaveToMovieFilesList();
		saveToMovieFilesList.method2(setAsListMovieFilesList);
	}
}
