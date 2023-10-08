public class Type {
    public static final Type FIRE = new Type("FIRE");
    public static final Type WATER = new Type("WATER");
    public static final Type GRASS = new Type("GRASS");


    private String Type;

    private Type(String Type) {
        this.Type = Type;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Type type = (Type) obj;
        return Type.equals(type.Type);
    }
    
    public String toString() {
        return Type;
    }
}
