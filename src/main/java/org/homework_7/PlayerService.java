package org.homework_7;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collection;

public interface PlayerService {
    // получить игрока по id
    Player getPlayerById(int id) throws IOException;

    // получить список игроков
    Collection<Player> getPlayers();

    // создать игрока (возвращает id нового игрока)
    int createPlayer(String nickname) throws IOException, ParserConfigurationException, TransformerException;

    // удалить игрока по id'шнику, вернет удаленного игрока
    Player deletePlayer(int id) throws IOException, ParserConfigurationException, TransformerException;

    // добавить очков игроку. Возвращает обновленный счет
    int addPoints(int playerId, int points) throws IOException, ParserConfigurationException, TransformerException;

}