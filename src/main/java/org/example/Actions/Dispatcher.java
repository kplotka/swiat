package org.example.Actions;

import java.util.ArrayList;

public class Dispatcher {
    public interface Observer {
        public void update(Action action);
    }

    private ArrayList<Observer> observers = new ArrayList<>();

    public void subscribe(Observer ob) {
        observers.add(ob);
    }

    public void unsubscribe(Observer ob) {
        observers.remove(ob);
    }

    public void dispatch(Action action) {
        action.log();
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(action);
        }
    }
}
