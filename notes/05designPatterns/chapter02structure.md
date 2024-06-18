
- 구조적인 패턴(Structural Patterns): 만들어내는 패턴과 달리 구조적 패턴

# I. Adepter
- 서로 맞지 않는 두 대상을 연결하기 위해 중간에서 연결을 중재하는 역할
  - 220V 냉장고 - 변압기(어댑터) - 110V 코드
- 클라이언트가 사용하는 인터페이스와 기존 코드의 인터페이스가 다를때 이를 조정해주는 역할
- 주로 기존 코드를 클라이언트가 사용하는 인터페이스에 맞게 구현체(Adeptee)로 변경
- ex) security package와 account package(Adeptee)의 간극을 매워줄 어댑터 구성이 필요
![어댑터 패턴](../img/designPatterns/adepter.png)
## A. Adepter 만들기
- client가 어떤 인터페이스를 사용하는지 확인
  - client: LoginHandler
  - 사용 중인 인터페이스: UserDetailsService
- [Account와 User 연결하기](../../src/step05_designPatterns/adapter/after/AccountUserDetailsService.java)
    - 서드 파티 앱을 만들때 타겟이나 이전 코드를 손댈 수 없을때 새로운 클래스를 만들어 사용
    - 인터페이스를 구현받아 사용
```java
public class AccountUserDetailsService implements UserDetailsService {

    AccountService accountService;
    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
```
```java
public class AccountUserDetails implements UserDetails {
    private Account account;
    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return this.account.getName();
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }
}
```
- 사용 예
```java
public static void main(String[] args) {
    // 동작 체크용
    AccountService accountService = new AccountService();
    UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
    LoginHandler loginHandler = new LoginHandler(userDetailsService);
    String login = loginHandler.login("admin", "admin");
    System.out.println(login);
}
```
- 직접 Account와 AccountService를 직접 수정할 수 있다면 UserDetails와 UserDetailsService를 직접 구현하도록함
    - 클래스를 줄여 복잡도를 줄일 수 있다
    - 단일책임 원칙에는 조금 위배
```java
public class Account implements UserDetails{...}
```
```java
public class AccountService implements UserDetailsService{...}
```
## B. 장점과 단점
- 장점
  - 기존 코드를 변경하지 않고 원하는 인터페이스 구현체를 만들어 사용할 수 있다. => OCP 
  - 기존 코드가 하던 일과 특정인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리할 수 있다 => SRP
- 단점
  - 새 클래스가 생겨 복잡도 증가. 경우에 따라서는 기존 코드가 해당 인터페이스를 구현하도록 수정하는 것이 좋은 선택일 때도 있다.
## C. java and spring
### 1. [java](../../src/step05_designPatterns/adapter/AdepterInJava.java)
- Collection 타입 사이의 어뎁터들
```java
    //Arrays.asList: Array -> List
    List<String> list = Arrays.asList("a", "b", "c");
    //List -> enumeration
    Enumeration<String> enumeration = Collections.enumeration(list);
    //enumeration -> ArrayList
    ArrayList<String> arrayList = Collections.list(enumeration);
```
- 입출력 관련 작업
```java
        try(
                // String -> InputStream
            InputStream is = new FileInputStream("input.txt");
                // InputStream -> InputStreamReader
            InputStreamReader isr = new InputStreamReader(is);
                // InputStreamReader -> BufferedReader
            BufferedReader reader = new BufferedReader(isr);
        ){
            System.out.println(reader.readLine());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
```
### 2. spring
- Spring security: User 관련 처리는 대부분 어댑터
- Spring MVC의 HandlerAdapter: 자주 사용하는 controller(어노테이션을 지닌 컨트롤러)만 아니라 다양한 핸들러가 존재한다
  - `protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException...`
  - 핸들러는 Object를 받아 탐색하므로 다양한 종류로 구성될 수 있다. 
  - HandlerAdapter interface를 직접 구현해서 사용 가능: request와 response를 받아 ModelAndView를 반환하는 메서드
    - `ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;`
