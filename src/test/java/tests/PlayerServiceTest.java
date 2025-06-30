package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.homework_7.Player;
import org.homework_7.PlayerService;
import org.homework_7.PlayerServiceClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerServiceTest {

    String FILE_NAME = "playersJSON.json";
    File file = new File(FILE_NAME);
    String playerName = "Nick";

    @AfterEach
    public void clearAfter() {
//        System.out.println("Удаляем файл после теста");
        //if (file.exists()) file.delete();
        //todo подчищать сервис, а не только файл
    }

    @BeforeEach
    public void clearBefore() {
//        System.out.println("Удаляем файл до начала теста");
        //if (file.exists()) file.delete();
        //todo подчищать сервис, а не только файл
    }

    @Test
    // Создать игрока с валидным именем
    public void createPlayerWithValidNameTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);

        //Сломать тест
//        playerName = "Nick2";

        assertEquals(playerName, player.getNick());
    }


    @Test
    // Получить игрока
    public void getPlayerTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);

        //Сломать тест
//        playerId = 100;
//        playerName = "Nick2";

        assertEquals("Player{id=" + playerId + ", nick='" + playerName + "', points=0, isOnline=false}", player.toString());
    }

    @Test
    //Получить список игроков
    public void getPlayersTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        //Эталонная коллекция. С ней будем сравнивать
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int playerId = serviceJSON.createPlayer(playerName + (i + 1));
            playerList.add(serviceJSON.getPlayerById(playerId));
        }

        //Сломать тест - расскоментировать код ниже
//        List<Player> playerListWrong = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            playerListWrong.add(serviceJSON.getPlayerById(serviceJSON.createPlayer(playerName + (i * 10))));
//        }
//        assertEquals(playerListWrong, serviceJSON.getPlayers());

        assertEquals(playerList, serviceJSON.getPlayers());
    }

    @Test
    //Удалить игрока
    public void deletePlayerTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        int playerId = serviceJSON.createPlayer(playerName);

        //Сломать тест - закомментировать строку ниже
        serviceJSON.deletePlayer(playerId);

        assertNull(serviceJSON.getPlayerById(playerId));
    }

    @Test
    //Удалить всех игроков
    public void deleteAllPlayersTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        int[] arrayPlayers = new int[3];
        for (int i = 0; i < 3; i++) {
            arrayPlayers[i] = serviceJSON.createPlayer(playerName + (i + 1));
        }

        //Сломать тест - закомментировать for ниже
        for (int i = 0; i < 3; i++) {
            serviceJSON.deletePlayer(arrayPlayers[i]);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Player> players = mapper.readValue(new File(FILE_NAME), new TypeReference<>() {
        });

        assertTrue(players.isEmpty());
    }
}
