package org.example.Organisms;

import org.example.Position;
import org.example.World;


public abstract class Organism {
    public int power;
    public int initiative; // Prio.
    public Position pos;
    public int liveLength;
    public int powerToReproduce;
    public char sign;
    public World world;

    public void live() throws Exception {
        return;
    }

    public void progressTime() {
        this.power += 1;
        this.liveLength -= 1;
        if (!isAlive()) {
            kill();
        }
    }

    public void kill() {
        this.liveLength = 0;
        world.removeOrganism(this);
    }

    public boolean isAlive() {
        return this.liveLength > 0;
    }
}