```java
protected void doDispatch(HttpServletRequest request, HttpSerletResponse response) throws Exception{
    HttpServletRequest processedRequest = request;
    HandlerExecutionChain mappedHandler = null;
    boolean multipartRequestParsed = false;
    WebAsyncManager asyncManager = WebAsyncUtils.gewtAsyncManager(request);
    
    try{
        try{
            ModelAndView mv = null;
            Exception dispatchException = null;
            
            try{
                processedRequest = this.checkMultipart(request);
                multipartRequestParsed = processedRequest != request;
                mappedHandler = this.getHandler(processedRequest);
                if(mappedHandler==null){
                    this.noHandlerFound(processedRequest, request);
                    return;
                }
                
                //핸들러를 처리할 수 있는 핸들러를 찾아 처리
                HandlerAdapter ha = this.getHandlerAdapter(mapperHandler.getHandler());
                String method = request.getMethod();
                boolean isGet = HttpMethod.GET.matches(method);
                if(isGet||HttpMethod.HEAD.matches(method)){
                    long lastModified = ha.getLastModified(request, mapperedHandler.getHandler());
                    if((new ServletWebRequest(request,response)).checkNoModified(lastModified) && isGet){
                        return;
                    }
                    if(!mappedHandler.applyPreHandle(precessedRequest, response)){
                        return; 
                    }
                    //찾은 핸들러가 요청을 처리 -> ModelAndView 호환
                    mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
                    if(asyncManager.isConcurrentHandlingStarted()){
                        return;
                    }
                    
                    this.applyDefaultViewName(processedRequest, mv);
                    mappedHandler.applyPostHandle(processedRequest, response, mv);
                }catch(Exception var20){
                    dispatchException = var20;
                }catch(Throwable var21){
                    dispatchException = new ServletException("Handler dispatch failed: "+var21, var21);
                }
                
                this.processDispatchRequest(processedRequest, response, mappedHandler, mv, (Exception)dispatchException);
            }
        }catch (Exception var22) {
            this.triggerAfterCompletion(processedRequest,response,mappedHandler, var22);
        }catch (Throwable var23){
            this.triggerAfterCompletion(processedRequest,response,mappedHandler, new ServletException("Handler processing failed: "+var23, var23));
        }
    }catch (Exception e){
        throw new RuntimeException(e);
    }
}
```

# II. Bridge 
- 추상적인 것과 구체적인 것 사이의 브릿지를 분리하여 연결
- 상속이 아닌 composition()
- 하나의 계측구조일때보다 나눴을때 독립적인 계층구조로 발전 시킬 수 있다. 
  - 서로 성격이 상이한 것을 분리해 관리하도록함. 
  - 그들을 연결시킴
- client는 간접적으로 추상적인 대상을 사용
- ex)
![브릿지](../img/designPatterns/bridge.png)
- Abstraction, Refined Abstraction: 추상적 확장
- Implementation: 구체적 코드를 갖도록 하고 구체적 Concrete Implementation으로 구현
- [예시 코드](../../src/step05_designPatterns/bridge/before)
  - 단층인 경우 너무 많은 클래스가 생성됨. 
  - 스킨이 추가된 경우 또 추가되어야 함(중복 코드가 너무 많아짐)
- 종류에 따라 분리해 구현하고 관리하도록함
## A. [적용](../../src/step05_designPatterns/bridge/after)
- 챔피언, 스킨 추가에도 다른 쪽이나 클라이언트에 영향(변경)을 주지 않고 확장 가능
- 반복 코드 최소화
- 의존성 주입을 통해 생성자를 거치지않게 하면 더욱 간략히 사용할 수 있다.
```java
public static void main(String[] args) {
    Champion kdaAri = new Ari(new KDA());
    kdaAri.skillQ();
    kdaAri.move();
    kdaAri.skillR();

    Champion poolPartyKaisa = new Kaisa(new PoolParty());
    poolPartyKaisa.skillQ();
    poolPartyKaisa.move();
    poolPartyKaisa.skillR();
}
```
## B. 장점과 단점 
- 장점
  - 추상적인 코드를 구체적인 코드 변경 없이 독립적으로 확장할 수 있다 
  - 추상적인 코드와 구체적인 코드를 분리하여 관리할 수 있다
  - 코드 재사용성을 높힐 수 있다 
- 단점
  - 계층 구조가 늘어나 복잡도가 증가할 수 있다. 
