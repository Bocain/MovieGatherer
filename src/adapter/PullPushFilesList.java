package adapter;

import java.util.List;

import anyData.FileExtensionAssociatedProgram;
import processesFileList.GainFilesList;
import processesFileList.JarAppPath;
import processesFileList.SaveToMovieFilesList;
import processesFileList.SetAsListMovieFilesList;

public class PullPushFilesList {
	
	private List<String> movieFilesList;
	private List<String> prebuiltMovieFilesList;
	private SetAsListMovieFilesList setAsListMovieFilesList;
	
	public void pullListXml() {
		//uruchomienie programu
		//wyciagnięcie gotowej listy filmów z xml i zapis do prebuiltMovieFilesList
	}
	
	public void pushListUpdate() {
		//uruchomienie programu
		//wczytania prebuiltMovieFilesList do processesUpdateVista UpdateMovieList
	}
	
	
	public void pullNewList(){
		JarAppPath jarAppPath =	new JarAppPath();
		String currentJarPath = jarAppPath.getJarAppPath();
		GainFilesList gainFilesList = new GainFilesList(currentJarPath);
		movieFilesList = gainFilesList.gainFilesListByExtension();
	}
	
	public void filterFilesByExtension() {
		//uzyskaj roszerzenia ("mkv i mp4") oraz powiazane scieżki programów z xml
		//rozszerzenia 
		FileExtensionAssociatedProgram movieFileExtensionsAssociatedProgram = new FileExtensionAssociatedProgram();
		//uzyskane dane z xml wstaw do FileExtensionAssociatedProgram.setExtensionsAndProgramPath
		String fileExtensions = movieFileExtensionsAssociatedProgram.getExtensions();
		setAsListMovieFilesList = new SetAsListMovieFilesList();
		setAsListMovieFilesList.movieFilesList(movieFilesList, fileExtensions);
	}
	
	public void saveMovieArray() {
		SaveToMovieFilesList saveToMovieFilesList = new SaveToMovieFilesList();
		List<String> filteredList = setAsListMovieFilesList.getFilteredList();
		saveToMovieFilesList.updateContentOfMovieFilesList(filteredList);
		//zapis do prebuiltMovieFilesList i UpdateMovieList z processesUpdateVista
		//zapis do xml z setAsListMovieFilesList.getFilteredList()
	}
}
