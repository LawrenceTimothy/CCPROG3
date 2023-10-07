public class Creature {
    private String name;
    private Type type;
    private String family;
    private int evolutionLevel;

    public Creature(String name, Type type, String family, int evolutionLevel) {
        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLevel = evolutionLevel;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getFamily() {
        return family;
    }

    public int getEvolutionLevel() {
        return evolutionLevel;
    }
}
