package anyData;

import java.io.File;

public class MovieFilesList {
	
	static File f = new File("c:/");
	static String[] sls = f.list();
	static String[][] kl;
	
	public static String[] HEADER_ROW = {
	"tytuł filmu"};

	public static String[][] CONTENT_ROWS;
	

}
