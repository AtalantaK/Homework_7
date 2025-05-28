package org.homework_7;

import java.io.IOException;
import java.util.Collection;

public interface PlayerService {
    // получить игрока по id
    Player getPlayerById(int id) throws IOException;

    // получить список игроков
    Collection<Player> getPlayers();

    // создать игрока (возвращает id нового игрока)
    int createPlayer(String nickname) throws IOException;

    // удалить игрока по id'шнику, вернет удаленного игрока
    Player deletePlayer(int id) throws IOException;

    // добавить очков игроку. Возвращает обновленный счет
    int addPoints(int playerId, int points) throws IOException;

}