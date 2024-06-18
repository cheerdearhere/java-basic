package step05_designPatterns.flyweight.after;

public class Client {
    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('g',"red",fontFactory.getFont("nanum:12"));
        Character c2 = new Character('o',"red",fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l',"red",fontFactory.getFont("nanum:12"));
        Character c4 = new Character('d',"red",fontFactory.getFont("nanum:12"));
    }
}

