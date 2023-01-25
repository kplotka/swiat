package org.example.Organisms;

import org.example.Position;
import org.example.World;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Grass extends Plant {
    public Grass(World world, Position pos) {
        this.pos = pos;
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 3;
        this.sign = 'G';
        this.world = world;
    }

    @Override
    public void live() throws Exception {
        ArrayList<Position> freePos = world.freeNeighbourPositions(this.pos);
        if (freePos.size() == 0) {
            return;
        }
        world.addOrganism(
                world.organismFactory.create("Grass", freePos.get(
                        ThreadLocalRandom.current().nextInt(0, freePos.size()))
                )
        );
    }
}
