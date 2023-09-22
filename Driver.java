public class Driver {
    public static void main(String[] args) {
        Owl owl1 = new Owl(24, "purple");
        Owl owl2 = new Owl(40, "yellow");
        Owl owl3 = new Owl(8, "grey");

        Tree tree1 = new Tree("Green leaves", "brown trunk", 3.0);
        Tree tree2 = new Tree("Yellow leaves", "grey trunk", 2.7);
        Tree tree3 = new Tree("Red leaves", "dark brown trunk", 20.0);

        Mushroom mushroom1 = new Mushroom("Large", "red cap", " ", true, 5);
        Mushroom mushroom2 = new Mushroom("Medium", "blue cap", "yellow stem", false, 7);
        Mushroom mushroom3 = new Mushroom("Small", "pink cap", "grey stem", false, 9);
        
       System.out.println("\nOwl 1: Size - " + owl1.getSize() + "cm, Color - " + owl1.getColor());
       System.out.println("Owl 2: Size - " + owl2.getSize() + "cm, Color - " + owl2.getColor());
       System.out.println("Owl 3: Size - " + owl3.getSize() + "cm, Color - " + owl3.getColor());
    
       System.out.println("\nTree 1: Leaf Color - " + tree1.getLeafColor() + ", Trunk Color - " + tree1.getTrunkColor() + ", Height - " + tree1.getHeight() + "m");
       System.out.println("Tree 2: Leaf Color - " + tree2.getLeafColor() + ", Trunk Color - " + tree2.getTrunkColor() + ", Height - " + tree2.getHeight() + "m");
       System.out.println("Tree 3: Leaf Color - " + tree3.getLeafColor() + ", Trunk Color - " + tree3.getTrunkColor() + ", Height - " + tree3.getHeight() + "m");

       System.out.println("\nMushroom 1: Cap size - " + mushroom1.getSize() + ", Cap Color - " + mushroom1.getCapColor() + ", " + (mushroom1.isPoisonous() ? "poisonous" : "not poisonous") + ", CM Size - " + mushroom1.getCMSize()); 
       System.out.println("Mushroom 2: Cap size - " + mushroom2.getSize() + ", Cap Color - " + mushroom2.getCapColor() + ", Stem Color - " + mushroom2.getStemColor() + ", " + (mushroom2.isPoisonous() ? "poisonous" : "not poisonous") + ", CM Size - " + mushroom2.getCMSize()); 
       System.out.println("Mushroom 3: Cap size - " + mushroom3.getSize() + ", Cap Color - " + mushroom3.getCapColor() + ", Stem Color - " + mushroom3.getStemColor() + ", " + (mushroom3.isPoisonous() ? "poisonous" : "not poisonous") + ", CM Size - " + mushroom3.getCMSize() + "\n"); 
    }
}
