package step02_basic.chapter03_oop.oop3_useMethod;

public class MusicPlayerMain {
/*
    Class를 도입해 데이터 관리하기
 */
    public static void main(String[] args) {

        MusicPlayerData musicPlayerData = new MusicPlayerData();
        //플레이어 켜기
        on(musicPlayerData);
        //볼륨 키우기
        volumeUp(musicPlayerData);
        //볼륨 키우기
        volumeUp(musicPlayerData);
        //볼륨 줄이기
        volumeDown(musicPlayerData);
        //플레이어 상태 표시
        showStatus(musicPlayerData);
        //플레이어 끄기
        off(musicPlayerData);
    }
    static void on(MusicPlayerData data){
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }
    static void off(MusicPlayerData data){
        data.isOn =false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
    static void volumeUp(MusicPlayerData data){
        data.volume++;
        System.out.println("음악 플레이어 볼륨: "+data.volume);
    }
    static void volumeDown(MusicPlayerData data){
        data.volume--;
        System.out.println("음악 플레이어 볼륨: "+data.volume);
    }
    static void showStatus(MusicPlayerData data){
        System.out.println("음악 플레이어 상태 확인");
        if(data.isOn){
            System.out.println("음악 플레이어 ON, 현재 볼륨: "+data.volume);
        }else{
            System.out.println("음악 플레이어 OFF");
        }
    }
}
