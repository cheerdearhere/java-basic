package step05_designPatterns.command.after;

public class GameEndCommand implements Command {
    private Game game;
    public GameEndCommand(Game game) {
        this.game = game;
    }
    @Override
    public void execute() {
        game.end();
    }
    @Override
    public void undo() {
        new GameEndCommand(this.game).execute();
    }
}
