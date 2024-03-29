package Utilities;



import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DataReader {
    public String GetData(String nodeName){
        DocumentBuilder dbuilder;
        Document doc = null;
        File fxmlFile = new File("./DataFile.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            dbuilder = dbFactory.newDocumentBuilder();
            doc = dbuilder.parse(fxmlFile);
        }catch (Exception e){
            System.out.printf("Excepction in xml read file : " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

}
