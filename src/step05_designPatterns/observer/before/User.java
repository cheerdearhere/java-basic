package step05_designPatterns.observer.before;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.stream.Collectors;


public class User {
    private final String name;
    private final ChatServer chatServer;

    public User(ChatServer chatServer, String name) {
        this.name = name;
        this.chatServer = chatServer;

    }
    public void sendMessage(String subject,String message){
        chatServer.add(name,subject,message);
    }
    public String getMessage(String subject){
        return chatServer.getMessages(subject).stream().map(m->String.format("[%s]\n",m)).collect(Collectors.joining());
    }
}
