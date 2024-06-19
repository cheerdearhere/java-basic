package step05_designPatterns.proxy.useInterface;

public class GameServiceProxy implements GameService{
    private GameService gameService;
    @Override
    public void startGame() {
        if(this.gameService == null){
            this.gameService = new DefaultGameService();
        }
        long startTimeMills = System.currentTimeMillis();
        gameService.startGame();
        long endTimeMills = System.currentTimeMillis();
        System.out.println("소요시간: " + (endTimeMills - startTimeMills));
    }
}
