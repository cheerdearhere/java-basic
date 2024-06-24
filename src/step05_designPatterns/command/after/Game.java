package step05_designPatterns.command.after;

public class Game {
    private boolean playing = false;
    public void start(){
        playing = true;
        System.out.println("game start");
    }
    public void end(){
        playing = false;
        System.out.println("game end");
    }
    public boolean isGaming(){
        return playing;
    }
}
