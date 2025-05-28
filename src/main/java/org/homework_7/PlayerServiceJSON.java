package org.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerServiceJSON implements PlayerService {

    private static final String FILE_NAME = "playersJSON.json";
    private List<Player> players;
    private final ObjectMapper mapper;

    public PlayerServiceJSON() {
        mapper = new ObjectMapper();
    }

    public void saveToFile() throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), players);
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
        saveToFile();
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
        saveToFile();
        return removedPlayer;
    }

    // добавить очков игроку. Возвращает обновленный счет
    @Override
    public int addPoints(int playerId, int points) throws IOException {
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
