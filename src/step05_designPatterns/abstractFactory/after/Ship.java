package step05_designPatterns.abstractFactory.after;


public class Ship {
    private String name;
    private String logo;
    private String color;

    private Anchor anchor;
    private Wheel wheel;

    public void setName(String name){
        this.name = name;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getName(){
        return name;
    }
    public String getLogo(){
        return logo;
    }
    public String getColor(){
        return color;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
