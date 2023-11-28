import java.util.HashMap;

public class CreaturesDescription {
    public final HashMap<String, String> EL1_CREATURES;
    public final HashMap<String, String> EL2_CREATURES;
    public final HashMap<String, String> EL3_CREATURES;
    public String creatureDetails; // = EL1_CREATURES.get(key);
    public String name;// 0
    public String type;// 1
    public String family;// 2
    public int level;// Integer.parseInt(attributes[3]);

// Split the string into an array of attributes
//String[] attributes = creatureDetails.split(", ");

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

    public void generateEL1WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL1_CREATURES.get(key);//"Chocowol, FIRE, B, 1" 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Chocowol
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = B
        this.level = Integer.parseInt(attributes[3]);// = 1
    }

    public void generateEL2WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL2_CREATURES.get(key);//"Chocowol, FIRE, B, 2" 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Chocowol
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = B
        this.level = Integer.parseInt(attributes[3]);// = 2
    }

    public void generateEL3WithKey(String key) {
        //if key is "B"
        this.creatureDetails = EL3_CREATURES.get(key);//"Chocowol, FIRE, B, 3" or any other level from 1-3 
        String[] attributes = creatureDetails.split(", ");
        this.name = attributes[0]; // = Chocowol
        this.type = attributes[1]; // = FIRE
        this.family = attributes[2];// = B
        this.level = Integer.parseInt(attributes[3]);// = 3 or any other level from 1 - 3
    }

    public String getCreatureDetails() {
        return this.creatureDetails;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getFamily() {
        return this.family;
    }

    public int getLevel() {
        return this.level;
    }

}
