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
            arenaX = 1500,
            arenaY = 800;

        Arene arena = new Arene(arenaX, arenaY);

        Flotte flotteRouge = new Flotte(Color.red);
        Flotte flotteBleue = new Flotte(Color.blue);

        Robot robot1 = new Robot("Robot 1", 100, 100, flotteRouge);
        Robot robot2 = new Robot("Robot 2", 30, 30, flotteRouge);
        Robot robot3 = new Robot("Robot 3", 200, 200, flotteBleue);
        Robot robot4 = new Robot("Robot 4", 250, 250, flotteBleue);
        Robot robot5 = new Robot("Robot 5", 100, 100, flotteRouge);
        Robot robot6 = new Robot("Robot 6", 30, 30, flotteRouge);


        flotteRouge.bindToArena(arena);
        flotteBleue.bindToArena(arena);

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