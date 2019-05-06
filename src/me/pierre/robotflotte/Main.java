package me.pierre.robotflotte;

import me.pierre.robotflotte.classes.Arene;
import me.pierre.robotflotte.classes.Flotte;
import me.pierre.robotflotte.classes.Mover;
import me.pierre.robotflotte.classes.Robot;

import java.awt.*;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        int numberOfRobots = 8,
            arenaX = 700,
            arenaY = 500;

        Arene arena = new Arene(arenaX, arenaY);

        Flotte flotteRouge = new Flotte(Color.red);
        Flotte flotteBleue = new Flotte(Color.blue);
        Flotte flotteGreen = new Flotte(Color.green);

        Robot robot1 = new Robot("Robot 1", 100, 100, flotteRouge);
        Robot robot2 = new Robot("Robot 2", 100, 130, flotteRouge);
        Robot robot3 = new Robot("Robot 3", 100, 160, flotteRouge);
        Robot robot4 = new Robot("Robot 4", 100, 190, flotteRouge);
        Robot robot5 = new Robot("Robot 5", 300, 100, flotteBleue);
        Robot robot6 = new Robot("Robot 6", 300, 130, flotteBleue);
        Robot robot7 = new Robot("Robot 7", 300, 160, flotteBleue);
        Robot robot8 = new Robot("Robot 8", 300, 190, flotteBleue);
        Robot robot9 = new Robot("Robot 9", 300, 100, flotteBleue);
        Robot robot10 = new Robot("Robot 10", 300, 130, flotteBleue);
        Robot robot11 = new Robot("Robot 11", 300, 160, flotteBleue);
        Robot robot12 = new Robot("Robot 12", 300, 190, flotteBleue);
        Robot robot13 = new Robot("Robot 13", 500, 100, flotteGreen);
        Robot robot14 = new Robot("Robot 14", 500, 130, flotteGreen);
        Robot robot15 = new Robot("Robot 15", 500, 160, flotteGreen);
        Robot robot16 = new Robot("Robot 16", 500, 190, flotteGreen);
        Robot robot17 = new Robot("Robot 17", 500, 100, flotteGreen);
        Robot robot18 = new Robot("Robot 18", 500, 130, flotteGreen);
        Robot robot19 = new Robot("Robot 19", 500, 160, flotteGreen);
        Robot robot20 = new Robot("Robot 20", 500, 190, flotteGreen);
        Robot robot21 = new Robot("Robot 21", 100, 100, flotteRouge);
        Robot robot22 = new Robot("Robot 22", 100, 130, flotteRouge);
        Robot robot23 = new Robot("Robot 23", 100, 160, flotteRouge);
        Robot robot24 = new Robot("Robot 24", 100, 190, flotteRouge);
        robot1.setVitesse(1);



        flotteRouge.bindToArena(arena);
        flotteBleue.bindToArena(arena);
        flotteGreen.bindToArena(arena);

        robot1.sendMessage("message ceci est un test");
        /*flotteRouge.getRobots().forEach((Robot robot) -> {
            //robot.moveTo(2, 2);
            robot.sendMessage("message ceci est un test");
        });*/

        arena.startThread();
        Mover mover = new Mover(arena);
        mover.start();
    }
}