package step05_designPatterns.mediator.before;

public class Restaurant {
    private String name;
    private CleaningService cleaningService = new CleaningService();
    public Restaurant(){}
    public Restaurant(String name) {
        this.name = name;
    }
    public void dinner(Guest guest){
        System.out.println("dinner "+guest);
    }
    public void clean(){
        cleaningService.clean(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
