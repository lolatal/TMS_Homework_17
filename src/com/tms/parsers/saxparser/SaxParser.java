package com.tms.parsers.saxparser;

import com.tms.parsers.IParser;
import com.tms.parsers.model.Lines;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements IParser {

    public List<Lines> process(String pathToFile) {
        List<Lines> lines = new ArrayList<>();

        try {
            File inputFile = new File(pathToFile);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            LinesHandler userHandler = new LinesHandler();
            saxParser.parse(inputFile, userHandler);

            lines = userHandler.getSonnet();

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Error");
        }
        return lines;
    }
}
