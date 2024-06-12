package step05_designPatterns.abstractFactory.after;

public interface ShipFactory {
    //default methods
    default Ship orderShip(String name, String email){
        validate(name,email);
        prepareFor(name);
        // 제작은 하위 클래스에 위임
        Ship ship = createShip();
        //notify
        sendEmailTo(email,ship);
        return ship;
    }

    //abstract methods
    Ship createShip();

    //private methods
    private void validate(String name, String email){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("배 이름을 지어주세요");
        }
        if(email==null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요");
        }
    }
    private void prepareFor(String name){
        System.out.printf("%s 만들 준비 중\n",name);
    }
    private void sendEmailTo(String email, Ship ship){
        System.out.printf("to %s: \n\t %s 제작 완료. \n\t %s\n",email,ship.getName(),ship);
    }
}
