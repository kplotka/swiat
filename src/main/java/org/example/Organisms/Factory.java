package org.example.Organisms;

import org.example.Position;

public class Factory {
    public static Organism create(String type, Position pos) throws Exception {
        switch (type) {
            case "grass":
                return new Grass(pos);
        }
        throw new Exception("no such type");
    }
}
