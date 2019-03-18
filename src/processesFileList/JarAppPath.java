package processesFileList;

import java.io.File;
import java.net.URISyntaxException;

import frontForm.MovieList;

public class JarAppPath {
	
	public String getJarAppPath(){
		String pathJar;
		try {
			pathJar = new File(MovieList.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			}
		
		//docelowo
		//return pathJar;		
		//tymczasowo
		return "C:/Users/Lenovo/eclipse-workspace/MovieGatherer";
	}

}