## C. java and spring
### 1. java
- JDBC: 구체적 코드는 driver에 위치하지만 사용자(client)는 인터페이스를 사용해 편하게 조정한다
```java
public static void main(String[] args) throws ClassNotFoundException {
    //JDBC
    Class.forName("org.h2.Driver");//구체적 코드 위치


    //추상적 브릿지 사용
    try (
            Connection conn = DriverManager.getConnection(
                    "jdbc:h2:mem:~/test",
                    "sa",
                    ""
            )
    ) {

        String sql = "CREATE TABLE ACCOUNT " +
                "(" +
                "id INTEGER NOT NULL AUTO_INCREMENT, " +
                "email VARCHAR(255), " +
                "name VARCHAR(255), " +
                "address VARCHAR(255), " +
                "PRIMARY KEY ( id )" +
                ")";

        Statement statement = conn.createStatement();
        statement.execute(sql);

//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery(sql);

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}
```
- Slf4j: 추상화된 로깅 퍼사드, 구체적 코드는 라이브러리에 있음
```java
public class Slf4jExample{
    // 추상화된 인터페이스 LoggerFactory, Logger
    private static Logger logger = LoggerFactory.getLogger(Slf4jExample.class);
    // 구체적 코드는 사용하는 로거 코드가 따로 선택
    public static void main(String[] args){
        logger.info("hello logger");
    }
}
```
### 2. spring
- Portable Service Abstraction: 환경의 변화와 관계없이 일관된 방식으로 기술로 접근 환경을 제공
  - MailSender
    ```java
    MailSender mailSender = new JavaMailSenderImpl();
    ```
  - PlatformTransactionManager: 다양한 TransactionManager들(구체적으로 처리된 인터페이스)
    ```java
    PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();
    ```
    - ex) [TransactionTemplate](https://docs.spring.io/spring-framework/reference/data-access/transaction/programmatic.html)


# III. Composite
- 전체 계층 구조와 부분적 객체를 client 입장에서 동일하게 취급하는 방식
- Part-Whole Hierarchy: client 입장에서 전체, 부분 모두 동일한 컴포넌트로 인식
- 트리 구조로 구성된 대상에 적용
  - 의외로 자주 사용됨
- [ex)](../../src/step05_designPatterns/composite/before/Client.java) 
![composite](../img/designPatterns/composite.png)
- client의 코드에 굳이 없어도 될 코드들이 들어있음
  - Bag, Item이 주체인 기능의 코드들이 코드에 있어야함
  - 다른 객체들이 추가되면 또 다른 정보가 client에 속해 복잡해짐
- Leaf, Composite, Component
## A. [적용](../../src/step05_designPatterns/composite/after/Client.java)
- Component > Composite, Leaf > Client
  - 중요한 것은 이름이 아니라 공통된 operation
  - Client에 너무 과도한 정보를 주지 않고 객체별 단일 책임을 최대한 지켜줌
- 역할
  - `Item`: Leaf
  - `Bag`: Composite
  - `Component`
- 어떤 대상으로하고 어떻게 연산할지는 인터페이스에 책임을 전달
```java
//어떤 대상을 사용할지는 중요하지 않음
private void printPrice(Component component) {
    System.out.println("price: " + component.getPrice());
}
```
## B. 장단점
- 장점
  - 복잡한 트리 구조를 편리하게 사용할 수 있다
    - 데이터 구조를 제각각 client에 노출 시켜 혼란을 주지 않고 하나의 Component interface로  공통된 operation을 등장시킨다.
  - 새로운 타입의 leaf, composite의 출현에 대해 client가 굳이 대응할 필요가 없다
    - 확장에는 열려있고 변경에는 닫혀있음
  - 다형성과 재귀를 활용할 수 있다
- 단점
  - 공통된 operation method를 지닌 트리를 만들어야하기 때문에(공통된 인터페이스를 정의해야 하기 때문에) 지나치게 일반화 해야하는 경우도 생길 수 있다.
    - 타입 체크를 위해 코드 내부에서 다른 연산이 필요한 경우 다른 방향이 필요한건 아닌지 점검 필요
    - 지나친 매몰은 오히려 패턴의 사용의 단점이 될 수 있다.
## C. java
- [Swing library](../../src/step05_designPatterns/composite/JavaSwingExample.java): java로 desktop 프로그램을 만드는 라이브러리
  - JFrame(composite) > Frame > Window > `Container` > `Component`
  - JTextField(leaf) > JTextComponent > JComponent > `Container` > `Component`
  - JButton(leaf) > AbstractButton > JComponent > `Container` > `Component`
