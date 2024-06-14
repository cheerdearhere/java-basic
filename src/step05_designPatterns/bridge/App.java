package step05_designPatterns.bridge;

import step05_designPatterns.bridge.after.Ari;
import step05_designPatterns.bridge.after.KDA;
import step05_designPatterns.bridge.after.Kaisa;
import step05_designPatterns.bridge.after.PoolParty;
import step05_designPatterns.bridge.before.Champion;

public class App {
    public static void main(String[] args) {
        Champion kdaAri = new Ari(new KDA());
        kdaAri.skillQ();
        kdaAri.move();
        kdaAri.skillR();

        Champion poolPartyKaisa = new Kaisa(new PoolParty());
        poolPartyKaisa.skillQ();
        poolPartyKaisa.move();
        poolPartyKaisa.skillR();
    }
}
