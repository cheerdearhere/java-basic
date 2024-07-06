package step05_designPatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverInJava {
    static class User implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(arg);
        }
    }
    static class Subject extends Observable {
        public void add(String message){
            setChanged();
            notifyObservers(message);
        }
    }
    public static void main(String[] args) {
        Subject subject = new Subject();
        User user1 = new User();
        subject.addObserver(user1);
        subject.add("Hello Observer");
    }
}
