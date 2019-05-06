package me.pierre.robotflotte.classes;

public class Message
{
    private Robot source;
    private String content;

    public Message(Robot source, String content) {
        this.source = source;
        this.content = content;
    }

    public Robot getSource() {
        return this.source;
    }
    public String getContent() {
        return this.content;
    }
}