- JSF(java server faces): 컴포넌트 기반 웹 화면 만드는 라이브러리

# IV. Decorator
- 기존 코드를 변경하지 않고 부가 기능을 추가할 수 있는 유용한 패턴
  - 상속이 아닌 위임을 사용해서 유연하게 부가기능을 추가
    - static -> compile time
    - dynamic -> run time
- [ex)](../../src/step05_designPatterns/decorator/before)
![decorator](../img/designPatterns/decorator.png)
- comment 출력.
- 새로운 기능을 추가하고 싶을때: CommentService를 확장(상속)한 TrimmingCommentService
  - Client 코드의 변경이 필요 -> 고정적으로 선택이 필요
  - 단일 상속만 가능하므로 두 기능을 한번에 사용할 수 없음
  - 플래그(needSpamFilter, needTrimming)를 사용해서 그에 맞게 처리? 
    - 두 플래그가 필요한 경우 어떻게? 
## A. 적용
- 여러 컴포넌트를 사용하던 것과 달리 하나의 컴포넌트를 사용. 
  - 구체적 사용은 Decorator(wrappee로 Component를 가짐)와 Concrete Decorator로 구성됨.
- 인터페이스로 우선 공통 기능을 지정하고 내부 연산을 분리
- [예시](../../src/step05_designPatterns/decorator/after)
- decorator interface
```java
public class CommentDecorator implements CommentService{
    private final CommentService commentService;
    public CommentDecorator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void addComment(String comment) {
        commentService.addComment(comment);
    }
}
```
- concrete decorator
```java
public class TrimmingCommentDecorator extends CommentDecorator {
    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }
    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }
    private String trim(String comment) {
        return comment.replace("...","");
    }
}
```
- Client(App)
  - 여기서는 조건문으로 분기를 처리했으나 Spring에서는 Bean을 사용
```java
public static void main(String[] args) {
    CommentService commentService = new DefaultCommentService();
    //상황에 따른 동적 처리
    if(enableSpamFilter) {
        commentService = new SpamFilteringCommentDecorator(commentService);
    }
    if(enableTrimming) {// decorator가 서로 덮혀있음
        commentService = new TrimmingCommentDecorator(commentService);
    }
    Client client = new Client(commentService);
    client.writeComment("오징어 게임");
    client.writeComment("백문이불여...");
    client.writeComment("http://www.never.co.kr");
}
```
## B. 장단점
- 장점
  - 새로운 클래스 생성 없이 기존 클래스를 조합해 사용 가능: SRP
  - 컴파일 타임이 아닌 런타임에 동적으로 기능을 확장할 수 있다. : OCP
    - flag 변경이 되면 그에 따라 처리되므로 동적으로 확인
    - 두 기능을 동시에 선택도 가능
- 단점
  - 데코레이터를 조합하는 코드(App)가 복잡해진다
    - 물론 모든 디자인패턴이 지닌 것
## C. java and spring
### 1. java
- adepter pattern 예제 중 IO에서 
  - InputStream > InputStreamReader > BufferReader 인터페이스가 중첩해 감쌈
- generic을 사용하지 않고 `Collections`에서 [checked~ 메서드](../../src/step05_designPatterns/decorator/DecoratorInJava.java): 타입 체크를 진행하도록 데코레이터로 감싸 타입 캐스트 에러를 발생시킴
  - 마찬가지로 멀티스레드 환경을 위한 동시성 처리가 된 `synchronized~` method
  - 불변 컬랙션 객체로 취급 처리하는 `unmodified~` method
### 2. spring
- Servlet request, response의 wrapper들: 확장 시킬 수 있음. 대상을 커스터마이징할 수 있음
  - `HttpServletRequestWrapper`, `HttpServletResponseWrapper`
  - `ServerHttpRequestDecorator`, `ServerHttpResponseDecorator`
  - `WebFilter`
