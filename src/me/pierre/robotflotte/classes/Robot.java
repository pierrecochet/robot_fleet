package me.pierre.robotflotte.classes;

import java.util.ArrayList;

public class Robot extends RobotAdapter
{
    private String name;
    private int posX;
    private int posY;
    private int gotoX;
    private int gotoY;
    private Flotte fleet;
    private ArrayList<Message> receivedMessages;

    public Robot(String name, int posX, int posY, Flotte fleet) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.gotoX = posX;
        this.gotoY = posY;
        this.fleet = fleet;
        this.receivedMessages = new ArrayList<>();

        this.fleet.addRobot(this);
    }


    public String getName() {
        return name;
    }
    public Robot setName(String name) {
        this.name = name;
        return this;
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getGotoX() { return gotoX; }
    public Robot setPosX(int posX) {this.posX = posX; return this;}
    public Robot setPosY(int posY) {this.posY = posY; return this;}
    public int getGotoY() { return gotoY; }

    public Flotte getFleet() {
        return this.fleet;
    }
    public ArrayList<Message> getReceivedMessages() {
        return this.receivedMessages;
    }
    public Robot addMessage(Message message) {
        this.receivedMessages.add(message);
        return this;
    }

    public void moveTo(int x, int y) {
        this.gotoX = x;
        this.gotoY = y;

        this.fleet.moveRobot(this);
    }

    public void sendMessage(String message) {
        this.fleet.transmitMessage(this, message);
    }
}