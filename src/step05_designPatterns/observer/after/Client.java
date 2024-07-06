package step05_designPatterns.observer.after;

public class Client {
    private static final ChatServer chatServer = new ChatServer();
    public static void main(String[] args) {
        User userHong = new User(chatServer, "HongGilDong");

        final String SUBJECT_DESIGN_PATTERN = "디자인패턴";
        final String SUBJECT_WORLD_CUP      = "WorldCup";
        final String SUBJECT_MOVIE          = "영화이야기";

        userHong.enterChatServer(SUBJECT_DESIGN_PATTERN);
        userHong.enterChatServer(SUBJECT_WORLD_CUP);
        
        userHong.sendMessage(SUBJECT_DESIGN_PATTERN, "이번엔 옵저버 패턴입니다");
        userHong.sendMessage(SUBJECT_WORLD_CUP,"한국 화이팅");

        User userKang = new User(chatServer, "KangKamChan");
        userKang.enterChatServer(SUBJECT_DESIGN_PATTERN);
        userKang.enterChatServer(SUBJECT_MOVIE);
        
        userHong.sendMessage(SUBJECT_DESIGN_PATTERN,"예제 코드 보는 중...");
        userKang.sendMessage(SUBJECT_MOVIE, "교수때문에 못갈듯.. ㅠㅠ");
    }
}
