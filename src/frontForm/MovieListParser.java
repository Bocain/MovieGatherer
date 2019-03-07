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
import org.w3c.dom.NodeList;

import java.io.File;

public class MovieListParser{
	public static void createXMLFileMethod() {
		try {
			//create document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document docXML = builder.newDocument();
			
			//create content
			Element rootElem = docXML.createElement("ListaFilmow");
			docXML.appendChild(rootElem);
			
			Element movieFile = docXML.createElement("plik");
			Attr movieFileName = docXML.createAttribute("nazwa-pliku");
			movieFileName.setValue("J:\\textXML.xml");
			movieFile.setAttributeNode(movieFileName);
			rootElem.appendChild(movieFile);
			
			//Element pathRecordElem = docXML.createElement("scieżka");
			//recordElem.appendChild(docXML.createTextNode("J:\\textXML.xml"));
			//recordElem.appendChild(pathRecordElem);
			
			Element movieNameFromUser = docXML.createElement("nazwa-pliku");
			movieNameFromUser.appendChild(docXML.createTextNode("nazwa nadana"));
			movieFile.appendChild(movieNameFromUser);

			String[] contentXML = {"black ader" , "it crowd" , "silicon valey"};
			for(String cxml:contentXML) {
				Element elem = docXML.createElement("pozycja");
				elem.appendChild(docXML.createTextNode(cxml));
				rootElem.appendChild(elem);
				}
			
			//write to file
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trans = tFactory.newTransformer();
			DOMSource source = new DOMSource(docXML);
			StreamResult result = new StreamResult(new File("J://textXML.xml"));
			trans.transform(source, result);
			
			//StreamResult consolePrint = new StreamResult(System.out);
			//trans.transform(source, consolePrint);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void queryXMLFileMethod() {

			try {
				File xmlFile = new File("J:/textXML.xml");
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document docXML = builder.parse(xmlFile);
				docXML.getDocumentElement().normalize();
				docXML.getDocumentElement().getNodeName();
				NodeList nodeListPosition = docXML.getElementsByTagName("pozycja");
				
				for(int i = 0; i < nodeListPosition.getLength(); i++) {
					org.w3c.dom.Node nodePosition = nodeListPosition.item(i);
					Element filmTitle = (Element) nodePosition;
					System.out.println(filmTitle.getTextContent());
					}
			}catch(Exception e){
			e.printStackTrace();
			}		
		
		
	}
	
	public static void modifyXMLFileMethod() {
	try{
		
	}catch(Exception e){
		e.printStackTrace();
	}	
	}
}
