package org.example.Organisms;

import org.example.Position;

public class Grass extends Base {
    public Grass(Position pos) {
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 3;
        this.sign = 'G';
    }
}
