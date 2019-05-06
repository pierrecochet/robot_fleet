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
    private int vitesse;
    private ArrayList<Message> receivedMessages;
    private int size;
    //To handle the collision to let a time for both robot to get in another direction
    private int tokenMove;

    public Robot(String name, int posX, int posY, Flotte fleet) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.gotoX = posX;
        this.gotoY = posY;
        this.fleet = fleet;
        this.size=10;
        this.receivedMessages = new ArrayList<>();
        this.vitesse=1;
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
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public Flotte getFleet() {
        return this.fleet;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public ArrayList<Message> getReceivedMessages() {
        return this.receivedMessages;
    }
    public int getTokenMove() {
        return tokenMove;
    }
    public void setTokenMove(int tokenMove) {
        this.tokenMove = tokenMove;
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