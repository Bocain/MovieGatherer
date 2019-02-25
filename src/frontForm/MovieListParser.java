package frontForm;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class MovieListParser{
	public static void createXMLFileMethod() {
		try {
			//create file
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document docXML = builder.newDocument();
			
			//create content
			Element rootElem = docXML.createElement("ListaFilmow");
			docXML.appendChild(rootElem);
			Element recordElem = docXML.createElement("pozycja");
			recordElem.appendChild(docXML.createTextNode("film1"));
			rootElem.appendChild(recordElem);
			
			//write to file
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trans = tFactory.newTransformer();
			DOMSource source = new DOMSource(docXML);
			StreamResult result = new StreamResult(new File("J://textXML.xml"));
			trans.transform(source, result);
			
			StreamResult consolePrint = new StreamResult(System.out);
			trans.transform(source, consolePrint);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
