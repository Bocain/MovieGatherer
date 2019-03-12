package processesFileList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GainFilesList {
	
	String fileExtension;
	String currentJarPath;
	
	public GainFilesList (String fileExtensions, String currentJarPath){
		this.fileExtension = fileExtensions;
		this.currentJarPath = currentJarPath;
		gainFilesListByExtension();
	}
	
	List<String> fileListLevel1 = new ArrayList<String>();
	String[] strLevel1;
	public void filesLevel1() {
		File level1 = new File(currentJarPath);
		String[] strLevel1 = level1.list();	
		for(String sL1:strLevel1) {fileListLevel1.add(sL1);}
	}
	
	String currentPath;
	List<String> fileListLevel2 = new ArrayList<>(fileListLevel1);
	public void filesLevel2() {
		for(String addToPath:fileListLevel1) {
			currentPath = currentJarPath.concat("/").concat(addToPath);
			File level2 = new File(currentPath);
			String[] strLevel2 = level2.list();
			if(strLevel2==null) {continue;}
			for(String sL2:strLevel2) {fileListLevel2.add(sL2);}
		}	
	}
	
	List<String> fileListLevel3 = new ArrayList<>(fileListLevel2);
	public List<String> filesLevel3() {
		for(String sL1:strLevel1) {
			String crp = currentJarPath.concat("/").concat(sL1);
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
		return fileListLevel3;
	}
	
	void gainFilesListByExtension() {
		//level_3(level_2(level_1()))
		//level_1()
		//level_2()
		//level_3()
	}

}
