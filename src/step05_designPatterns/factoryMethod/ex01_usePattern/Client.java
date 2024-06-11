package step05_designPatterns.factoryMethod.ex01_usePattern;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteshipFactory(), "whiteship", "keesss@mail.com");
        client.print(new BlackshipFactory(), "blackship", "keesss@mail.com");
    }

    private void print(ShipFactory shipFactory, String shipName, String email) {
        System.out.println(shipFactory.orderShip(shipName, email));
    }
}
