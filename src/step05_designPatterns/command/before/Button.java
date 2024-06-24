package step05_designPatterns.command.before;

public class Button {
    private Light light;
    public Button(Light light) {
        this.light = light;
    }
    public void press() {
        if(light.isLightOn()) light.off();
        else light.on();
    }
    public static void main(String[] args){
        Button button = new Button(new Light());
        button.press();
        button.press();
        button.press();
        button.press();
        button.press();

    }
}
