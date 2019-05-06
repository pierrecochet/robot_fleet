package me.pierre.robotflotte.classes;

import me.pierre.robotflotte.events.EventListener;
import me.pierre.robotflotte.events.MessageReicevedEvent;
import me.pierre.robotflotte.events.RobotMovedEvent;

public abstract class RobotAdapter implements EventListener {
    public void onMessageReceived(MessageReicevedEvent e) {}
    public void onRobotMoved(RobotMovedEvent e) {}
}
