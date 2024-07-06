package step05_designPatterns.observer.after;

import step03_middleClass.chapter05_Enum.test.exam02.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
    private final Map<String, List<Subscriber>> subscribers;
    public ChatServer() {
        this.subscribers = new HashMap<>();
    }
    public void register(String subject, Subscriber subscriber) {
//        messageMap.computeIfAbsent(subject, k -> new ArrayList<>());
        if(subscribers.containsKey(subject)) {
            this.subscribers.get(subject).add(subscriber);
        }else{
            List<Subscriber> subscriberList = new ArrayList<>();
            subscriberList.add(subscriber);
            this.subscribers.put(subject,subscriberList);
        }
    }
    public void unregister(String subject, Subscriber subscriber) {
        if(this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).remove(subscriber);
        }else{
            throw new RuntimeException(HttpStatus.NOT_FOUND.name());
        }
    }

    public void handleMessage(User user, String subject, String inputMessage) {
        String message = String.format("%s: %s",user.getName(),inputMessage);
        if(this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).stream()
                    .map(s->(User)s)
                    .forEach(s->{
                        String outputMessage = String.format("%s - [%s] %s %s",
                                LocalDateTime.now().format(
                                        new DateTimeFormatterBuilder()
                                                .appendPattern("yyyy-MM-dd a hh:mm:dd")
                                                .toFormatter()
                                ),
                                subject,
                                (s.equals(user)?"from":"to"),
                                message
                        );
                        s.printMessage(outputMessage);
                    });
        }else{
            throw new RuntimeException(HttpStatus.NOT_FOUND.name()+": 이 주제는 등록되지 않았습니다. ");
        }
    }

}
