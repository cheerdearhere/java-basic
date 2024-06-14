package step05_designPatterns.bridge.before;

public class PoolParty_Ari implements Champion {
    @Override
    public void move() {
        System.out.println("PoolParty_Ari move");
    }

    @Override
    public void skillQ() {
        System.out.println("PoolParty_Ari Q");
    }

    @Override
    public void skillW() {
        System.out.println("PoolParty_Ari W");
    }

    @Override
    public void skillE() {
        System.out.println("PoolParty_Ari E");
    }

    @Override
    public void skillR() {
        System.out.println("PoolParty_Ari R");
    }
}
