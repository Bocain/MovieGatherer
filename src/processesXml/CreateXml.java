package processesXml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml extends DocumentXml implements WriteToXml{
	
	private String xmlFilePathString;
	
	public void setXmlFilePathString(String xmlFilePathString) {
		this.xmlFilePathString = xmlFilePathString;}
	
	public void createXMLFileMethod() {
		
		try {

			Document docXML = getXmlDocument();
			
			Element rootElem = docXML.createElement("ListaFilmow");
			docXML.appendChild(rootElem);
			Element movieFile = docXML.createElement("plik");
			Attr movieFileName = docXML.createAttribute("nazwa-pliku");
			movieFileName.setValue(xmlFilePathString);
			movieFile.setAttributeNode(movieFileName);
			rootElem.appendChild(movieFile);
			Element movieNameFromUser = docXML.createElement("nazwa-pliku");
			movieNameFromUser.appendChild(docXML.createTextNode("nazwa nadana"));
			movieFile.appendChild(movieNameFromUser);
			String[] contentXML = {"black ader" , "it crowd" , "silicon valey"};
			
			//eksport pętli do metody
			for(String cxml:contentXML) {
				Element elem = docXML.createElement("pozycja");
				elem.appendChild(docXML.createTextNode(cxml));
				rootElem.appendChild(elem);
				}
			
			writeToFile (docXML, xmlFilePathString);

		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
