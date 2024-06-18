package step05_designPatterns.flyweight.before;

public class Client {
    public static void main(String[] args) {
        Character c1 = new Character('h',"red","Nanum",12);
        Character c2 = new Character('e',"orange","Nanum",12);
        Character c3 = new Character('l',"yellow","Nanum",12);
        Character c4 = new Character('l',"green","Nanum",12);
        Character c5 = new Character('0',"blue","Nanum",12);
    }
}
