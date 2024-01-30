package step02_basic.chapter03_oop.oop4_ObjectOriented;

public class MusicPlayerData {
    int volume = 0;
    boolean isOn = false;

    protected void toggle(){
        isOn = !isOn;
        System.out.println(isOn?"음악 플레이어를 시작합니다.":"음악 플레이어를 종료합니다.");
    }
    protected void volumeUp(){
        volume++;
        System.out.println("음악 플레이어 볼륨: "+volume);
    }
    protected void volumeDown(){
        volume--;
        System.out.println("음악 플레이어 볼륨: "+volume);
    }
    protected void showStatus(){
        System.out.println("음악 플레이어 상태 확인");
        if(isOn){
            System.out.println("음악 플레이어 ON, 현재 볼륨: "+volume);
        }else{
            System.out.println("음악 플레이어 OFF");
        }
    }
}
