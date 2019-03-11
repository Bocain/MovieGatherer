package processes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

abstract class DocumentXml{
	
	private Document docXML;
	
	private Document FactoryDocumentXml() {
		
		//create document
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			docXML = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return docXML;
	}
	
	Document getXmlDocument(){
		return FactoryDocumentXml();
	}

}
