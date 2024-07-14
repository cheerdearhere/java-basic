package step05_designPatterns.strategy.before;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight blueLightRedLight = new BlueLightRedLight();
        blueLightRedLight.blueLight(1);
        blueLightRedLight.redLight(2);
    }
}
