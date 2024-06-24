package step05_designPatterns.command.after;

import java.util.Stack;

public class Button {
    private Stack<Command> commands=new Stack<>();
//    public Button(Command command) {
//        this.command = command;
//    }
    public void press(Command command) {
        command.execute();
        commands.push(command);
    }
    public void undo(){
        if(!commands.isEmpty()){
            Command command = commands.pop();
            command.undo();
        }
    }
    public static void main(String[] args) {
        Button button = new Button();
        button.press(new LightOnCommand(new Light()));
        button.undo();
        button.press(new GameStartCommand(new Game()));
        button.undo();
//        button = new Button(new LightOffCommand(new Light()));
//        button.press();
//        button = new Button(new GameStartCommand(new Game()));
//        button.press();
//        button = new Button(new GameEndCommand(new Game()));
//        button.press();
    }
}
