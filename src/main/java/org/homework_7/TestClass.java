package org.homework_7;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {

        PlayerServiceJSON service = new PlayerServiceJSON();
        System.out.println("Добавлен игрок. ID игрока: " + service.createPlayer("Kseniia"));
        System.out.println("Добавлен игрок. ID игрока: " + service.createPlayer("Andrii"));
        System.out.println("Добавлен игрок. ID игрока: " + service.createPlayer("Oleg"));
        System.out.println("Найден игрок по ID. " + service.getPlayerById(10001));
        System.out.println("Найден игрок по ID. " + service.getPlayerById(10002));
        System.out.println("Найден игрок по ID. " + service.getPlayerById(10003));
        System.out.println("Список всех игроков. " + service.getPlayers());
        System.out.println("Удален игрок по ID. " + service.deletePlayer(10003));
        System.out.println("Список всех игроков. " + service.getPlayers());

//        List<Player> playerList = new ArrayList<>();
//        Player player1 = new Player(11, "Nick1", 11, false);
//        Player player2 = new Player(22, "Nick2", 22, false);
//        playerList.add(player1);
//        playerList.add(player2);
//        playerList.remove(0);
//        System.out.println(playerList.get(0));
    }
}