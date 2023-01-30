package org.example.Organisms;

import org.example.Actions.Action;
import org.example.Actions.Dispatcher;
import org.example.Position;
import org.example.World;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Toadstool extends Plant {
    public Toadstool(World world, Dispatcher dispatcher, Factory factory, Position pos) {
        this.pos = pos;
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 12;
        this.powerToReproduce = 4;
        this.sign = 'T';
        this.world = world;
        this.dispatcher = dispatcher;
        this.factory = factory;
    }

    @Override
    public void live() throws Exception {
        if (this.power>this.powerToReproduce) {
            ArrayList<Position> freePos = world.freeNeighbourPositions(this.pos);
            if (freePos.size() == 0) {
                return;
            }
            this.dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, this, this.factory.create("Toadstool", freePos.get(
                    ThreadLocalRandom.current().nextInt(0, freePos.size())))));
            this.power=this.power/2;
        }

        ArrayList<Position> nPos = world.neighbourPositions(this.pos);
        Position target = nPos.get(ThreadLocalRandom.current().nextInt(0, nPos.size()));

        Optional<Organism> org = world.getOrganismFromPosition(pos);

        if (org.isPresent()){
            this.dispatcher.dispatch(new Action(Action.ActionType.KILL, this, org.get()));
        }

    }
}
