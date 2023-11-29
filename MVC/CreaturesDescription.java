import java.util.HashMap;

/**
 * Represents a creature with a name, type, family, and evolution level.
 */
public class CreaturesDescription {
    /**
     *  Maps creature keys to creature details for evolution level 1 (EL1).
     */
    public final HashMap<String, String> EL1_CREATURES;

    /**
     *  Maps creature keys to creature details for evolution level 2 (EL2).
     */
    public final HashMap<String, String> EL2_CREATURES;

    /**
     *  Maps creature keys to creature details for evolution level 3 (EL3).
     */
    public final HashMap<String, String> EL3_CREATURES;

    /**
     * The creature details.
     */
    public String creatureDetails; // = EL1_CREATURES.get(key);

    /**
     * The creature name.
     */
    public String name;// 0

    /**
     * The creature type.
     */
    public String type;// 1

    /**
     * The creature family.
     */
    public String family;// 2

    /**
     * The creature evolution level.
     */
    public int level;// Integer.parseInt(attributes[3]);

// Split the string into an array of attributes
//String[] attributes = creatureDetails.split(", ");

    /**
     * Constructs a new {@code CreaturesDescription} object, initializing the mapping for creatures
     * at different evolution levels (EL1, EL2, and EL3).
     */
    public CreaturesDescription() {
        EL1_CREATURES = new HashMap<>();
        EL1_CREATURES.put("A", "STRAWANDER, FIRE, A, 1");
        EL1_CREATURES.put("B", "CHOCOWOOL, FIRE, B, 1");
        EL1_CREATURES.put("C", "PARFWIT, FIRE, C, 1");
        EL1_CREATURES.put("D", "BROWNISAUR, GRASS, D, 1");
        EL1_CREATURES.put("E", "FRUBAT, GRASS, E, 1");
        EL1_CREATURES.put("F", "MALTS, GRASS, F, 1");
        EL1_CREATURES.put("G", "SQUIRPIE, WATER, G, 1");
        EL1_CREATURES.put("H", "CHOCOLITE, WATER, H, 1");
        EL1_CREATURES.put("I", "OSHACONE, WATER, I, 1");

        EL2_CREATURES = new HashMap<>();
        EL2_CREATURES.put("A", "STRAWLEON, FIRE, A, 2");
        EL2_CREATURES.put("B", "CHOCOFLUFF, FIRE, B, 2");
        EL2_CREATURES.put("C", "PARFURE, FIRE, C, 2");
        EL2_CREATURES.put("D", "CHOCOSAUR, GRASS, D, 2");
        EL2_CREATURES.put("E", "GOLBERRY, GRASS, E, 2");
        EL2_CREATURES.put("F", "KIRLICAKE, GRASS, F, 2");
        EL2_CREATURES.put("G", "TARTORTLE, WATER, G, 2");
        EL2_CREATURES.put("H", "CHOCOLISH, WATER, H, 2");
        EL2_CREATURES.put("I", "DEWICE, WATER, I, 2");

        EL3_CREATURES = new HashMap<>();
        EL3_CREATURES.put("A", "STRAWIZARD, FIRE, A, 3");
        EL3_CREATURES.put("B", "CANDAROS, FIRE, B, 3");
        EL3_CREATURES.put("C", "PARFELURE, FIRE, C, 3");
        EL3_CREATURES.put("D", "FUDGASAUR, GRASS, D, 3");
        EL3_CREATURES.put("E", "CROBERRY, GRASS, E, 3");
        EL3_CREATURES.put("F", "VELVEVOIR, GRASS, F, 3");
        EL3_CREATURES.put("G", "PIESTOISE, WATER, G, 3");
        EL3_CREATURES.put("H", "ICESUNDAE, WATER, H, 3");
        EL3_CREATURES.put("I", "SAMURCONE, WATER, I, 3");
    }

    /**
     * Generates creature characteristics for evolution level 1 (EL1) based on a provided key.
     *
     * @param key to identify the creature characteristics in the EL1 mapping.
     */
    public void generateEL1WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL1_CREATURES.get(key);//"Chocowol, FIRE, B, 1" 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Chocowol
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = B
        this.level = Integer.parseInt(attributes[3]);// = 1
    }

    /**
     * Generates creature characteristics for evolution level 2 (EL2) based on a provided key.
     * 
     * @param key to identify the creature characteristics in the EL2 mapping.
     */
    public void generateEL2WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL2_CREATURES.get(key);//"Chocofluff, FIRE, B, 2" 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Chocofluff
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = B
        this.level = Integer.parseInt(attributes[3]);// = 2
    }

    /**
     * Generates creature characteristics for evolution level 3 (EL3) based on a provided key.
     * 
     * @param key to identify the creature characteristics in the EL3 mapping.
     */
    public void generateEL3WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL3_CREATURES.get(key);//"Candaros, FIRE, B, 3" or any other level from 1-3 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Candaros
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = C
        this.level = Integer.parseInt(attributes[3]);// = 3 or any other level from 1 - 3
    }

    /**
     * Returns the creature details.
     * 
     * @return The creature details.
     */
    public String getCreatureDetails() {
        return this.creatureDetails;
    }

    /**
     * Returns the creature name.
     * 
     * @return The creature name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the creature type.
     * 
     * @return The creature type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the creature family.
     * 
     * @return The creature family.
     */
    public String getFamily() {
        return this.family;
    }

    /**
     * Returns the creature evolution level.
     * 
     * @return The creature evolution level.
     */
    public int getLevel() {
        return this.level;
    }
}
