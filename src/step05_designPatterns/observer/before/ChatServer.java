package step05_designPatterns.observer.before;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class ChatServer {
    private final Map<String, ArrayList<String>> messageMap ;
    public ChatServer() {
        messageMap = new HashMap<>();
    }
    public void add(String userName, String subject, String message) {
        messageMap.computeIfAbsent(subject, k -> new ArrayList<>());
        messageMap.get(subject).add(String.format(" %s : %s", userName, message));
    }
    public List<String> getMessages(String subject) {
        List<String> messageList = new ArrayList<>();
        if(!messageMap.containsKey(subject)) {
            messageList.add(
                    String.format("%s - [system] 저장된 메세지가 없습니다.",
                            LocalDateTime.now().format(
                                    new DateTimeFormatterBuilder()
                                            .appendPattern("yyyy-MM-dd a hh:mm:dd")
                                            .toFormatter()
                            )
                    )
            );
        }else {
            messageList = messageMap.get(subject).stream()
                    .map(m->{
                        return String.format("%s - [%s] %s",
                                LocalDateTime.now().format(
                                        new DateTimeFormatterBuilder()
                                                .appendPattern("yyyy-MM-dd a hh:mm:dd")
                                                .toFormatter()
                                ),
                                subject,
                                m
                        );
                    })
                    .toList()
            ;
        }
        return messageList;
    }
}
