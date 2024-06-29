package step05_designPatterns.mediator.before;

public class CleaningService {
    public void clean(Gym gym) {
        System.out.println("Cleaning " + gym);
    }
    public void getTower(Guest guest, int numberOfTower){
        System.out.println(numberOfTower + " tower to " + guest);
    }
    public void clean(Restaurant restaurant) {
        System.out.println("Cleaning " + restaurant);
    }
}
