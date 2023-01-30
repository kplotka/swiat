package org.example.Organisms;

import org.example.Actions.Dispatcher;
import org.example.Position;
import org.example.World;

public class Factory {
    private World world;
    private Dispatcher dispatcher;

    public Factory(World world, Dispatcher dispatcher) {
        this.world = world;
        this.dispatcher = dispatcher;
    }

    public Organism create(String type, Position pos) throws Exception {
        switch (type) {
            case "Grass":
                return new Grass(this.world, this.dispatcher, this, pos);
            case "Sheep":
                return new Sheep(this.world, this.dispatcher, this, pos);
            case "Dandelion":
                return new Dandelion(this.world, this.dispatcher, this, pos);
            case "Wolf":
                return new Wolf(this.world, this.dispatcher, this, pos);
            case "Toadstool":
                return new Toadstool(this.world, this.dispatcher, this, pos);
        }
        throw new Exception("no such type");
    }
}
