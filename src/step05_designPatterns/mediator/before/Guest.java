package step05_designPatterns.mediator.before;

public class Guest {
    private final String name;
    private Restaurant restaurant = new Restaurant();
    private CleaningService cleaningService = new CleaningService();

    public Guest(String name) {
        this.name = name;
    }
    public void dinner(){
        restaurant.dinner(this);
    }
    public void getTower(int numberOfTower){
        cleaningService.getTower(this, numberOfTower);
    }

    @Override
    public String toString() {
        return name;
    }
}
