package step05_designPatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) {
        //set private constructor. and use method
//        //setting을 관리하는 인스턴스가 여러번 생성됨
//        Settings setting = new Settings();
//        Settings setting1 = new Settings();
//        //생성된 인스턴스들이 같지 않음
//        System.out.println("setting == setting1: "+ (setting == setting1));//false

        Settings setting = Settings.getInstance();
        Settings setting1 = Settings.getInstance();
        System.out.println("use getInstance : " + (setting == setting1));//true

    //싱글톤 깨뜨리기
        //use reflection
        try{
            Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Settings setting2 = constructor.newInstance();
            System.out.println("use reflection : " + (setting == setting2));//false
        }catch (NoSuchMethodException ne){
            ne.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //use serializable
        //직렬화
        Settings setting3 = Settings.getInstance();
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(setting3);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Settings setting4 = null;
        //역직렬화
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            setting4 = (Settings) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("serialization: " + (setting4 == setting3));//false

        //enum 사용하기
        SettingEnum setting5 = SettingEnum.INSTANCE;
        try{
            SettingEnum setting6 = null;
            //모든 생성자 가져오기
            Constructor<?>[] constructors = SettingEnum.class.getDeclaredConstructors();
            for(Constructor<?> constructor : constructors){
                constructor.setAccessible(true);
                setting6 = (SettingEnum) constructor.newInstance("INSTANCE");
                //enum에서 reflection 방지:  Cannot reflectively create enum objects
            }
            System.out.println("use reflection : " + (setting6==setting5));//false
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
