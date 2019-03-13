package processesFileList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GainFilesList {
	
	private String currentJarPath;
	private String[] dirFilesLevelOne;
	private List<String> filesListLastLevel;
	
	public GainFilesList (String currentJarPath){
		this.currentJarPath = currentJarPath;
	}
	
	private void listingFilesLevelOne() {
		File levelOnePath = new File(currentJarPath);
		dirFilesLevelOne = levelOnePath.list();	
		List<String> filesLevelOne = new ArrayList<String>();
		for(String dirFile:dirFilesLevelOne) {filesLevelOne.add(dirFile);}
		filesListLastLevel = filesLevelOne;

	}
	
	private void listingFilesLevelTwo() {
		List<String> filesListLevelTwo = new ArrayList<>(filesListLastLevel);
		for(String addToSearchPath:filesListLastLevel) {
			String currentPathSearch = currentJarPath.concat("/").concat(addToSearchPath);
			File levelTwoPath = new File(currentPathSearch);
			String[] dirFilesLevelTwo = levelTwoPath.list();
				if(dirFilesLevelTwo==null) {continue;}
				for(String dirFile:dirFilesLevelTwo) {filesListLevelTwo.add(dirFile);}
		}	
		filesListLastLevel = filesListLevelTwo;
	}
	
	private void listingFilesLevelTree() {	
		List<String> fileListLevelTree = new ArrayList<>(filesListLastLevel);	
		for(String dirFile:dirFilesLevelOne) {
			String pathSearch = currentJarPath.concat("/").concat(dirFile);
			File levelTwoPath = new File(pathSearch);
			String[] dirFilesLevelTwo = levelTwoPath.list();
				if(dirFilesLevelTwo==null) {continue;}
				for(String dirFiles:dirFilesLevelTwo) {
				String currentPathSearch = pathSearch.concat("/").concat(dirFiles);
				File levelTreePath = new File(currentPathSearch);
				String[] dirFilesLevelTree = levelTreePath.list();
						if(dirFilesLevelTree==null) {continue;}
						for(String dirFileTree:dirFilesLevelTree) {fileListLevelTree.add(dirFileTree);}
			}	
		}	
		filesListLastLevel = fileListLevelTree;
	}
	
	public List<String> gainFilesListByExtension() {
		listingFilesLevelOne();
		listingFilesLevelTwo();
		listingFilesLevelTree();
		return filesListLastLevel;
	}

}
