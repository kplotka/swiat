package org.example.Organisms;

import org.example.Actions.Action;
import org.example.Actions.Dispatcher;
import org.example.Position;
import org.example.World;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Animal {

    public Wolf(World world, Dispatcher dispatcher, Factory factory, Position pos) {
        this.pos = pos;
        this.power = 8;
        this.initiative = 5;
        this.liveLength = 20;
        this.powerToReproduce = 16;
        this.sign = 'W';
        this.world = world;
        this.dispatcher = dispatcher;
        this.factory = factory;
    }

    @Override
    public void live() throws Exception{
        ArrayList<Position> nPos = world.neighbourPositions(this.pos);
        Position target = nPos.get(ThreadLocalRandom.current().nextInt(0, nPos.size()));

        Optional<Organism> org = world.getOrganismFromPosition(target);
        if (org.isPresent()) {
            if (this.canKill(org.get())) {
                this.dispatcher.dispatch(new Action(Action.ActionType.KILL, this, org.get()));
            } else {
                this.dispatcher.dispatch(new Action(Action.ActionType.KILL, org.get(), this));
                return;
            }
        }
        Position oldPos = this.pos;
        this.pos = target;
        this.dispatcher.dispatch(new Action(Action.ActionType.MOVE, oldPos, this));

        if (this.power>this.powerToReproduce){
            this.dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, this, this.factory.create("Wolf", new Position(2, 1))));
            this.power=this.power/2;
        }
    }
}