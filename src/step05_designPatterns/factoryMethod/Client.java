package step05_designPatterns.factoryMethod;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteship = ShipFactory.orderShip("Whiteship","keesss@mail.com");
        System.out.println(whiteship);

        Ship blackship = ShipFactory.orderShip("Blackship","keesss@mail.com");
        System.out.println(blackship);
    }
}
