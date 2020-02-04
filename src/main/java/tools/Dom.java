package tools;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Dom {


    public static void main(String [] args)  {

        String coverfront;
        String poster;

        try{
            File inputFile = new File("movies.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("movie");
            System.out.println("----------------------------");

            for (int temp =0;temp<nList.getLength();temp++){
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName()+" " + temp) ;

                if(nNode.getNodeType() == Node.ELEMENT_NODE){

                    Element eElement = (Element) nNode;

                    System.out.println(eElement.getElementsByTagName("coverfront").item(0).getTextContent());



                }



            }




        }catch(Exception e){
            e.printStackTrace();
        }



    }


}