- `BeanDefinitionDecorator`: 직접 사용할 일은 거의 없음
# V. Facade
- 불어로 '건물의 전경'
- 디테일한 것은 잘 보이지 않게 숨김
- [ex)](../../src/step05_designPatterns/facade/before) 
![facade pattern](../img/designPatterns/facade.png)
- client에 상세 코드를 노출시키지 않고 기능만 표시해야함
- 하나의 클래스에 의존성이 너무 높음
## A. [적용](../../src/step05_designPatterns/facade/after)
- 인터페이스, 내부 기능(메서드)으로 내부의 코드를 숨김
- 메일을 보내는 객체와 메세지를 담당할 객체로 나눔
- 조삼모사라 생각할 수 있겠지만 기능이 추가되거나 다른 곳에서 기능을 사용하는 경우 코드의 재사용성을 줄일 수 있다.
```java
  EmailSettings emailSettings = new EmailSettings();
  emailSettings.setHost(host);
  EmailSender emailSender = new EmailSender(emailSettings);
  
  EmailMessage emailMessage = new EmailMessage();
  emailMessage.setSubject(subject);
  emailMessage.setFrom(from);
  emailMessage.setTo(to);
  emailMessage.setText(text);
  emailMessage.setCc("hongil@mail.com");
  emailMessage.setBcc("gallam@mail.com");
  
  emailSender.sendEmail(emailMessage);
```
## B. 장점과 단점
- 장점
  - 서브 시스템에 대한 의존성을 한 곳으로 모을 수 있다. 
  - 사용자가 이해하는데 어려움이 적다
- 단점
  - 퍼사드로 서브시스템을 옮긴 것일뿐 큰 차이가 없어보일 수 있다. 
## C. java and spring
- 브릿지 패턴의 예제들. 
- 다양한 인터페이스, 기능을 간략화해서 사용하도록함 
```java
public static void main(String[] args) {
  MailSender mailSender = new JavaMailSenderImpl();
  
  PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();
}
```
- 코드에 대한 의존성을 최소화할때 사용

# VI. Flyweight
- 경량급: 자주 변하는 속성(extrinsit, 외적인 속성)과 변하지 않는 속성(intrinsit, 내적인 속성)을 분리해 코드의 재사용성을 증진시킨다
- [ex)](../../src/step05_designPatterns/flyweight/before/Client.java)
![flyweight](../img/designPatterns/flyweight.png)
## A. 적용하기
- [코드](../../src/step05_designPatterns/flyweight/after)
- 변하지 않는 fontFamily, fontSize => intrinsit
```java
public final class Font {
    private final String family;
    private final int size;
    Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public String getFamily() {
        return family;
    }

    public int getSize() {
        return size;
    }
}
```
- 계속 변경되는 value, color => extrinsit
```java
public class Character {
    private char value;
    private String color;
    Font font;//flyweight instance
    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
    public char getValue() {
        return value;
    }
    public void setValue(char value) {
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Font getFont() {
        return font;
    }
    public void setFont(Font font) {
        this.font = font;
    }
}
```
- flyweight 객체를 생성할 factory
```java
public class FontFactory {
    private Map<String, Font> cache = new HashMap<>();
    public Font getFont(String fontName) {
        if(cache.containsKey(fontName)) {
            return cache.get(fontName);
        }
        else {
            String[] fontSplit = fontName.split(":");
            Font newFont = new Font(fontSplit[0], Integer.parseInt(fontSplit[1]));
            cache.put(fontName, newFont);
            return newFont;
        }
    }
}
```
- 인스턴스를 많이 만들때 유용
```java
public static void main(String[] args) {
    FontFactory fontFactory = new FontFactory();
    Character c1 = new Character('g',"red",fontFactory.getFont("nanum:12"));
    Character c2 = new Character('o',"red",fontFactory.getFont("nanum:12"));
    Character c3 = new Character('l',"red",fontFactory.getFont("nanum:12"));
    Character c4 = new Character('d',"red",fontFactory.getFont("nanum:12"));
}
```
## B. 장단점
- 장점
  - 중복되는 데이터도 또 제각각 생성해서 낭비되는 메모리를 아낄 수 있다. 
  - 생성하는 인스턴스의 양이 많을 수록 효율이 좋다
- 단점
  - 코드가 복잡해진다
## C. java and spring
- java
  - Wrapper의 valueOf() method: 자주  사용되는 값은 캐싱을해 메모리 낭비를 최소화
  - 자주쓰이는 값은 ==로 비교해도 가능
  - 단, 범위를 넘어선 경우 참조값으로 비교하므로 값 비교가 안된다. 
    - == 대신 equals() 사용

# V. Proxy