package org.example.Organisms;

import org.example.Actions.Action;
import org.example.Actions.Dispatcher;
import org.example.Position;
import org.example.World;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Organism implements Dispatcher.Observer {
    public int power;
    public int initiative; // Prio.
    public Position pos;
    public int liveLength;
    public int powerToReproduce;
    public char sign;

    public World world; // TODO: We need to separate concern. Organism should not have access to all World method.
    public Dispatcher dispatcher;
    public Factory factory;

    public void live() throws Exception {
        return;
    }

    public boolean canKill(Organism victim) {
        return (this.power > victim.power);
    }

    public void progressTime() {
        this.power += 1;
        this.liveLength -= 1;
        if (!isAlive()) {
            dispatcher.dispatch(new Action(Action.ActionType.AGED, this));
        }
    }

    public void update(Action action) {
        if (!action.related.equals(this)) {
            return;
        }
        switch (action.type) {
            case KILL -> this.liveLength = 0;
        }
    }

    public boolean isAlive() {
        return this.liveLength > 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" + pos.getX() + "," + pos.getY() + "]";
    }
}



