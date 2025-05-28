package org.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerServiceXML implements PlayerService {

    private static final String FILE_NAME = "playersXML.xml";
    private List<Player> players;

    public void saveToFile() throws ParserConfigurationException, TransformerException {

        //Создаем DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Создаем новый документ
        Document document = builder.newDocument();

        //Создаем корневой элемент
        Element root = document.createElement("Players");
        document.appendChild(root);

        //Создаем дочерние элементы
        //todo: доделать по-человечески
        Element childElement = document.createElement("ID");
        childElement.appendChild(document.createTextNode("" + players.get(0).getId()));
        root.appendChild(childElement);

        //Записываем в XML файл
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(FILE_NAME);
        transformer.transform(source, result);
    }

    // получить игрока по id
    @Override
    public Player getPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) return player;
        }
        return null;
    }

    // получить список игроков
    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    // создать игрока (возвращает id нового игрока)
    @Override
    public int createPlayer(String nickname) throws IOException {
        //проверяем лежит ли что-то в списке или нам надо его проинициализировать
        if (players == null) players = new ArrayList<>();

        Player newPlayer = new Player(10000 + players.size() + 1, nickname, 0, false);
        players.add(newPlayer);
        //saveToFile();
        return newPlayer.getId();
    }

    // удалить игрока по id'шнику, вернет удаленного игрока
    @Override
    public Player deletePlayer(int id) throws IOException {
        Player removedPlayer = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                removedPlayer = players.get(i);
                players.remove(i);
                break;
            }
        }
        //saveToFile();
        return removedPlayer;
    }

    // добавить очков игроку. Возвращает обновленный счет
    @Override
    public int addPoints(int playerId, int points) throws IOException {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == playerId) {
                players.set(i, players.get(i)).setPoints(points + players.get(i).getPoints());
                //saveToFile();
                return players.get(i).getPoints();
            }
        }
        throw new RuntimeException("Объект не найден!");
    }
}
