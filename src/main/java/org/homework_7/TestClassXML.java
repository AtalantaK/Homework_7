package org.homework_7;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class TestClassXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        PlayerServiceXML serviceXML = new PlayerServiceXML();
        serviceXML.createPlayer("Nick1");
        serviceXML.saveToFile();
    }
}
