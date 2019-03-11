package processes;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

interface WriteToXml {

	default void writeToFile (Document xmlDoc, String xmlPath) throws TransformerException{
	TransformerFactory tFactory = TransformerFactory.newInstance();
	Transformer trans = tFactory.newTransformer();
	DOMSource source = new DOMSource(xmlDoc);
	StreamResult result = new StreamResult(new File(xmlPath));
	trans.transform(source, result);
	}
}
