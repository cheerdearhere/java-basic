package step05_designPatterns.mediator.after;

public class Customer {
    private final String name;
    private final Long id;
    private final Integer roomNumber;

    public Customer(long id, Integer roomNumber,String name) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public long getId() {
        return this.id;
    }
}
