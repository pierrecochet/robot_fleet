package me.pierre.robotflotte.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Random;

public class Arene extends JFrame implements Runnable
{
    private int sizeX;
    private int sizeY;
    private ArrayList<Flotte> fleets;
    private BufferedImage bufferedImage;
    private int[] pixels;
    private Thread thread;

    public Arene(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.fleets = new ArrayList<>();
        this.bufferedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
        this.pixels = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();

        setSize(sizeX, sizeY);
        setTitle("Arene");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.thread = new Thread(this);
    }


    public int getSizeX() {
        return sizeX;
    }
    public Arene setSizeX(int sizeX) {
        this.sizeX = sizeX;
        return this;
    }

    public int getSizeY() {
        return sizeY;
    }
    public Arene setSizeY(int sizeY) {
        this.sizeY = sizeY;
        return this;
    }

    public void addFleet(Flotte flotte) {
        this.fleets.add(flotte);
    }
    public ArrayList<Flotte> getFleets() {
        return this.fleets;
    }

    public void startThread() {
        this.thread.start();
    }

    public void run() {
        while(!Thread.interrupted()) {
            clear();
            render();
            try {
                this.thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clear() {
        for (int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = Color.pink.getRGB();
        }
    }

    public void mange(Robot robot,Robot r){
        if(r.getSize()>robot.getSize()){
            //robot.getFleet().getRobots().remove(robot);
            r.setSize(r.getSize()+(robot.getSize()/2));
        //temporaire je ne peux pas retirer de la liste sinon ça créer des conflits dans la lecture de la liste de robots
            robot.setSize(0);
            robot.setPosX(10000);
            robot.setPosY(10000);
            robot=null;
        }else if(r.getSize()==robot.getSize()){
            long rand = Math.round( Math.random());
            if(rand ==0){
                r.getFleet().getRobots().remove(r);
                robot.setSize(robot.getSize()+(r.getSize()/2));
                r=null;
            }else{
                r.setSize(r.getSize()+(robot.getSize()/2));
                robot.setSize(0);
                robot.setPosX(10000);
                robot.setPosY(10000);
                robot=null;
            }
        }else{

            r.getFleet().getRobots().remove(r);
            robot.setSize(robot.getSize()+(r.getSize()/2));
            r=null;
        }


    }

    public void repousse(Robot robot, Robot r){//!!!!IMPORTANT!!!! au dessus d'une certaine taille enlever la collision ?
        int x3 = r.getPosX()>robot.getPosX() ? r.getPosX()-100 : r.getPosX()+100,
                y3 = r.getPosY()>robot.getPosY() ? r.getPosY()-100 : r.getPosY()+100;
        int x3b = r.getPosX()<robot.getPosX() ? robot.getPosX()-100 : robot.getPosX()+100,
                y3b = r.getPosY()<robot.getPosY() ? robot.getPosY()-100 : robot.getPosY()+100;
        robot.moveTo(x3, y3);
        r.moveTo(x3b, y3b);
    }


    /**
     *
     * @param robot
     * @param fleets
     * @return
     */
    public boolean collision(Robot robot, ArrayList<Flotte> fleets){
        Random rand = new Random();
        int posX = robot.getPosX(),
            posY = robot.getPosY();

        for(Flotte f:fleets){
            for(Robot r:f.getRobots()){
                //check si le carré dessiné autour d'un robot rentre en collision avec le carré d'un autre robot
                if(posX>=r.getPosX()-(robot.getSize()+r.getSize()) && posX<=r.getPosX()+(robot.getSize()+r.getSize())
                        && posY>=r.getPosY()-(robot.getSize()+r.getSize()) && posY<=r.getPosY()+(robot.getSize()+r.getSize())
                        && !robot.equals(r)) {

                    if(!robot.getFleet().equals(r.getFleet())){
                        mange(robot,r);
                        return false;
                    }else{
                        repousse(robot,r);
                        return true;
                    }
                //test3 concluant
                    //Les collisions sont gérées en envoyant les robots dans des directions strictement opposées


                }
            }
        }
        return true;

    }

    public void render() {
        boolean collision;
        for(Flotte fleet : this.fleets) {
            for(Robot robot : fleet.getRobots()) {
                for (int i = 0; i < robot.getSize()*2; i++) {
                    for (int j = 0; j < robot.getSize()*2; j++) {
                        try {
                            if(robot.getGotoX() != robot.getPosX()  || robot.getGotoY() != robot.getPosY() ) {

                                    int x = robot.getPosX() < robot.getGotoX() ? (robot.getPosX() - robot.getSize()) + i + 1 : (robot.getPosX() - robot.getSize()) + i - 1,
                                            y = robot.getPosY() < robot.getGotoY() ? (robot.getPosY() - robot.getSize()) + j + 1 : (robot.getPosY() - robot.getSize()) + j - 1;
                                    this.bufferedImage.setRGB((robot.getPosX() - robot.getSize()) + i, (robot.getPosY() - robot.getSize()) + j, fleet.getColor().getRGB());


                            }
                            else {
                                this.bufferedImage.setRGB((robot.getPosX() - robot.getSize()) + i, (robot.getPosY() - robot.getSize()) + j, fleet.getColor().getRGB());
                            }
                        }
                        catch(Exception e) {}
                    }
                }
                collision=collision(robot,this.getFleets());
                int x = robot.getPosX() < robot.getGotoX() ? (robot.getPosX() + robot.getVitesse()) : (robot.getPosX() - robot.getVitesse()),
                    y = robot.getPosY() < robot.getGotoY() ? (robot.getPosY() + robot.getVitesse()) : (robot.getPosY() - robot.getVitesse());
                robot.setPosX(x).setPosY(y);
                /*if(collision){
                    System.out.println("oui");
                    robot.setVitesse(robot.getVitesse()-1);
                }*/
            }
        }

        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.bufferedImage, 0, 0, this.bufferedImage.getWidth(), this.bufferedImage.getHeight(), null);
        bs.show();
    }
}
