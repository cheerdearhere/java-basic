package step05_designPatterns.factoryMethod;

public class ShipFactory {
    //validate
    public static Ship orderShip(String name, String email){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("배 이름을 지어주세요");
        }
        if(email==null || email.isBlank()){
            throw new IllegalArgumentException("연락처를 남겨주세요");
        }

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);

        //customizing for specific name
        if(name.equalsIgnoreCase("Whiteship")){
            ship.setLogo("\uD83D\uDEE5");
        }else if(name.equalsIgnoreCase("Blackship")){
            ship.setLogo("\uD8BD\uDEA5");
        }

        //coloring
        if(name.equalsIgnoreCase("Whiteship")){
            ship.setColor("white");
        }else if(name.equalsIgnoreCase("Blackship")){
            ship.setColor("black");
        }

        //notify
        sendEmailTo(email, ship);

        return ship;
    }
    private static void prepareFor(String name){
        System.out.printf("%s 만들 준비 중\n",name);
    }
    private static void sendEmailTo(String email, Ship ship){
        System.out.printf("to %s: \n\t %s 제작 완료. \n\t %s\n",email,ship.getName(),ship);
    }
}
