package org.homework_7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PlayerServiceXML extends PlayerServiceClass {

    private static final String FILE_NAME = "playersXML.xml";

    protected PlayerServiceXML(String method) {
        super(method);
    }

    protected static void saveToFile() throws ParserConfigurationException, TransformerException {

        //Создаем DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Создаем новый документ
        Document document = builder.newDocument();

        //Создаем корневой элемент
        Element playersElement = document.createElement("Players");
        document.appendChild(playersElement);

        //Создаем дочерние элементы
        for (Player player : players) {

            Element playerElement = document.createElement("Player");
            playersElement.appendChild(playerElement);

            Element idElement = document.createElement("ID");
            idElement.appendChild(document.createTextNode("" + player.getId()));
            playerElement.appendChild(idElement);

            Element NickElement = document.createElement("Nickname");
            NickElement.appendChild(document.createTextNode(player.getNick()));
            playerElement.appendChild(NickElement);

            Element onlineElement = document.createElement("IsOnline");
            onlineElement.appendChild(document.createTextNode("" + player.isOnline()));
            playerElement.appendChild(onlineElement);

            Element pointsElement = document.createElement("Points");
            pointsElement.appendChild(document.createTextNode("" + player.getPoints()));
            playerElement.appendChild(pointsElement);
        }

        //Записываем в XML файл
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(FILE_NAME);
        transformer.transform(source, result);
    }
}
