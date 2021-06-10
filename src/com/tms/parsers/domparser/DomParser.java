package com.tms.parsers.domparser;

import com.tms.parsers.IParser;
import com.tms.parsers.model.Lines;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class DomParser implements IParser {

    @Override
    public List<Lines> process(String file) {
        List<Lines> sonnet = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(String.valueOf(file)));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("line");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList nList2 = node.getChildNodes();
                    for (int j = 0; j < nList2.getLength(); j++) {
                        Node node2 = nList2.item(j);
                        String line = node2.getTextContent();
                        sonnet.add(new Lines(line));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return sonnet;
    }

}
