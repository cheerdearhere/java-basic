package step05_designPatterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observer;

public class PropertyChangeListenerInJava {
    static class User implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getPropertyName());
        }
    }
    static class Subject {
        PropertyChangeSupport support = new PropertyChangeSupport(this);
        public void addObserver(PropertyChangeListener observer) {
            support.addPropertyChangeListener(observer);
        }
        public void removeObserver(PropertyChangeListener observer) {
            support.removePropertyChangeListener(observer);
        }
        public void add(String message) {
            support.firePropertyChange("eventName", null, message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        User observer = new User();
        subject.addObserver(observer);
        subject.add("등록 중 입력");
        subject.removeObserver(observer);
        subject.add("해제 후 메세지");
    }
}
