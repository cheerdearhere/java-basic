package step05_designPatterns.memento.after;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        GameSave saveData = game.save();

        Game restartedGame = new Game();
        restartedGame.restart(saveData);
    }
}
