package step05_designPatterns.mediator.before;

public class Gym {
    private final String name;
    private CleaningService cleaningService = new CleaningService();

    public Gym(String name) {
        this.name = name;
    }
    public void clean(){
        cleaningService.clean(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
