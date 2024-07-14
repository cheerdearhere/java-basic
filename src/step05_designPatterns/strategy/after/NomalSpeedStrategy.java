package step05_designPatterns.strategy.after;

public class NomalSpeedStrategy implements SpeedStrategy
{
    @Override
    public void blueLight() {
        System.out.println("무       궁        화                  꽃           이    ...");

    }

    @Override
    public void redLight() {
        System.out.println("        피        었          습       니               다.");
    }
}
