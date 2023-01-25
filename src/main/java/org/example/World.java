package org.example;

import org.example.Organisms.Factory;
import org.example.Organisms.Organism;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

import static java.util.List.of;

public class World {

    private int worldX;
    private int worldY;
    private int turn;

    private ArrayList<Organism> organisms;

    private final char emptySpace;

    public final Factory organismFactory;

    public World(int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.turn = 0;
        this.organisms = new ArrayList<>();
        this.emptySpace = ' ';
        this.organismFactory = new Factory(this);
    }

    public void addOrganism(Organism org) {
        this.organisms.add(org);
    }

    public boolean isBound(Position pos) {
        if (pos.getX() < 0 || pos.getX() > this.worldX) {
            return false;
        }
        if (pos.getY() < 0 || pos.getY() > this.worldY) {
            return false;
        }
        return true;
    }

    public ArrayList<Position> freeNeighbourPositions(Position pos) {
        ArrayList<Position> ret = new ArrayList<>();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                Position posToCheck = pos.cloneRelative(x, y);
                if (!isBound(posToCheck)) {
                    continue;
                }
                Optional<Organism> org = getOrganismFromPosition(posToCheck);
                if (org.isEmpty()) {
                    ret.add(posToCheck);
                }
            }
        }
        return ret;
    }

    public Optional<Organism> getOrganismFromPosition(Position pos) {
        // TODO: Optimize.
        for (int i = 0; i < organisms.size(); i++) {
            if (organisms.get(i).pos.equals(pos)) {
                return Optional.of(organisms.get(i));
            }
        }
        return Optional.empty();
    }

    public void makeTurn() throws Exception {
        Organism[] organismsForTurn = organisms.toArray(new Organism[]{});
        for (int i = 0; i < organismsForTurn.length; i++) {
            Organism org = organismsForTurn[i];
            org.live();
            if (org.isAlive()) {
                org.progressTime();
            }
        }
        this.turn++;
    }

    public void removeOrganism(Organism org) {
        this.organisms.remove(org);
    }

    public void print() {
        System.out.println("Turn: " + this.turn);
        for (int y = 0; y < worldY; y++) {
            for (int x = 0; x < worldX; x++) {
                Optional<Organism> org = getOrganismFromPosition(new Position(x, y));
                if (org.isEmpty()) {
                    System.out.print(this.emptySpace);
                    continue;
                }
                System.out.print(org.get().sign);
            }
            System.out.println();
        }
    }
}
