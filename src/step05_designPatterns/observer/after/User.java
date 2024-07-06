package step05_designPatterns.observer.after;

import java.util.Objects;
import java.util.stream.Collectors;


public class User implements Subscriber {
    /*field*/
    private final String name;
    private final ChatServer chatServer;
    /*constructor*/
    public User(ChatServer chatServer, String name) {
        this.name = name;
        this.chatServer = chatServer;

    }
    /* getter/setter */
    public String getName() {
        return name;
    }
    /*chat methods*/

    /**
     * 채팅서버에 주제 등록
     * @param subject 채팅 주제
     */
    public void enterChatServer(String subject) {
        chatServer.register(subject, this);
    }

    /**
     * 채팅서버에서 주제 삭제
     * @param subject 채팅주제
     */
    public void removeChatServer(String subject) {
        chatServer.unregister(subject, this);
    }
    /**
     * 메세지 보내기
     * @param subject 채팅 주제
     * @param message 채팅 내용(메세지)
     */
    public void sendMessage(String subject,String message){
        chatServer.handleMessage(this,subject,message);
    }

    /**
     * 채팅 서버에서 받은 메세지 표시
     * @param message 표시할 메세지
     */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(chatServer, user.chatServer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chatServer);
    }
}
