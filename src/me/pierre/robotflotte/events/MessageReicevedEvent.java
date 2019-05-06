package me.pierre.robotflotte.events;

import java.util.EventObject;

public class MessageReicevedEvent extends EventObject
{
    private String message;

    public MessageReicevedEvent(Object o, String message) {
        super(o);
        this.message = message;
    }

    public Object getSource() {return this.source; }
    public String getMessage() {
        return this.message;
    }
}
