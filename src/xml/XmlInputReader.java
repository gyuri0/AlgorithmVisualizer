package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import logic.SortAlgorithmInput;

public class XmlInputReader {
	public static SortAlgorithmInput getSortAlgorithmInputFromXml(String file)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList arrayElements = doc.getElementsByTagName("element");
			int[] array = new int[arrayElements.getLength()];
			
			for(int i=0;i<array.length;i++)
			{
				array[i]=Integer.parseInt(arrayElements.item(i).getTextContent());
			}
			
			return new SortAlgorithmInput(array);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
