package org.homework_7;

import java.io.IOException;

public class TestClassJSON {
    public static void main(String[] args) throws IOException {

        PlayerServiceJSON serviceJSON = new PlayerServiceJSON();
        System.out.println("Добавлен игрок \"Nick1\". ID игрока: " + serviceJSON.createPlayer("Nick1"));
        System.out.println("Добавлен игрок \"Nick2\". ID игрока: " + serviceJSON.createPlayer("Nick2"));
        System.out.println("Добавлен игрок \"Nick3\". ID игрока: " + serviceJSON.createPlayer("Nick3"));
        System.out.println("Добавлен игрок \"Nick4\". ID игрока: " + serviceJSON.createPlayer("Nick4"));

        System.out.println("Список всех игроков. " + serviceJSON.getPlayers());

        System.out.println("Найден игрок по ID: " + 10001 + ". " + serviceJSON.getPlayerById(10001));
        System.out.println("Найден игрок по ID: " + 10002 + ". " + serviceJSON.getPlayerById(10002));
        System.out.println("Найден игрок по ID: " + 10003 + ". " + serviceJSON.getPlayerById(10003));
        System.out.println("Найден игрок по ID: " + 10004 + ". " + serviceJSON.getPlayerById(10004));

        System.out.println("Удален игрок по ID. " + serviceJSON.deletePlayer(10002));

        System.out.println("Список всех игроков. " + serviceJSON.getPlayers());

        System.out.println("Докидываем " + 111 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10001, 111));
//        System.out.println("Докидываем " + 222 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10002, 222));
        System.out.println("Докидываем " + 333 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10003, 333));
        System.out.println("Докидываем " + 444 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10004, 444));

        System.out.println("Список всех игроков. " + serviceJSON.getPlayers());

        System.out.println("Докидываем " + 555 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10001, 555));
        System.out.println("Докидываем " + 666 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10003, 666));


    }
}