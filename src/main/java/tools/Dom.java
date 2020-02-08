package tools;

import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import asmovieDao.Coverfront;
import asmovieDao.Darsteller;
import asmovieDao.Media;
import asmovieDao.Person;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Dom {


    public static void main(String [] args)  {




        EntityManagerFactory emf= Persistence.createEntityManagerFactory("asmovie-jpa");
        EntityManager em = emf.createEntityManager();

        Person person = new Person();
        Media media = new Media();
        Darsteller darsteller = new Darsteller();
        Coverfront coverfront = new Coverfront();

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
                    try {

                        System.out.println(eElement.getElementsByTagName("poster").item(0).getTextContent());
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    try {

                        System.out.println(eElement.getElementsByTagName("backdropurl").item(0).getTextContent());
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    try {

                        System.out.println(eElement.getElementsByTagName("imdburl").item(0).getTextContent());
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }

                try {
                    em.getTransaction().begin();
                    em.persist(person);
                    em.persist(darsteller);
                    em.persist(media);
                    em.getTransaction().commit();

                }catch (Exception ex){
                    em.getTransaction().rollback();
                }



            }




        }catch(Exception e){
            e.printStackTrace();
        }



    }


}
