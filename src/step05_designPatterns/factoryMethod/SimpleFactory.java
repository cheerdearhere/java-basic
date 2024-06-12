package step05_designPatterns.factoryMethod;

import step05_designPatterns.factoryMethod.ex01_usePattern.BlackShip;
import step05_designPatterns.factoryMethod.ex01_usePattern.WhiteShip;

public class SimpleFactory {
    public Object createProduct(String name){
        if(name.equals("whiteship")){
            return new WhiteShip();
        }
        else if(name.equals("blackship")){
            return new BlackShip();
        }
        throw new IllegalArgumentException("no data");
    }
}
