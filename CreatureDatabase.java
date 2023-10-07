import java.util.ArrayList;

public class CreatureDatabase {
    public final ArrayList<Creature> EL1_CREATURES;

    public CreatureDatabase() {
        EL1_CREATURES = new ArrayList<Creature>();

        EL1_CREATURES.add(new Creature("Strawander", Type.FIRE, "Family A", 1));
        EL1_CREATURES.add(new Creature("Chocowool", Type.FIRE, "Family B", 1));
        EL1_CREATURES.add(new Creature("Parfit", Type.FIRE, "Family C", 1));
        EL1_CREATURES.add(new Creature("Brownisaur", Type.GRASS, "Family D", 1));
        EL1_CREATURES.add(new Creature("Frubat", Type.GRASS, "Family E", 1));
        EL1_CREATURES.add(new Creature("Malts", Type.GRASS, "Family F", 1));
        EL1_CREATURES.add(new Creature("Squirpie", Type.WATER, "Family G", 1));
        EL1_CREATURES.add(new Creature("Chocolite", Type.WATER, "Family H", 1));
        EL1_CREATURES.add(new Creature("Oshacone", Type.WATER, "Family I", 1));
    }
}
