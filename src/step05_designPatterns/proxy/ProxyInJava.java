package step05_designPatterns.proxy;

import step05_designPatterns.proxy.useInterface.DefaultGameService;
import step05_designPatterns.proxy.useInterface.GameService;
import step05_designPatterns.proxy.useInterface.GameServiceProxy;

import java.lang.reflect.Proxy;

public class ProxyInJava {
    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }
    private void dynamicProxy(){
        GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }
    private GameService getGameServiceProxy(GameService gameService){
        return (GameService) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{GameService.class},
                (proxy,method,args)->{
                    System.out.println("dynamic proxy");
                    method.invoke(gameService, args);
                    System.out.println("end");
                    return null;
                }
            );
    }
}
