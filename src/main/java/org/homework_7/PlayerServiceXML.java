package org.homework_7;

import java.util.Collection;
import java.util.List;

public class PlayerServiceXML implements PlayerService{

    @Override
    public Player getPlayerById(int id) {
        return null;
    }

    @Override
    public Collection<Player> getPlayers() {
        return List.of();
    }

    @Override
    public int createPlayer(String nickname) {
        return 0;
    }

    @Override
    public Player deletePlayer(int id) {
        return null;
    }

    @Override
    public int addPoints(int playerId, int points) {
        return 0;
    }
}
