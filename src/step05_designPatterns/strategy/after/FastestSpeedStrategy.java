package step05_designPatterns.strategy.after;

public class FastestSpeedStrategy implements SpeedStrategy
{
    @Override
    public void blueLight() {
        System.out.println("무ㄱ화꽃ㅣ");
    }

    @Override
    public void redLight() {
        System.out.println("폈슴다.");
    }
}
