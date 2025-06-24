package tests;

import org.homework_7.Player;
import org.homework_7.PlayerService;
import org.homework_7.PlayerServiceClass;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerServiceTest {
    @Test
    public void createPlayerWithValidName1() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        String playerName = "Nick1";
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);
        //1. ER, 2. AR
        assertEquals(playerName, player.getNick());
    }

    @Test
    public void createPlayerWithValidName2() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        String playerName = "Nick1";
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);
        //1. ER, 2. AR
        assertEquals("playerName", player.getNick()); //специально делаем Failed
    }
}
