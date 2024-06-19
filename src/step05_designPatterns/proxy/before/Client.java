package step05_designPatterns.proxy.before;

import step05_designPatterns.proxy.basic.GameServiceProxy;

public class Client {
    public static void main(String[] args) {
        GameServiceProxy gameServiceProxy = new GameServiceProxy();
        gameServiceProxy.startGame();
    }
}
