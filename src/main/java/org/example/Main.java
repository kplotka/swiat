package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        final World world = new World(30, 30);

        world.addOrganism(world.organismFactory.create("Grass", new Position(15, 15)));
        for (; true; ) {
            world.makeTurn();
            world.print();

            String in = sc.nextLine();
            if (in.equals("c")) {
                System.out.println("End of the world!");
                return;
            }
        }
    }
}