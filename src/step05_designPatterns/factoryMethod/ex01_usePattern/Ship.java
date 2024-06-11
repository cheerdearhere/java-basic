package step05_designPatterns.factoryMethod.ex01_usePattern;

public class Ship {
    private String name;
    private String logo;
    private String color;

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

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
