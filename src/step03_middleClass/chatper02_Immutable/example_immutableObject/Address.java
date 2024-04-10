package step03_middleClass.chatper02_Immutable.example_immutableObject;

public class Address {
    private final String address;
    public Address(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  address;
    }
}
