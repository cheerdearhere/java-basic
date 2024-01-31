package step02_basic.chapter04_constructor.ex.constructor1Question;

public class Book {
    String title; //제목
    String author; //저자
    int page; //페이지 수

    public Book(){
        this("","",0);
    }
    public Book(String title,String author,int page){
        this.title = title;
        this.author = author;
        this.page = page;
    }
    public Book(String title, String author){
        this(title,author,0);
    }



    protected void displayInfo(){
        System.out.printf("제목: %s, 저자: %s, 페이지: %d%n",title,author,page);
    }
}
