package org.example.Actions;

import org.example.Organisms.Organism;
import org.example.Position;

public class Action {
    public enum ActionType {
        KILL,
        AGED,
        MOVE,
        REPRODUCE

    }

    public ActionType type;
    public Organism initiated;
    public Position oldPos;
    public Organism related;

    public Action(ActionType type, Organism initiated, Organism related) {
        this.type = type;
        this.initiated = initiated;
        this.related = related;
    }

    public Action(ActionType type, Organism initiated) {
        this.type = type;
        this.initiated = initiated;
    }

    public Action(ActionType type, Position oldPos, Organism initiated) {
        this.type = type;
        this.initiated = initiated;
        this.oldPos = oldPos;
    }

    public void log() {
        switch (type) {
            case AGED -> System.out.println(initiated + " died from old age");
            case KILL -> System.out.println(initiated + " killed " + this.related);
            case MOVE -> System.out.println(initiated + " moved from position " + this.oldPos);
            case REPRODUCE -> System.out.println(initiated + " reproduced " + this.related);
        }
    }
}
