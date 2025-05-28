package org.homework_7;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {

        PlayerServiceJSON service = new PlayerServiceJSON();
        System.out.println("Добавлен игрок \"Nick1\". ID игрока: " + service.createPlayer("Nick1"));
        System.out.println("Добавлен игрок \"Nick2\". ID игрока: " + service.createPlayer("Nick2"));
        System.out.println("Добавлен игрок \"Nick3\". ID игрока: " + service.createPlayer("Nick3"));
        System.out.println("Добавлен игрок \"Nick4\". ID игрока: " + service.createPlayer("Nick4"));

        System.out.println("Список всех игроков. " + service.getPlayers());

        System.out.println("Найден игрок по ID: " + 10001 + ". " + service.getPlayerById(10001));
        System.out.println("Найден игрок по ID: " + 10002 + ". " + service.getPlayerById(10002));
        System.out.println("Найден игрок по ID: " + 10003 + ". " + service.getPlayerById(10003));
        System.out.println("Найден игрок по ID: " + 10004 + ". " + service.getPlayerById(10004));

        System.out.println("Удален игрок по ID. " + service.deletePlayer(10002));

        System.out.println("Список всех игроков. " + service.getPlayers());

        System.out.println("Докидываем " + 111 + " очков. Обновленный счет игрока: " + service.addPoints(10001, 111));
//        System.out.println("Докидываем " + 222 + " очков. Обновленный счет игрока: " + service.addPoints(10002, 222));
        System.out.println("Докидываем " + 333 + " очков. Обновленный счет игрока: " + service.addPoints(10003, 333));
        System.out.println("Докидываем " + 444 + " очков. Обновленный счет игрока: " + service.addPoints(10004, 444));

        System.out.println("Список всех игроков. " + service.getPlayers());

        System.out.println("Докидываем " + 555 + " очков. Обновленный счет игрока: " + service.addPoints(10001, 555));
        System.out.println("Докидываем " + 666 + " очков. Обновленный счет игрока: " + service.addPoints(10003, 666));
    }
}