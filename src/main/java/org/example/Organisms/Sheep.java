package org.example.Organisms;

import org.example.Position;
import org.example.World;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Sheep extends Animal {

    public Sheep(World world, Position pos){
        this.pos = pos;
        this.power = 3;
        this.initiative = 3;
        this.liveLength = 10;
        this.powerToReproduce = 6;
        this.sign = 'S';
        this.world = world;
    }

    @Override
    public void live() throws Exception{
        ArrayList<Position> nPos = world.neighbourPositions(this.pos);
        Position target = nPos.get(ThreadLocalRandom.current().nextInt(0, nPos.size()));

        Optional<Organism> org = world.getOrganismFromPosition(target);
        if (org.isEmpty()) {
            this.world.
        }
    }
}
