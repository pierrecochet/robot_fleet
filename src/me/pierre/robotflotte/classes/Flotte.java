package me.pierre.robotflotte.classes;

import me.pierre.robotflotte.events.EventListener;
import me.pierre.robotflotte.events.MessageReicevedEvent;
import me.pierre.robotflotte.events.RobotMovedEvent;

import java.awt.Color;
import java.util.ArrayList;

public class Flotte extends RobotAdapter
{
    private ArrayList<Robot> robots;
    private Color color;
    private Arene arene;

    public Flotte(Color color) {
        this.robots = new ArrayList<>();
        this.color = color;
    }

    public Flotte addRobot(Robot robot) {
        this.robots.add(robot);
        return this;
    }
    public Flotte removeRobot(Robot robot) {
        this.robots.remove(robot);
        return this;
    }
    public ArrayList<Robot> getRobots() {
        return this.robots;
    }

    public Color getColor() {
        return this.color;
    }

    public void bindToArena(Arene arene) {
        this.arene = arene;
        arene.addFleet(this);
    }


    @Override
    public void onMessageReceived(MessageReicevedEvent e) {
        this.robots.forEach((Robot robot) -> {
            System.out.println("Message received: " + e.getMessage() + " from: " + ((Robot)e.getSource()).getName());
            robot.addMessage(new Message((Robot)e.getSource(), e.getMessage()));
        });
    }
    @Override
    public void onRobotMoved(RobotMovedEvent e) {
        System.out.println("Robot: " + e.getRobot().getName() + " moved to (" + e.getRobot().getPosX() + ";" + e.getRobot().getPosY()+")");
    }

    public void transmitMessage(Robot r, String message) {
        this.arene.getFleets().forEach((Flotte f) -> {
            if(f.equals(r.getFleet())) {
                f.onMessageReceived(new MessageReicevedEvent(r, message));
            }
        });
    }
    public void moveRobot(Robot r) {
        this.arene.getFleets().forEach((Flotte f) -> {
            if(f.equals(r.getFleet())) {
                f.onRobotMoved(new RobotMovedEvent(r, r));
            }
        });
    }
}
