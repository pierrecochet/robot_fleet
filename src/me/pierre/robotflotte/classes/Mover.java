package me.pierre.robotflotte.classes;

import java.util.Random;

public class Mover extends Thread
{
    private Arene arena;

    public Mover(Arene arena) {
        this.arena = arena;
    }

    public void run() {
        while(true) {
            try {
                Random rand = new Random();

                arena.getFleets().forEach((Flotte fleet) -> {
                    fleet.getRobots().forEach((Robot r) -> {
                        int x = rand.nextInt(600);
                        int y = rand.nextInt(600);

                        r.moveTo(x, y);
                    });
                });

                this.sleep(1000);

            }
            catch(Exception e) { }
        }
    }
}
