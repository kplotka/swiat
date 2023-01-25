package org.example.Organisms;

import org.example.Position;
import org.example.World;

import java.util.ArrayList;
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


}
