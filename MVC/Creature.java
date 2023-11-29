import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a creature with a name, type, family, and evolution level.
 */
public class Creature {
    /** The name of the creature. */
    private String name;

    /** The type of the creature. */
    private String type;

    /** The family of the creature. */
    private String family;

    /** The evolution level of the creature. */
    private int evolutionLevel;


    /**
     * Creates a new creature with the given name, type, family, and evolution level.
     * 
     * @param name The name of the creature.
     * @param type The type of the creature.
     * @param family The family of the creature.
     * @param evolutionLevel The evolution level of the creature.
     */
        public Creature(String name, String type, String family, int evolutionLevel) {
        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLevel = evolutionLevel;
    }

    /**
     * Returns the name of the creature.
     * 
     * @return The name of the creature.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the type of the creature.
     * 
     * @return The type of the creature.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the family of the creature.
     * 
     * @return The family of the creature.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Returns the evolution level of the creature.
     * 
     * @return The evolution level of the creature.
     */
    public int getEvolutionLevel() {
        return evolutionLevel;
    }

    private static final Map<String, String> EVOLUTION_MAP;
    static {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put ("FIRE_A_1", "STRAWLEON");
        tempMap.put ("FIRE_A_2", "STRAWIZARD");
        tempMap.put ("FIRE_B_1", "CHOCOFLUFF");
        tempMap.put ("FIRE_B_2", "CANDAROS");
        tempMap.put ("FIRE_C_1", "PARFURE");
        tempMap.put ("FIRE_C_2", "PARFELURE");
        tempMap.put ("GRASS_D_1", "CHOCOSAUR");
        tempMap.put ("GRASS_D_2", "FUDGASAUR");
        tempMap.put ("GRASS_E_1", "GOLBERRY");
        tempMap.put ("GRASS_E_2", "CROBERRY");
        tempMap.put ("GRASS_F_1", "KIRLCAKE");
        tempMap.put ("GRASS_F_2", "VELVEVOIR");
        tempMap.put ("WATER_G_1", "TARTORTLE");
        tempMap.put ("WATER_G_2", "PIESTOISE");
        tempMap.put ("WATER_H_1", "CHOCOLISH");
        tempMap.put ("WATER_H_2", "ICESUNDAE");
        tempMap.put ("WATER_I_1", "DEWICE");
        tempMap.put ("WATER_I_2", "SAMURCONE");

        EVOLUTION_MAP = Collections.unmodifiableMap(tempMap);
    }

    /**
     * Returns the evolved creature of the given creature.
     * 
     * @param currentCreature The creature to evolve.
     * @return The evolved creature of the given creature.
     */
    public static Creature getEvolvedCreatureUsingMap (Creature currentCreature) {
        String evolvedCreatureName = EVOLUTION_MAP.get(getEvolutionKey(currentCreature));
        if (evolvedCreatureName != null) {
            return new Creature(evolvedCreatureName, currentCreature.getType(), currentCreature.getFamily(), currentCreature.getEvolutionLevel() + 1);
        }
        return null; //Handle the case where evolution is not possible
    }

    /**
     * Returns the key used to get the evolved creature from the evolution map.
     * 
     * @param creature The creature to get the key from.
     * @return The key used to get the evolved creature from the evolution map.
     */
    private static String getEvolutionKey (Creature creature) {
        return creature.getType() + "_" + creature.getFamily() + "_" + creature.getEvolutionLevel();
    }
}