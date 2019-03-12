package processesFileList;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import frontForm.MovieList;

public class GainFilesList {
	
	String fileExtension;
	String currentJarPath;
	
	public GainFilesList (String fileExtensions, String currentJarPath){
		this.fileExtension = fileExtensions;
		this.currentJarPath = currentJarPath;
		gainFilesListByExtension();
	}
	
	static void gainFilesListByExtension(){
		//level_3(level_2(level_1()))
		//level_1()
		//level_2()
		//level_3()
	
	JarAppPath jarAppPath =	new JarAppPath();
	String pathJar = jarAppPath.getJarAppPath();
	try {
		pathJar = new File(MovieList.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
	} catch (URISyntaxException e) {e.printStackTrace();}
	File s = new File(pathJar);
	String[] sf = s.list();
	//test wyświetlenia wszytkich plikow dla C:\Users\Lenovo\eclipse-workspace\MovieGatherer
	String pathString = "C:/Users/Lenovo/eclipse-workspace/MovieGatherer";
	File level1 = new File(pathString);
	String[] strLevel1 = level1.list();
	
	List<String> fileListLevel1 = new ArrayList<String>();
	for(String sL1:strLevel1) {fileListLevel1.add(sL1);}
	
	List<String> fileListLevel2 = new ArrayList<>(fileListLevel1);
	String currentPath;
	for(String addToPath:fileListLevel1) {
		currentPath = pathString.concat("/").concat(addToPath);
		File level2 = new File(currentPath);
		String[] strLevel2 = level2.list();
		if(strLevel2==null) {continue;}
		for(String sL2:strLevel2) {fileListLevel2.add(sL2);}
	}
	
	List<String> fileListLevel3 = new ArrayList<>(fileListLevel2);
	for(String sL1:strLevel1) {
		String crp = pathString.concat("/").concat(sL1);
		File lvl = new File(crp);
		String[] sl2 = lvl.list();
		if(sl2==null) {continue;}
		for(String sl3:sl2) {
			String erp = crp.concat("/").concat(sl3);
			lvl = new File(erp);
			String[] lastList = lvl.list();
			if(lastList==null) {continue;}
			for(String addLast:lastList) {fileListLevel3.add(addLast);}
		}	
	}
	
	
	//przenies do SetAsListMovieFilesList
	List<String> filteredList = new ArrayList<>();
	for(String elem:fileListLevel3) {
		if(elem.matches(".*java.*")) {filteredList.add(elem);}
	}
	
	//przenies do SetAsListMovieFilesList
	String[][] kl = new String[filteredList.size()][];
	for(int i=0; i<filteredList.size(); i++) {
		String[] s1 = new String[1];
		s1[0] = filteredList.get(i);
		kl[i] = s1;}
	//System.out.println(Arrays.deepToString(kl));
	anyData.MovieFilesList.CONTENT_ROWS = kl;
	}

}
