package tools;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception{
       try {


           XMLReader xmlReader = XMLReaderFactory.createXMLReader();

           FileReader reader = new FileReader("C:\\dev\\projekte\\asmovie\\movies.xml");
           InputSource inputSource = new InputSource(reader);

           xmlReader.parse(inputSource);
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }catch(SAXException e){
           e.printStackTrace();
       }

    }

}
