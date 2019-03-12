package processesXml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class QueryXml extends DocumentXml{
	
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

}
