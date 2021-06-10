package com.tms.parsers.saxparser;

import com.tms.parsers.model.Lines;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class LinesHandler extends DefaultHandler {

    private List<Lines> sonnet = new ArrayList<>();
    boolean line = false;

    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) {
        if (qName.equals("line")) {
            line = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (line) {
            String line = new String(ch, start, length);
            sonnet.add(new Lines(line));
        }
    }

    public List<Lines> getSonnet() {
        return sonnet;
    }
}
