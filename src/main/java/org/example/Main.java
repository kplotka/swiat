package org.example;

import org.example.Actions.Action;
import org.example.Actions.Dispatcher;
import org.example.Organisms.Factory;
import org.example.Organisms.Organism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Dispatcher dispatcher = new Dispatcher();

        final World world = new World(500, 15);
        final Factory factory = new Factory(world, dispatcher);
        dispatcher.subscribe(world);

        dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, (Organism) null, factory.create("Grass", new Position(5, 5))));
        dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, (Organism) null, factory.create("Sheep", new Position(4, 8))));
        dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, (Organism) null, factory.create("Dandelion", new Position(4, 8))));
        dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, (Organism) null, factory.create("Wolf", new Position(2, 1))));
        dispatcher.dispatch(new Action(Action.ActionType.REPRODUCE, (Organism) null, factory.create("Toadstool", new Position(8, 1))));

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