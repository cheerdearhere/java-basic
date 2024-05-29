package step04_middleClass2.chapter02_CollectionFramework.test.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
문제2 - 브라우저 히스토리 관리
BrowserHistoryTest 와 실행 결과를 참고해서 BrowserHistory 클래스를 완성하자.
브라우저의 방문 기록 관리 기능을 개발하자. 다음 기능을 개발해야 한다.
visitPage() : 특정 페이지 방문
goBack() : 뒤로가기 페이지를 표시하고, 실행 결과 현재 페이지 표시
뒤로가기는 가장 나중에 넣은 데이터가 먼저 나온다. 따라서 스택 구조를 고려하는 것이 좋다.
문제 설명
package collection.deque.test.stack;
public class BrowserHistoryTest {
 public static void main(String[] args) {
 BrowserHistory browser = new BrowserHistory();

 // 사용자가 웹페이지를 방문하는 시나리오
 browser.visitPage("youtube.com");
 browser.visitPage("google.com");
 browser.visitPage("facebook.com");
 // 뒤로 가기 기능을 사용하는 시나리오
 String currentPage1 = browser.goBack();
 System.out.println("currentPage1 = " + currentPage1);
 String currentPage2 = browser.goBack();
 System.out.println("currentPage2 = " + currentPage2);
 }
}

방문: youtube.com
방문: google.com
방문: facebook.com
뒤로 가기: facebook.com
currentPage1 = google.com
뒤로 가기: google.com
currentPage2 = youtube.com

BrowserHistory 코드 작성
package collection.deque.test.stack;
public class BrowserHistory {
 // 코드 작성
}
 */
public class BrowserHistory {
    private Deque<String> browserHistory = new ArrayDeque<>();
    private String currentPage=null;
    public void visitPage(String page) {
        browserHistory.push(page);
        currentPage=page;
        System.out.println("방문: "+currentPage);
    }
    public String goBack() {
        if(browserHistory.isEmpty()){
            System.out.println("error: 기록이 없습니다.");
            return currentPage;
        }
        currentPage=browserHistory.poll();
        System.out.println("뒤로 가기: "+currentPage);
        if(browserHistory.isEmpty()){
            System.out.println("error: 첫 페이지는 뒤로갈 수 없습니다.");
        }
        else{
            currentPage=browserHistory.peek();
        }
        return currentPage;
    }
}
