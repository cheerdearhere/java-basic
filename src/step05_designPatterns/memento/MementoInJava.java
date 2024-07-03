package step05_designPatterns.memento;

import step05_designPatterns.memento.after.Game;

import java.io.*;
import java.util.Date;

public class MementoInJava {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        date.setTime(time);

        Game game = new Game();
        game.setRedTeamScore(25);
        game.setBlueTeamScore(15);
        //직렬화
        try(
                FileOutputStream fileOut = new FileOutputStream("gameSave.hex");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ){
            out.writeObject(game);
        }
        game.setRedTeamScore(30);
        game.setBlueTeamScore(20);
        //역직렬화
        try(
                FileInputStream fileIn = new FileInputStream("gameSave.hex");
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ){
            game = (Game) in.readObject();
            System.out.println(game.getRedTeamScore());
            System.out.println(game.getBlueTeamScore());
        }
    }
}
