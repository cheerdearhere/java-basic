package step05_designPatterns.observer.before;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User userHong = new User(chatServer, "HongGilDong");
        userHong.sendMessage("디자인패턴", "이번엔 옵저버 패턴입니다");
        userHong.sendMessage("WorldCup","한국 화이팅");

        User userKang = new User(chatServer, "KangKamChan");

        System.out.print(userKang.getMessage("디자인패턴"));
        userHong.sendMessage("디자인패턴","예제 코드 보는 중...");
        System.out.print(userKang.getMessage("디자인 패턴"));
    }
}
