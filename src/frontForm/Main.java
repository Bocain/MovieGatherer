package frontForm;

public class Main {
	
	/*
	 * MovieView mView; MovieControl mControl;
	 */
	
	MovieView tView;
	
	public Main(){ metoda(); }	
	
	public void metoda(){
		MovieListParser.createXMLFileMethod();
		MovieListParser.queryXMLFileMethod();
		MovieList.metoda22();
		/*
		 * mView = new MovieView(); new MovieControl(); mView.showGui();
		 */
		tView = new MovieView();
		tView.showGui();
		
	}

	public static void main(String[] args){ new Main(); }
}
