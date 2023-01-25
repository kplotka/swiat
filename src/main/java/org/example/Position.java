package org.example;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Position other = (Position) obj;
        return (this.x == other.x && this.y == other.y);
    }

    public Position cloneRelative(int relX, int relY) {
        return new Position(this.x + relX, this.y + relY);
    }

}
