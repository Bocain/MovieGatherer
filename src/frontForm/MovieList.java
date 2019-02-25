package frontForm;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieList {

	static File f = new File("c:/");
	static String[] sls = f.list();
	static String[][] kl = new String[sls.length][];
	
	public static final String[] HEADER_ROW = {
			"tytuł filmu"};
	
	public static final String[][] CONTENT_ROWS = kl;
	//public static final String[][] CONTENT_ROWS = {
	//		{"black ader"} , {"it crowd"} , {"silicon valey"}
	//		};
	
	static void metoda11(){
		for(int i=0; i<sls.length; i++) {
			String[] s = new String[1];
			s[0] = sls[i];
			kl[i] = s;}
		System.out.println(Arrays.deepToString(kl));
	}
	
}
