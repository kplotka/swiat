package org.example.Organisms;

import org.example.Position;

public abstract class Base implements Organism {
    public int power;
    public int initiative; // Prio.
    public Position pos;
    public int liveLength;
    public int powerToReproduce;
    public char sign;
}

