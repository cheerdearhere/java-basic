package step02_basic.chapter03_oop.oop2_useClass;

public class MusicPlayerMain {
/*
    Class를 도입해 데이터 관리하기
 */
    public static void main(String[] args) {

        MusicPlayerData musicPlayerData = new MusicPlayerData();
        //플레이어 켜기
        musicPlayerData.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
        //볼륨 키우기
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨: "+musicPlayerData.volume);
        //볼륨 키우기
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨: "+musicPlayerData.volume);
        //볼륨 줄이기
        musicPlayerData.volume--;
        System.out.println("음악 플레이어 볼륨: "+musicPlayerData.volume);
        //플레이어 상태 표시
        System.out.println("음악 플레이어 상태 확인");
        if(musicPlayerData.isOn){
            System.out.println("음악 플레이어 ON, 현재 볼륨: "+musicPlayerData.volume);
        }else{
            System.out.println("음악 플레이어 OFF");
        }
        //플레이어 끄기
        musicPlayerData.isOn =false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
}
