package step05_designPatterns.strategy.before;

public class BlueLightRedLight {
    private int speed;
    public void blueLight(int speed){
        this.speed = speed;
        if(speed == 1){
            System.out.println("무   궁    화        꽃    이    ...");
        } else if(speed == 2){
            System.out.println("무   궁   화      꽃  이    ...");
        }  else if(speed == 3){
            System.out.println("무ㄱ화  꽃이 ...");
        } else{
            System.out.println("무       궁        화                  꽃           이    ...");
        }
    }
    public void redLight(int speed){
        this.speed = speed;
        if(speed == 1){
            System.out.println("피       었        습       니               다.");
        } else if(speed == 2){
            System.out.println("피  었   습  니    다.");
        }  else if(speed == 3){
            System.out.println("핏슴다");
        } else{
            System.out.println("        피        었          습       니               다.");
        }

    }
}
