package org.homework_7;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerServiceClass implements PlayerService {

    protected static List<Player> players;
    private final String method;

    public PlayerServiceClass(String method) {
        this.method = method;
    }

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
    public int createPlayer(String nickname) throws ParserConfigurationException, TransformerException, IOException {
        //проверяем лежит ли что-то в списке или нам надо его проинициализировать
        if (players == null) players = new ArrayList<>();

        Player newPlayer = new Player(10000 + players.size() + 1, nickname, 0, false);
        players.add(newPlayer);

        if(method.equals("XML")) PlayerServiceXML.saveToFile();
        else PlayerServiceJSON.saveToFile();

        return newPlayer.getId();
    }

    // удалить игрока по id'шнику, вернет удаленного игрока
    @Override
    public Player deletePlayer(int id) throws ParserConfigurationException, TransformerException, IOException {
        Player removedPlayer = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                removedPlayer = players.get(i);
                players.remove(i);
                break;
            }
        }

        if(method.equals("XML")) PlayerServiceXML.saveToFile();
        else PlayerServiceJSON.saveToFile();

        return removedPlayer;
    }

    // Добавить очков игроку. Возвращает обновленный счет
    @Override
    public int addPoints(int playerId, int points) throws ParserConfigurationException, TransformerException, IOException {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == playerId) {
                players.set(i, players.get(i)).setPoints(points + players.get(i).getPoints());

                if(method.equals("XML")) PlayerServiceXML.saveToFile();
                else PlayerServiceJSON.saveToFile();

                return players.get(i).getPoints();
            }
        }
        throw new RuntimeException("Объект не найден!");
    }
}
