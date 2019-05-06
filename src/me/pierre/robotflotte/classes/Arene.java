package me.pierre.robotflotte.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

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
        }
    }

    public void clear() {
        for (int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = Color.black.getRGB();
        }
    }

    public void render() {
        for(Flotte fleet : this.fleets) {
            for(Robot robot : fleet.getRobots()) {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        try {
                            if(robot.getGotoX() != robot.getPosX() || robot.getGotoY() != robot.getPosY()) {
                                /*int x =(robot.getPosX() - 10) + i + 1,
                                    y=(robot.getPosY() - 10) + j + 1;*/
                                /*System.out.println("ouo");
                                int x = robot.getPosX() < robot.getGotoX() ? (robot.getPosX() - 10) + i + 1 : (robot.getPosX() - 10) + i - 1,
                                    y = robot.getPosY() < robot.getGotoY() ? (robot.getPosY() - 10) + j + 1 : (robot.getPosY() - 10) + j - 1;

                                this.bufferedImage.setRGB(x, y, fleet.getColor().getRGB());
                                robot.setPosX(x).setPosY(y);*/
                                this.bufferedImage.setRGB((robot.getPosX() - 10) + i, (robot.getPosY() - 10) + j, fleet.getColor().getRGB());
                                robot.setPosX(robot.getPosX()+1).setPosY(robot.getPosY()+1);
                                System.out.println("oui");
                            }
                            else {
                                this.bufferedImage.setRGB((robot.getPosX() - 10) + i, (robot.getPosY() - 10) + j, fleet.getColor().getRGB());
                            }
                        }
                        catch(Exception e) {}
                    }
                }
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
