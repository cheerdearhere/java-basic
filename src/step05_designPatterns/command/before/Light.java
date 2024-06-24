package step05_designPatterns.command.before;

public class Light {
    private boolean lightOn = false;
    public void on(){
        lightOn = true;
        System.out.println("Light on");
    }
    public void off(){
        lightOn = false;
        System.out.println("Light off");
    }
    public boolean isLightOn(){
        return lightOn;
    }
}
