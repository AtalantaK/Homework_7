package org.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerServiceJSON implements PlayerService {

    private static final String FILE_NAME = "players.json";
    private List<Player> players;
    private final ObjectMapper mapper;

    public PlayerServiceJSON() {
        mapper = new ObjectMapper();
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
    public int createPlayer(String nickname) {
        //проверяем лежит ли что-то в списке или нам надо его проинициализировать
        if (players == null) players = new ArrayList<>();
        Player newPlayer = new Player(10000 + players.size() + 1, nickname, 0, false);
        players.add(newPlayer);
        return newPlayer.getId();
    }

    // удалить игрока по id'шнику, вернет удаленного игрока
    @Override
    public Player deletePlayer(int id) {
        return null;
    }

    // добавить очков игроку. Возвращает обновленный счет
    @Override
    public int addPoints(int playerId, int points) {
        return 0;
    }
}
