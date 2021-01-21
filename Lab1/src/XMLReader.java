import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {public static void main(String[] args){
    try
    {
        File xmlDoc = new File("Displays.xml");
        DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuild = dbFact.newDocumentBuilder();
        Document doc = dBuild.parse(xmlDoc);
        NodeList nList = doc.getElementsByTagName("display");
        float avgPrice = 0;
        float Displays_sum = nList.getLength();
        for(int i=0 ; i<nList.getLength();i++)
        {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                System.out.println("__________________________________");
                System.out.println("Display_ID: " + eElement.getAttribute(("ID")));
                System.out.println("Display_Name: " + eElement.getElementsByTagName(("display_name")).item(0).getTextContent());
                System.out.println("Display_Resolution: " + eElement.getElementsByTagName(("resolution")).item(0).getTextContent());
                System.out.println("Display_Diagonal: " + eElement.getElementsByTagName(("diagonal")).item(0).getTextContent()+"'" );
                System.out.println("Display_Update_Frequency: " + eElement.getElementsByTagName(("update_frequency")).item(0).getTextContent()+" Hz");
                System.out.println("Display_Price: " + eElement.getElementsByTagName(("price")).item(0).getTextContent()+" ₽");
                avgPrice += Float.parseFloat(eElement.getElementsByTagName(("price")).item(0).getTextContent());
                System.out.println("__________________________________");
            }
        }
        System.out.println("Средняя цена мониторов на складе = " + avgPrice/Displays_sum + " ₽");
    }
    catch (Exception e)
    {
    }
}
}
