package step05_designPatterns.mediator.after;

public class Gym implements HwaHanSystem {
    private final String name;
    private final CleaningService<HwaHanSystem> cleaningService = new CleaningService<>(this);

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
