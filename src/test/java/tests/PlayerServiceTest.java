package tests;

import org.homework_7.Player;
import org.homework_7.PlayerService;
import org.homework_7.PlayerServiceClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerServiceTest {

    @AfterEach
    public void printMessageAfter() {
//        System.out.println("After Each");
    }

    @BeforeEach
    public void printMessageBefore() {
//        System.out.println("Before Each");
    }

    @Test
    // Создать игрока с валидным именем
    public void createPlayerWithValidNameTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        String playerName = "Nick1";
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);

        //Сломать тест
//        playerName = "Nick2";

        assertEquals(playerName, player.getNick());
    }

    @Test
    public void getPlayerTest() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        String playerName = "Nick1";
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);

        //Сломать тест
//        playerId = 100;
//        playerName = "Nick2";

        assertEquals("Player{id="+playerId+", nick='" + playerName + "', points=0, isOnline=false}", player.toString());
    }

}
