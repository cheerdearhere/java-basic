package step05_designPatterns.strategy.after;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight();
        game.onBlueLight(new NomalSpeedStrategy());
        game.onRedLight(new FastestSpeedStrategy());
        game.onRedLight(new SpeedStrategy() {
            @Override
            public void blueLight() {
                System.out.println("임시로 만드는 무궁화 꽃");
            }

            @Override
            public void redLight() {
                System.out.println("임시로 피었습니다 ");
            }
        });
    }
}
