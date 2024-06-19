package step05_designPatterns.proxy.basic;

public class GameServiceProxy extends GameService {
    @Override
    public void startGame() {
        long startTimeMills = System.currentTimeMillis();
        super.startGame();
        long endTimeMills = System.currentTimeMillis();
        System.out.println("소요시간: " + (endTimeMills - startTimeMills));
    }
}
