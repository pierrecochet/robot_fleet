package me.pierre.robotflotte.events;

import me.pierre.robotflotte.classes.Robot;

import java.util.EventObject;

public class RobotMovedEvent extends EventObject
{
    private Robot robot;

    public RobotMovedEvent(Object o, Robot robot) {
        super(o);
        this.robot = robot;
    }

    public Robot getRobot() {
        return this.robot;
    }
}
