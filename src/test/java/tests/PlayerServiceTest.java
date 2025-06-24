package tests;

import org.homework_7.Player;
import org.homework_7.PlayerService;
import org.homework_7.PlayerServiceClass;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;



public class PlayerServiceTest {
    @Test
    public void createPlayerWithValidName() throws IOException, ParserConfigurationException, TransformerException {
        PlayerService serviceJSON = new PlayerServiceClass("JSON");
        String playerName = "Nick1";
        int playerId = serviceJSON.createPlayer(playerName);
        Player player = serviceJSON.getPlayerById(playerId);
        System.out.println(player);
    }
}
