package me.pierre.robotflotte.events;

public interface EventListener extends java.util.EventListener
{
    void onMessageReceived(MessageReicevedEvent e);
    void onRobotMoved(RobotMovedEvent e);
}