
- 객체 생성과 관련된 패턴
# I. Singleton pattern
- 인스턴스를 `오직 한 개만` 제공하는 클래스
- 시스템 런타임, 환경 세팅에 대한 정보 등을 하나의 인스턴스로 생성해 글로벌하게 접근하도록 하는 방식
![singleton pattern](../img/designPatterns/singleton.png)

## A. 하나의 인스턴스를 사용해야하는 이유
- 여러 인스턴스는 각각의 정보를 담기때문에 일정한 정보가 유지되지 않는다
```java
public static void main(String[] args){
    //setting을 관리하는 인스턴스가 여러번 생성됨
    Settings setting = new Settings();
    Settings setting1 = new Settings();
    //생성된 인스턴스들이 같지 않음
    System.out.println("settings1 == settings2: "+ (settings1 == settings2));
}
```
- 일정한 상태를 유지하고 인스턴스를 반복해서 생성할 필요가 없는 경우 사용
## B. 가장 단순한 방법: 단일쓰레드에서만 사용
- 생성자 private
- 내부에 private instance 보관
- 그것을 관리하는 메서드 사용
```java
public class Settings {
    private static Settings instance;
    private Settings(){}
    public static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }
}
```
- 한계 
  - 멀티쓰레드 환경에서 안전하지 않음
    - ex) 동시에 접근하는 경우
      - 인스턴스가 null인 상태에서 여러쓰레드가 들어온 경우 둘다 null 상태이므로 둘다 if문 속 생성자에 접근가능
## C. 멀티쓰레드 환경에서 안전하게 구현하기
### 1. 동기화를 위한 `synchronized` 삽입
- 동시에 여러 스레드 접근 불가
```java
    public static synchronized Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }
```
- 단점: 동기화처리 작업으로 인해 성능이 느릴 수 있다
### 2. Eager initalization: 이른 초기화
- 객체를 미리 생성해두고 호출만 진행
- 클래스 정보가 메서드 영역에서 저장될때 미리 객체를 생성해 보관
```java
public class Settings {
    private static final Settings INSTANCE = new Settings();
    private Settings(){}
    public static Settings getInstance(){
//        if(instance == null){
//            instance = new Settings();
//        }
        return INSTANCE;
    }
}
```
- 단점: 인스턴스 생성이 무거운 경우 미리 만들어둘때 과도한 자원 소모가 일어남. 
- 인스턴스를 쓰지 않음에도 필요
### 3. double checked locking
- java 1.5 이상부터 사용가능
- `volatile`:  모든 스레드가 항상 같은 공유 변수의 값을 읽어올 수 있도록 보장
- 인스턴스 null checking을 두번 진행
```java
    //volatile: CPU의 휘발성 메모리에 넣어 공유변수 값을 읽어오도록
    private static volatile Settings instance;
    private Settings(){}
    public static Settings getInstance(){
        //null일때만 동기화처리 locking
        if(instance == null){ 
            // 동시에 두 스레드가 if문 진입해도 동기화락
            synchronized(Settings.class){
                if(instance == null){// 동기화 처리 상태에서 null check
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
```
### 4. static inner class: lazy initialization
- 정적 중첩 클래스를 사용해 인스턴스를 관리한다. 
- 권장되는 방식
```java
    private Settings(){}
    private static class SettingsHolder{
        private static final Settings INSTANCE = new Settings();
    }
    public static Settings getInstance(){
        return SettingsHolder.INSTANCE;
    }
```
- 싱글톤 패턴 구현 방법을 깨뜨리는 방법이 있음
## D. 싱글톤 패턴 구현방법을 깨뜨리는 방법
- 개발한 의도와 관계없이 사용자 측에서 깨뜨릴 수 있음
### 1. 리플렉션
```java
    //use reflection
    try{
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings setting2 = constructor.newInstance();
        System.out.println("use reflection : " + (settings == settings2));//false
    }catch (NoSuchMethodException ne){
        ne.printStackTrace();
    } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
    } catch (InstantiationException e) {
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
```
### 2. 직렬화 - 역직렬화 사용
- 우선 직렬화를 하려면 `Serializable` 인터페이스 구현
```java
public class Settings implements Serializable {...}
```
- 보통 직접 역직렬화를 쓰는 경우는 없으나 이런 경우가 있다는 점만 기억
```java
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
```
- 역직렬화 대응방안: create readResolve method
```java
    protected Object readResolve(){
        return getInstance();
    }
```
## E. Enum 사용
- 안전하고 단순하게 구현됨
- 리플렉션을 이용한 파괴를 방지
```java
    try{
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings setting6 = constructor.newInstance();
        System.out.println("use reflection : " + (setting6.equals(setting5)));//false
    }
```
## F. 혼자 정리해보기
- 자바에서 enum을 사용하지 않고 싱글톤 패턴을 구현하는 방법
- private 생성자와 static 메소드를 사용하는 방법의 단점
- enum을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점
- static inner class를 사용해 싱글톤 패턴을 구현
## G.java와 spring에서 찾아보는 패턴
# II. 