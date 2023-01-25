package org.example.Organisms;

import org.example.Position;
import org.example.World;

public class Factory {
    private World world;

    public Factory(World world) {
        this.world = world;
    }

    public Organism create(String type, Position pos) throws Exception {
        switch (type) {
            case "Grass":
                return new Grass(this.world, pos);
        }
        throw new Exception("no such type");
    }
}
