
[코드 위치](../../src/step03_middleClass/chapter08_ExceptionHandling) 

# I. 예외 처리가 필요한 이유
## A. 예제 프로그램
- 목적: 사용자의 입력을 받아 입력받은 문자를 외부 서버에 전송하는 프로그램
- 제한 
  - 실제 네트워크 처리는 포함하지 않음
  - `connect()`를 우선 호출
  - `connect()`가 실패하면 `send(data)` 불가
  - 전송이 완료되거나 오류 등으로 사용을 끝낼 때 `disconnect()`로 반드시 연결 종료
- 프로그램 구성도
![프로그램 구성도](../img/middle/Example_ExceptionHandling.png)
  - `NetworkClient`: 외부 서버와 연결하고, 데이터를 전송하고, 연결을 종료하는 기능
  - `NetworkService`: `NetworkClient`를 사용해 데이터를 전송. 연결, 전송, 연결 종료와 같은 흐름을 제어
  - `Main`: 사용자의 입력을 받음
- workflow: 
  - `Main`에서 사용자의 입력을 받아 `NetworkService`에 전달
  - `NetworkService`는 `NetworkClient`를 사용해 외부 서버와 연결, 데이트 전달, 연결 종료를 진행
- NetworkService 예시 코드: [여기](../../src/step03_middleClass/chapter08_ExceptionHandling/example01_firstModule)
- 실행 예시
```
전송할 문자(종료:exit): hello
http://example.com 서버에 연결 성공
http://example.com 서버에 데이터 전송: hello
http://example.com 서버 연결 해제

전송할 문자(종료:exit): exit
프로그램을 정상 종료합니다. 
```
- 이후 점진적으로 발전 시켜나갈 예정
## B. 오류상황 만들기
- 외부 서버와 통신시 예상가능한 문제
  - 외부 서버와 연결에 실패
    - 네트워크 오류
    - 물리적 장비 오류
    - 기타 사유
  - 데이터 전송에 문제가 발생한다
    - 일시적 이상
    - 데이터 연동 실패 
    - 수신 측 에러
    - 데이터 이상 등등
- 오류상황을 위한 시뮬레이션
  - 연결 실패: 사용자 입력 문자에 "error1"이 있으면 연결에 실패. 오류코드는 "connectError"
  - 전송 실패: 사용자 입력 문자에 "error2"가 있으면 데이터 전송에실패. 오류 코드는 "sendError"
- 코드: [여기](../../src/step03_middleClass/chapter08_ExceptionHandling/example02_occurredError)
  - 에러 확인만 가능
  - 오류사항
    - 에러발생시 이후 과정이 멈춰야함
  - 추가 요구사항
    - 오류 발생시 오류에 대한 로그를 남겨야함
## C. 반환값으로 예외처리
- 요구사항
  - 연결 실패시 데이터 전송을 진행하면 안됨
  - 오류 로그를 남겨야함
- 코드: [여기](../../src/step03_middleClass/chapter08_ExceptionHandling/example03_useReturnValue)
  - 로그를 남기고 return으로 빠져나가게 함
- 팁
  - 조건문을 복잡하게 하기보다 메서드로 분리가 좋음
```java
    private boolean isError(String resultMessage){
        return !resultMessage.equals(NetworkStatus.SUCCESS.getStatusName());
    }
```
- 오류사항
  - 어떠한 경우에도 `disconnect()`로 연결 종료가 일어나야하나 안됨
    - error1은 연결이 안됐으니(그래도 disconnect해야 함) 그렇다 쳐도 error2는 연결이 된상황에서 네트워크 자원을 계속 소모한다
    - 자바 내부의 연결(인스턴스 연결 등)은 JVM의 GC가 사용하지 않는 연결을 해제하고 제거하지만 자바 외부 연결에는 접근할 수없다.
    - 자원 누수가 계속 일어나면 서버가 멈춰 리셋해야하는 경우가 많다. 
  - return으로 중단시키지 않고 조건문을 중첩해서 사용
```java
    client.initError(data);
    String connectResult = client.connect();
    if(isError(connectResult)) {
        System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_CONNECTED.getStatusName()+"): "+NetworkStatus.FAIL_CONNECTED.getStatusName());
    }else {
        String sendResult = client.send(data);
        if(isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_SEND.getStatusName()+"): "+NetworkStatus.FAIL_SEND.getStatusName());
        }
    }
    client.disconnect();
```
## D. 정상흐름과 예외흐름
- 현재 코드는 정상흐름과 예외 흐름이 분리되어있지 않다.
  - 흐름이 분리되지 않은 코드는 복잡한 비즈니스 코드에 적용되면 가독성을 낮추고 혼란을 만든다. 
  - 가장 중요한 것이 정상흐름이지만 갈수록 예외처리는 더 복잡해지기 마련이다. 
- 정상흐름
```java
client.initError(data);
client.connect();
client.send(data);
client.disconnect();
```
- 오류흐름
```java
client.initError(data);
String connectResult = client.connect();
if(isError(connectResult)) {
    System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_CONNECTED.getStatusName()+"): "+NetworkStatus.FAIL_CONNECTED.getStatusName());
}
else{
    String sendResult = client.send(data);
    if(isError(sendResult)) {
        System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_SEND.getStatusName()+"): "+NetworkStatus.FAIL_SEND.getStatusName());
    }
}
client.disconnect();
```
- 이러한 예외를 자바에서는 어떻게 예외를 처리하고 있는지 알아보자
# II. 자바의 예외처리 
# III. 예외처리 도입하기
# IV. 예외 계층
# V. 실무에서 예외처리 예
# VI. try-with-resource
