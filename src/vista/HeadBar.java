package vista;

public class HeadBar {
	
	//opcja: dodaj rozszerzenie i powiaż z odtwarzaczem
	// |--> Runtime.getRuntime().exec( "CMD /C START filename.ext " );
	// |			czyli Runtime.getRuntime().exec( getCommand( file ) );
	// |			chyba Runtime.getRuntime().exec( getCommand( photoshop "C:\Users\csterling\Documents\some document.pdf" ) );
	// |			preferowany sposób Runtime.getRuntime().exec( getCommand( "C:\Program Files\Adobe\Photoshop\photoshop" "C:\Users\csterling\Documents\some document.pdf" ) );
	// |		public String getCommand( String file ){ 
    // | 			Depending on the platform could be
    // |			String.format("gnome-open %s", fileName)
    // |			String.format("open %s", fileName)
    // |			String.format("cmd /c start %s", fileName)
    // |			etc. 
	// |--> java.awt.Desktop 
	//		public static void open(File document) throws IOException {
    //		Desktop dt = Desktop.getDesktop();
    //		dt.open(document);}
	
	//opcja: przywróć nazwy domyślne
	
	//opcja: wersja językowa
	
	//opcja: exit
	
	//opcja: about
	
	//opcja: help
	

}
