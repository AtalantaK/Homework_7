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
    public int createPlayer(String nickname) throws ParserConfigurationException, TransformerException {
        //проверяем лежит ли что-то в списке или нам надо его проинициализировать
        if (players == null) players = new ArrayList<>();

        Player newPlayer = new Player(10000 + players.size() + 1, nickname, 0, false);
        players.add(newPlayer);
        saveToFile();
        return newPlayer.getId();
    }

    // удалить игрока по id'шнику, вернет удаленного игрока
    @Override
    public Player deletePlayer(int id) throws ParserConfigurationException, TransformerException {
        Player removedPlayer = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                removedPlayer = players.get(i);
                players.remove(i);
                break;
            }
        }
        saveToFile();
        return removedPlayer;
    }

    // добавить очков игроку. Возвращает обновленный счет
    @Override
    public int addPoints(int playerId, int points) throws ParserConfigurationException, TransformerException {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == playerId) {
                players.set(i, players.get(i)).setPoints(points + players.get(i).getPoints());
                saveToFile();
                return players.get(i).getPoints();
            }
        }
        throw new RuntimeException("Объект не найден!");
    }
}
