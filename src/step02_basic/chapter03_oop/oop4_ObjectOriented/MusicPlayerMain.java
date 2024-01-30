package step02_basic.chapter03_oop.oop4_ObjectOriented;

public class MusicPlayerMain {
/*
    Object-Oriented Programming
 */
    public static void main(String[] args) {

        MusicPlayerData musicPlayerData = new MusicPlayerData();

        musicPlayerData.toggle();

        musicPlayerData.volumeUp();
        musicPlayerData.volumeUp();

        musicPlayerData.volumeDown();

        musicPlayerData.showStatus();

        musicPlayerData.toggle();
        musicPlayerData.showStatus();
    }
}
