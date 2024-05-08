package step03_middleClass.chapter07_InnerClass.test.ex02_librarySystem;

import java.util.stream.Stream;

public class Library {
    //members
    private final Book[] books;
    private int size;
    //constructor
    public Library(int size) throws Exception {
        if(size <= 0) {
            throw new Exception("error: 잘못된 입력 - "+size);
        }
        else if(size > 100) {
            throw new Exception("error: 너무 큰 수 - "+size);
        }
        else {
            this.size = 0;
            books = new Book[size];
        }
    }
    //public methods
    public void addBook(String title, String author){
        //검증로직 우선
        if(size >= books.length) System.out.println("도서관 저장 공간이 부족합니다. ");
        //정상로직 처리
        else books[size++] = new Book(title, author);
    }
    public void showBooks(){
        System.out.println("== 책 목록 출력 ==");
        if(size == 0) System.out.println("저장된 책이 없습니다.");
        else {
//            for(Book book: books){
//                book.printBookData();
//            }
            Stream.of(books).forEach(Book::printBookData);
        }
    }
    //private static nested class
    private static class Book{
        private final String title;
        private final String author;

        private Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        private void printBookData (){
            System.out.println("도서 제목: "+title + ", 저자: "+author);
        }
    }
}

