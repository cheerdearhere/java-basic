package step05_designPatterns.memento.before;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        int blueTeamScore = game.getBlueTeamScore();
        int redTeamScore = game.getRedTeamScore();

        Game restartedGame = new Game();
        restartedGame.setRedTeamScore(redTeamScore);
        restartedGame.setBlueTeamScore(blueTeamScore);
    }
}
