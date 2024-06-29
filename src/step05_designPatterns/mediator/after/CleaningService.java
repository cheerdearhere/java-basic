package step05_designPatterns.mediator.after;

public class CleaningService<T extends HwaHanSystem> {
    private final T t;
    public CleaningService(T t) {
        this.t = t;
    }

// B to C
    public void getTower(long guestId, int numberOfTower){
        try{
            DefaultFrontDesk defaultFrontDesk = (DefaultFrontDesk)t;
            System.out.println(numberOfTower + " tower to " + defaultFrontDesk.getRoomNumberById(guestId));
        }catch (Exception e){
            throw new RuntimeException("잘못된 접근입니다.");
        }
    }
// B to B
    public void clean(Gym gym) {
        System.out.println("Cleaning " + gym);
    }
    public void clean(Restaurant restaurant) {
        System.out.println("Cleaning " + restaurant);
    }
    public void clean(Integer roomNumber, boolean isCheckOut) {
        System.out.println((isCheckOut?"full cleaning room: ":"Cleaning room request: ") + roomNumber);
    }
}
