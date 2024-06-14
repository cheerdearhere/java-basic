package step05_designPatterns.bridge.before;

public class KDA_Ari implements Champion {
    @Override
    public void move() {
        System.out.println("KDA_Ari move");
    }

    @Override
    public void skillQ() {
        System.out.println("KDA_Ari Q");
    }

    @Override
    public void skillW() {
        System.out.println("KDA_Ari W");
    }

    @Override
    public void skillE() {
        System.out.println("KDA_Ari E");
    }

    @Override
    public void skillR() {
        System.out.println("KDA_Ari R");
    }
}
