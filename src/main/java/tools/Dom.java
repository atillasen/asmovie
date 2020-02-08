package tools;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
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

        BufferedImage coverfrontBufferedImage;


        EntityManagerFactory emf= Persistence.createEntityManagerFactory("asmovie-jpa");
        EntityManager em = emf.createEntityManager();

        Person person = new Person();
        Media media = new Media();
        Coverfront cover = new Coverfront();
        Darsteller darsteller = new Darsteller();
        Set<Coverfront> coverfront = null;
        byte[] imageInByte;
        ImageTools imageTools= new ImageTools();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
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


                    coverfrontBufferedImage = imageTools.getImageFromFile(eElement.getElementsByTagName("coverfront").item(0).getTextContent());
                    ImageIO.write( coverfrontBufferedImage,"jpg",baos);
                    baos.flush();
                    imageInByte =baos.toByteArray();
                    cover.setCoverfront(imageInByte);
                    coverfront.add(cover);

                    System.out.println(eElement.getElementsByTagName("coverfront").item(0).getTextContent());
                    media



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
