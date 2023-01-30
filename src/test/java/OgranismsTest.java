import org.example.Actions.Action;
import org.example.Actions.Dispatcher;
import org.example.Organisms.*;
import org.example.Position;
import org.example.World;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OgranismsTest {
    @Test
    public void testGrass() throws Exception {
        World w = new World(10, 10);
        Dispatcher d =  new Dispatcher();

        ArrayList<Action> actions = new ArrayList<>();
        d.subscribe(actions::add);
        Factory f = new Factory(w, d);

        Organism grass = new Grass(w, d, f, new Position(0, 0));
        grass.live();
        assertEquals("no action", 0, actions.size());

        grass.progressTime();
        grass.live();
        assertEquals("no action", 0, actions.size());

        grass.progressTime();
        grass.live();
        assertEquals("no action", 0, actions.size());

        grass.progressTime();
        grass.live();
        assertEquals("no action", 0, actions.size());

        grass.progressTime();
        grass.live();
        assertEquals("one action", 1, actions.size());
        assertEquals("REPRODUCE", Action.ActionType.REPRODUCE, actions.get(0).type);
        assertEquals("Reproduced grass", Grass.class, actions.get(0).related.getClass());
        // TODO(kasia): Check if position of organism in action is neighbouring.

        grass.power = 100000;
        assertEquals("grass cannot kill Sheep", false, grass.canKill(new Sheep(w, d, f, new Position(0,0))));
        assertEquals("grass cannot kill Toadstool", false, grass.canKill(new Toadstool(w, d, f, new Position(0,0))));
        assertEquals("grass cannot kill Wolf", false, grass.canKill(new Wolf(w, d, f, new Position(0,0))));
        assertEquals("grass cannot kill Dandelion", false, grass.canKill(new Dandelion(w, d, f, new Position(0,0))));


        assertEquals("grass did not age yet", true, grass.isAlive());
        grass.progressTime();
        assertEquals("grass did not age yet", true, grass.isAlive());
        grass.progressTime();
        assertEquals("grass aged ", false, grass.isAlive());
        assertEquals("two actions", 2, actions.size());
        assertEquals("AGED", Action.ActionType.AGED, actions.get(1).type);
    }
    @Test
    public void SheepTest() throws Exception {
        World w = new World(10, 10);
        Dispatcher d =  new Dispatcher();

        ArrayList<Action> actions = new ArrayList<>();
        d.subscribe(actions::add);
        Factory f = new Factory(w, d);

        Organism sheep = new Sheep(w, d, f, new Position(0, 0));
        sheep.live();
        assertEquals("one action", 1, actions.size());

        sheep.progressTime();
        sheep.live();
        assertEquals("two actions", 2, actions.size());
        assertEquals("MOVE", Action.ActionType.MOVE, actions.get(0).type);

        sheep.live();
        sheep.progressTime();

        sheep.live();
        sheep.progressTime();

        sheep.live();
        sheep.progressTime();

        sheep.live();
        assertEquals("seven actions", 7, actions.size());
        //moved couple times and then reproduced

        assertEquals("Sheep kills Grass", true, sheep.canKill(new Grass(w, d, f, new Position(0,0))));
    }
    @Test
    public void DandelionTest() throws Exception {
        World w = new World(10, 10);
        Dispatcher d =  new Dispatcher();

        ArrayList<Action> actions = new ArrayList<>();
        d.subscribe(actions::add);
        Factory f = new Factory(w, d);

        Organism dandelion = new Dandelion(w, d, f, new Position(0, 0));
        dandelion.live();
        assertEquals("no action", 0, actions.size());
        dandelion.progressTime();
        dandelion.live();
        assertEquals("no action", 0, actions.size());

        dandelion.progressTime();
        dandelion.live();
        assertEquals("no action", 0, actions.size());

        dandelion.progressTime();
        dandelion.live();
        assertEquals("one action", 1, actions.size());
        assertEquals("REPRODUCE", Action.ActionType.REPRODUCE, actions.get(0).type);

        dandelion.power = 100000;
        assertEquals("dandelion cannot kill Sheep", false, dandelion.canKill(new Sheep(w, d, f, new Position(0,0))));
        assertEquals("dandelion cannot kill Toadstool", false, dandelion.canKill(new Toadstool(w, d, f, new Position(0,0))));
        assertEquals("dandelion cannot kill Wolf", false, dandelion.canKill(new Wolf(w, d, f, new Position(0,0))));
        assertEquals("dandelion cannot kill Grass", false, dandelion.canKill(new Grass(w, d, f, new Position(0,0))));


        assertEquals("dandelion did not age yet", true, dandelion.isAlive());
        dandelion.progressTime();
        assertEquals("dandelion did not age yet", true, dandelion.isAlive());
        dandelion.progressTime();
        assertEquals("dandelion did not age yet", true, dandelion.isAlive());
        dandelion.progressTime();
        assertEquals("dandelion aged ", false, dandelion.isAlive());
        assertEquals("two actions", 2, actions.size());
        assertEquals("AGED", Action.ActionType.AGED, actions.get(1).type);
    }
    @Test
    public void WolfTest() throws Exception{
        World w = new World(10, 10);
        Dispatcher d =  new Dispatcher();

        ArrayList<Action> actions = new ArrayList<>();
        d.subscribe(actions::add);
        Factory f = new Factory(w, d);

        Organism wolf = new Wolf(w, d, f, new Position(0, 0));
        wolf.live();
        assertEquals("one action", 1, actions.size());

        wolf.progressTime();
        wolf.live();
        assertEquals("two actions", 2, actions.size());
        assertEquals("MOVE", Action.ActionType.MOVE, actions.get(0).type);

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        wolf.progressTime();

        wolf.live();
        assertEquals("twelve actions", 12, actions.size());
        //moved couple times and then reproduced

        assertEquals("Wolf kills Sheep", true, wolf.canKill(new Sheep(w, d, f, new Position(0,0))));
    }
    @Test
    public void ToadstoolTest() throws Exception{
        World w = new World(10, 10);
        Dispatcher d =  new Dispatcher();

        ArrayList<Action> actions = new ArrayList<>();
        d.subscribe(actions::add);
        Factory f = new Factory(w, d);

        Organism toadstool = new Toadstool(w, d, f, new Position(0, 0));
        toadstool.live();
        assertEquals("no action", 0, actions.size());
        toadstool.progressTime();
        toadstool.live();
        assertEquals("no action", 0, actions.size());

        toadstool.progressTime();
        toadstool.live();
        assertEquals("no action", 0, actions.size());

        toadstool.progressTime();
        toadstool.live();

        toadstool.progressTime();
        toadstool.live();

        toadstool.progressTime();
        toadstool.live();

        toadstool.progressTime();
        toadstool.live();
        assertEquals("one action", 1, actions.size());
        assertEquals("REPRODUCE", Action.ActionType.REPRODUCE, actions.get(0).type);

        toadstool.power = 100000;
        assertEquals("toadstool can kill Sheep", true, toadstool.canKill(new Sheep(w, d, f, new Position(0,0))));
        assertEquals("toadstool can kill Wolf", true, toadstool.canKill(new Wolf(w, d, f, new Position(0,0))));


        assertEquals("toadstool did not age yet", true, toadstool.isAlive());
        toadstool.progressTime();
        assertEquals("toadstool did not age yet", true, toadstool.isAlive());
        toadstool.progressTime();
        assertEquals("dandelion did not age yet", true, toadstool.isAlive());
        toadstool.progressTime();
        toadstool.progressTime();
        toadstool.progressTime();
        toadstool.progressTime();
        assertEquals("dandelion aged ", false, toadstool.isAlive());
        assertEquals("two actions", 2, actions.size());
        assertEquals("AGED", Action.ActionType.AGED, actions.get(1).type);
    }

}
