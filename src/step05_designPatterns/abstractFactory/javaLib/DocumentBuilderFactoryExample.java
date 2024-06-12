package step05_designPatterns.abstractFactory.javaLib;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DocumentBuilderFactoryExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // factory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // factory에서 product(builder) 생성
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 파일 변환
        Document document = builder.parse(new File("src/main/resouces/config.xml"));
        System.out.println(document.getDocumentElement());
    }
}
