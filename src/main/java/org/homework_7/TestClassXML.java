package org.homework_7;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class TestClassXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {

        PlayerService serviceXML = new PlayerServiceXML("XML");

        System.out.println("Добавлен игрок \"Nick1\". ID игрока: " + serviceXML.createPlayer("Nick1"));
        System.out.println("Добавлен игрок \"Nick2\". ID игрока: " + serviceXML.createPlayer("Nick2"));
        System.out.println("Добавлен игрок \"Nick3\". ID игрока: " + serviceXML.createPlayer("Nick3"));
        System.out.println("Добавлен игрок \"Nick4\". ID игрока: " + serviceXML.createPlayer("Nick4"));

        System.out.println("Список всех игроков. " + serviceXML.getPlayers());
//
        System.out.println("Найден игрок по ID: " + 10001 + ". " + serviceXML.getPlayerById(10001));
        System.out.println("Найден игрок по ID: " + 10002 + ". " + serviceXML.getPlayerById(10002));
        System.out.println("Найден игрок по ID: " + 10003 + ". " + serviceXML.getPlayerById(10003));
        System.out.println("Найден игрок по ID: " + 10004 + ". " + serviceXML.getPlayerById(10004));

        System.out.println("Удален игрок по ID. " + serviceXML.deletePlayer(10002));

        System.out.println("Список всех игроков. " + serviceXML.getPlayers());

        System.out.println("Докидываем " + 111 + " очков. Обновленный счет игрока: " + serviceXML.addPoints(10001, 111));
//        System.out.println("Докидываем " + 222 + " очков. Обновленный счет игрока: " + serviceJSON.addPoints(10002, 222));
        System.out.println("Докидываем " + 333 + " очков. Обновленный счет игрока: " + serviceXML.addPoints(10003, 333));
        System.out.println("Докидываем " + 444 + " очков. Обновленный счет игрока: " + serviceXML.addPoints(10004, 444));

        System.out.println("Список всех игроков. " + serviceXML.getPlayers());

        System.out.println("Докидываем " + 555 + " очков. Обновленный счет игрока: " + serviceXML.addPoints(10001, 555));
        System.out.println("Докидываем " + 666 + " очков. Обновленный счет игрока: " + serviceXML.addPoints(10003, 666));
    }
}
