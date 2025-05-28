package org.homework_7;

public class TestClass {
    public static void main(String[] args) {

        PlayerServiceJSON service = new PlayerServiceJSON();
        System.out.println("Добавлен игрок. ID игрока: " + service.createPlayer("Kseniia"));
        System.out.println("Добавлен игрок. ID игрока: " + service.createPlayer("Andrii"));
        System.out.println("Найден игрок по ID. " + service.getPlayerById(10002));
        System.out.println("Найден игрок по ID. " + service.getPlayerById(10001));
        System.out.println("Список всех игроков. " + service.getPlayers());
    }
}