package step05_designPatterns.strategy.after;

public class BlueLightRedLight {
    private SpeedStrategy speedStrategy;
//    public BlueLightRedLight(SpeedStrategy speedStrategy){
//        this.speedStrategy = speedStrategy;
//    }
    public void onBlueLight(SpeedStrategy speedStrategy){
        speedStrategy.blueLight();
    }
    public void onRedLight(SpeedStrategy speedStrategy){
        speedStrategy.redLight();
    }

}
